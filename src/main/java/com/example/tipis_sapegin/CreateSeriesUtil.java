package com.example.tipis_sapegin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class CreateSeriesUtil {

    public static XYChart.Series createSinusSeries(int numOfPoints, int sinusFrequency) {
        XYChart.Series series = new XYChart.Series();
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList(); //в data надо добавлять новые XYChart.Data
        for (int x = 0; x < numOfPoints * 10; x++) {
            double x2 = x / 10.0;
            data.add(new XYChart.Data(x2 * Math.PI, Math.sin(x2 * Math.PI * sinusFrequency)));
        }
        series.setData(data);
        return series;
    }
 }
