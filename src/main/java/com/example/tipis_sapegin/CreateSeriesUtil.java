package com.example.tipis_sapegin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class CreateSeriesUtil {

    public static XYChart.Series createSinusSeries(int numOfPoints, int sinusFrequency) {
        XYChart.Series series = new XYChart.Series();
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList(); //в data надо добавлять новые XYChart.Data
        for (int x = 0; x < numOfPoints; x++) {
            data.add(new XYChart.Data(x, Math.sin(x * sinusFrequency)));
        }
        series.setData(data);
        return series;
    }
 }
