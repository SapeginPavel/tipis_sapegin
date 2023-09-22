package com.example.tipis_sapegin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
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
    private LineChart<?, ?> lch2;

    @FXML
    private LineChart<?, ?> lch3;

    @FXML
    private LineChart<?, ?> lch4;

    @FXML
    void onClickMenuClose(ActionEvent event) {
        System.exit(0);
    }

    //понять, как передать график на отдельный виджет
    //либо попытаться использовать какой-то виджет под размер 4 графиков чтоб
    //либо через координаты хардкодить

    @FXML
    void onClickBuildGraphs(ActionEvent event) {

        //setAutoRanging(false)
        int maxX = 3;

        lch1.getData().add(CreateSeriesUtil.createSinusSeries(maxX, 1));
        lch2.getData().add(CreateSeriesUtil.createSinusSeries(maxX, 2));
        lch3.getData().add(CreateSeriesUtil.createSinusSeries(maxX, 4));
        lch4.getData().add(CreateSeriesUtil.createSinusSeries(maxX, 8));

    }

    @FXML
    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'ui.fxml'.";


    }

}
