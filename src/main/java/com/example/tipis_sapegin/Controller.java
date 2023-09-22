package com.example.tipis_sapegin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane mainPane;

    @FXML
    private LineChart<?, ?> lch1;

    @FXML
    void onClickMenuClose(ActionEvent event) {
        System.exit(0);
    }

    //понять, как передать график на отдельный виджет
    //либо попытаться использовать какой-то виджет под размер 4 графиков чтоб
    //либо через координаты хардкодить

    @FXML
    void onClickBuildGraphs(ActionEvent event) {
        NumberAxis x1 = new NumberAxis();
        x1.setLabel("x");

        NumberAxis y1 = new NumberAxis();
        y1.setLabel("y");

        LineChart lineChart = new LineChart(x1, y1);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("sin(x)");
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();
        for (int i = 0; i < 20; i++){
            data.add(new XYChart.Data(i, Math.sin(i)));
        }

        series1.setData(data);

        lch1.getData().add(series1);

    }

    @FXML
    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'ui.fxml'.";


    }

}
