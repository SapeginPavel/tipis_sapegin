package com.example.tipis_sapegin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Controller {

    //todo: реализовать произвольный выбор конца

    List<LineChart> lineCharts = new ArrayList<>(4);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane mainPane;

    @FXML
    private LineChart<?, ?> lch1;

    @FXML
    private LineChart<?, ?> lch2;

    @FXML
    private LineChart<?, ?> lch3;

    @FXML
    private LineChart<?, ?> lch4;

    @FXML
    private Label labelFreq1;

    @FXML
    void onClickMenuClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onClickBuildSinusGraphs(ActionEvent event) {
        for (int i = 0; i < lineCharts.size(); i++) {
            lineCharts.get(i).getData().add(CreateSeriesUtil.createSinusSeries(Options.getMaxX(), Options.getFrequencies()[i]));
        }
    }

    @FXML
    void onClickBuildMeanderGraphs(ActionEvent event) {
        for (int i = 0; i < lineCharts.size(); i++) {
            lineCharts.get(i).getData().add(CreateSeriesUtil.createMeanderSeries(Options.getMaxX(), Options.getFrequencies()[i]));
        }
    }

    @FXML
    void onClickClearCharts(ActionEvent event) {
        for (LineChart l : lineCharts) {
            l.getData().clear();
        }
    }

    @FXML
    void initialize() throws Exception {
        lineCharts.add(lch1);
        lineCharts.add(lch2);
        lineCharts.add(lch3);
        lineCharts.add(lch4);

        if (lineCharts.size() != Options.getFrequencies().length) {
            throw new Exception("___The number of graphs drawn does not correspond to the number of specified frequencies___");
        }

        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'ui.fxml'.";

    }

}
