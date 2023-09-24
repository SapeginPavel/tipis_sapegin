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

    List<LineChart> lineCharts = new ArrayList<>(4);
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
    void onClickBuildSinusGraphs(ActionEvent event) {
        for (int i = 0; i < lineCharts.size(); i++) {
            lineCharts.get(i).getData().add(CreateSeriesUtil.createSinusSeries(Options.getMaxX(), Options.getFrequencies()[i]));
        }
        setLabelsValues(true);
    }

    @FXML
    void onClickBuildMeanderGraphs(ActionEvent event) {
        for (int i = 0; i < lineCharts.size(); i++) {
            lineCharts.get(i).getData().add(CreateSeriesUtil.createMeanderSeries(Options.getMaxX(), Options.getFrequencies()[i]));
        }
        setLabelsValues(true);
    }

    @FXML
    void onClickClearCharts(ActionEvent event) {
        for (LineChart l : lineCharts) {
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
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'ui.fxml'.";

        lineCharts.add(lch1);
        lineCharts.add(lch2);
        lineCharts.add(lch3);
        lineCharts.add(lch4);

        labels.add(labelFreq1);
        labels.add(labelFreq2);
        labels.add(labelFreq3);
        labels.add(labelFreq4);

        if (lineCharts.size() != Options.getFrequencies().length) {
            throw new Exception("___The number of graphs drawn does not correspond to the number of specified frequencies___");
        }
    }

}
