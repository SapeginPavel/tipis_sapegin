package com.example.tipis_sapegin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Controller {

    //todo: реализовать произвольный выбор конца
    //todo: проверить частоту дискретизации = 1, 2

    List<LineChart> lineCharts = new ArrayList<>(4);
    List<LineChart> lineChartsRange = new ArrayList<>(4);
    List<Label> labels = new ArrayList<>(4);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane mainPane;

    @FXML
    private LineChart lch1;

    @FXML
    private LineChart lch2;

    @FXML
    private LineChart lch3;

    @FXML
    private LineChart lch4;

    @FXML
    private LineChart lchRange1;

    @FXML
    private LineChart lchRange2;

    @FXML
    private LineChart lchRange3;

    @FXML
    private LineChart lchRange4;

    @FXML
    private Label labelFreq1;

    @FXML
    private Label labelFreq2;

    @FXML
    private Label labelFreq3;

    @FXML
    private Label labelFreq4;

    @FXML
    void onClickMenuClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onClickBuildSinusGraphs(ActionEvent event) throws Exception {
        for (int i = 0; i < lineCharts.size(); i++) {
            lineCharts.get(i).getData().add(CreateSeriesUtil.createSinusSeries(Options.getMaxX(), Options.getFrequencies()[i]));
        }
//        ObservableList list = CreateSeriesUtil.createSinusSeries(Options.getMaxX(), Options.getFrequencies()[0]).getData();
//        System.out.println(list.size());
        setLabelsValues(true);
        buildSinusRangeGraphs();
    }

    @FXML
    void onClickBuildMeanderGraphs(ActionEvent event) {
        for (int i = 0; i < lineCharts.size(); i++) {
            lineCharts.get(i).getData().add(CreateSeriesUtil.createMeanderSeries(Options.getMaxX(), Options.getFrequencies()[i]));
        }
        setLabelsValues(true);
        buildMeanderRangeGraphs();
    }

    @FXML
    void onClickClearCharts(ActionEvent event) {
        for (LineChart l : lineCharts) {
            l.getData().clear();
        }

        for (LineChart l : lineChartsRange) {
            l.getData().clear();
        }
        setLabelsValues(false);
    }

    void setLabelsValues(boolean bool) {
        if (bool) {
            for (int i = 0; i < labels.size(); i++) {
                ObservableList<XYChart.Series> lists = lineCharts.get(i).getData();
                String name = lists.get(0).getName() + " Hz";
                labels.get(i).setText(name);
            }
        } else {
            for (Label l : labels) {
                l.setText("");
            }
        }
    }

    void buildSinusRangeGraphs() {
        for (int i = 0; i < lineChartsRange.size(); i++) {
            double[][] xyArr =  DFT.getXYForSinus(Options.getFrequencies()[i], Options.getSampleRate());
            double[] y = DFT.dft(xyArr[1], Options.getSampleRate());
            lineChartsRange.get(i).getData().add(CreateSeriesUtil.createSeriesForSinusRange(y));
        }
    }

    void buildMeanderRangeGraphs() {
        for (int i = 0; i < lineChartsRange.size(); i++) {
            double[][] xyArr =  DFT.getXYForMeander(Options.getFrequencies()[i], Options.getSampleRate());
            double[] y = DFT.dft(xyArr[1], Options.getSampleRate());
            lineChartsRange.get(i).getData().add(CreateSeriesUtil.createSeriesForSinusRange(y));
        }
    }

    @FXML
    void initialize() throws Exception {
        assert labelFreq1 != null : "fx:id=\"labelFreq1\" was not injected: check your FXML file 'ui.fxml'.";
        assert labelFreq2 != null : "fx:id=\"labelFreq2\" was not injected: check your FXML file 'ui.fxml'.";
        assert labelFreq3 != null : "fx:id=\"labelFreq3\" was not injected: check your FXML file 'ui.fxml'.";
        assert labelFreq4 != null : "fx:id=\"labelFreq4\" was not injected: check your FXML file 'ui.fxml'.";
        assert lch1 != null : "fx:id=\"lch1\" was not injected: check your FXML file 'ui.fxml'.";
        assert lch2 != null : "fx:id=\"lch2\" was not injected: check your FXML file 'ui.fxml'.";
        assert lch3 != null : "fx:id=\"lch3\" was not injected: check your FXML file 'ui.fxml'.";
        assert lch4 != null : "fx:id=\"lch4\" was not injected: check your FXML file 'ui.fxml'.";
        assert lchRange1 != null : "fx:id=\"lchRange1\" was not injected: check your FXML file 'ui.fxml'.";
        assert lchRange2 != null : "fx:id=\"lchRange2\" was not injected: check your FXML file 'ui.fxml'.";
        assert lchRange3 != null : "fx:id=\"lchRange3\" was not injected: check your FXML file 'ui.fxml'.";
        assert lchRange4 != null : "fx:id=\"lchRange4\" was not injected: check your FXML file 'ui.fxml'.";
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'ui.fxml'.";

        lineCharts.add(lch1);
        lineCharts.add(lch2);
        lineCharts.add(lch3);
        lineCharts.add(lch4);

        labels.add(labelFreq1);
        labels.add(labelFreq2);
        labels.add(labelFreq3);
        labels.add(labelFreq4);

        lineChartsRange.add(lchRange1);
        lineChartsRange.add(lchRange2);
        lineChartsRange.add(lchRange3);
        lineChartsRange.add(lchRange4);

        if (lineCharts.size() != Options.getFrequencies().length) {
            throw new Exception("___The number of graphs drawn does not correspond to the number of specified frequencies___");
        }
    }

}
