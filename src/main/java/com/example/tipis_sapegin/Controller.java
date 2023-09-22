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

//        XYChart.Series series = new XYChart.Series();
//        series.setName("sin(x)"); //пока не надо
//        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();
//        for (int i = 0; i < 20; i++){
//            data.add(new XYChart.Data(i, Math.sin(i)));
//        }
//
//        series.setData(data);

        int maxX = 50;
        try { //попытка снять maxX с графика
            NumberAxis axis = (NumberAxis) lch1.getXAxis();
            maxX = (int) axis.getUpperBound();
        } catch (Exception e) {

        }

        XYChart.Series s1 = CreateSeriesUtil.createSinusSeries(50, 1);
        lch1.getData().add(s1);

        XYChart.Series s2 = CreateSeriesUtil.createSinusSeries(50, 5);
        lch2.getData().add(s2);



    }

    @FXML
    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'ui.fxml'.";


    }

}
