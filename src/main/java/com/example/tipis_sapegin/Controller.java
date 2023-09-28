package com.example.tipis_sapegin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
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
    private Button buttonBuildGraphs;

    @FXML
    private Button buttonClearGraphs;

    @FXML
    private TextField fieldSampleRate;

    @FXML
    private ToggleGroup graphs;

    @FXML
    private Label labelFreq1;

    @FXML
    private Label labelFreq2;

    @FXML
    private Label labelFreq3;

    @FXML
    private Label labelFreq4;


    @FXML
    private Pane mainPane;

    @FXML
    private Pane windowSetSampleRate;

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
    private RadioButton radioButtonGraphsMeander;

    @FXML
    private RadioButton radioButtonGraphsSinus;




    //---------------- Функции ----------------





    @FXML
    void onClickMenuClose(ActionEvent event) {
        System.exit(0);
    }

    void clearCharts() {
        for (LineChart l : lineCharts) {
            l.getData().clear();
        }

        for (LineChart l : lineChartsRange) {
            l.getData().clear();
        }
        setLabelsValues(false);
    }

    @FXML
    void onClickChangeSampleRate(ActionEvent event) {
        showWindowSetSampleRate();
    }

    void showWindowSetSampleRate() {
        windowSetSampleRate.setVisible(true);
        fieldSampleRate.setText(Integer.toString(Options.getSampleRate()));
    }

    @FXML
    void onClickDiscardNewSampleRate(ActionEvent event) {
        windowSetSampleRate.setVisible(false);
    }

    @FXML
    void onClickApplyNewSampleRate(ActionEvent event) {
        windowSetSampleRate.setVisible(false);
        int newSampleRate = Integer.parseInt(fieldSampleRate.getText());
        Options.setSampleRate(newSampleRate);
        clearCharts();
    }


    @FXML
    void onClickButtonBuildGraphs(ActionEvent event) {
        if (radioButtonGraphsSinus.isSelected()) {
            for (int i = 0; i < lineCharts.size(); i++) {
                lineCharts.get(i).getData().add(CreateSeriesUtil.createSinusSeries(Options.getMaxX(), Options.getFrequencies()[i]));
            }
            buildSinusRangeGraphs();
        }
        if (radioButtonGraphsMeander.isSelected()) {
            for (int i = 0; i < lineCharts.size(); i++) {
                lineCharts.get(i).getData().add(CreateSeriesUtil.createMeanderSeries(Options.getMaxX(), Options.getFrequencies()[i]));
            }
            buildMeanderRangeGraphs();
        }
        setLabelsValues(true);
    }

    @FXML
    void onClickButtonClearGraphs(ActionEvent event) {
        clearCharts();
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
                l.setText("- Hz");
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
        assert buttonBuildGraphs != null : "fx:id=\"buttonBuildGraphs\" was not injected: check your FXML file 'ui.fxml'.";
        assert buttonClearGraphs != null : "fx:id=\"buttonClearGraphs\" was not injected: check your FXML file 'ui.fxml'.";
        assert fieldSampleRate != null : "fx:id=\"fieldSampleRate\" was not injected: check your FXML file 'ui.fxml'.";
        assert graphs != null : "fx:id=\"graphs\" was not injected: check your FXML file 'ui.fxml'.";
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
        assert radioButtonGraphsMeander != null : "fx:id=\"radioButtonGraphsMeander\" was not injected: check your FXML file 'ui.fxml'.";
        assert radioButtonGraphsSinus != null : "fx:id=\"radioButtonGraphsSinus\" was not injected: check your FXML file 'ui.fxml'.";
        assert windowSetSampleRate != null : "fx:id=\"windowSetSampleRate\" was not injected: check your FXML file 'ui.fxml'.";


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

        windowSetSampleRate.setVisible(false);

        if (lineCharts.size() != Options.getFrequencies().length) {
            throw new Exception("___The number of graphs drawn does not correspond to the number of specified frequencies___");
        }
    }

}
