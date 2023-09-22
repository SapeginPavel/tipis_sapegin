package com.example.tipis_sapegin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class CreateSeriesUtil {

    public static XYChart.Series createSinusSeries(int maxX, int sinusFrequency) {

        XYChart.Series series = new XYChart.Series();
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList(); //в data надо добавлять новые XYChart.Data

        int pointsForUnitSegment = 100;

        for (int i = 0;; i++) {
            double x = (i + 0.0) / pointsForUnitSegment;
            data.add(new XYChart.Data(x, Math.sin(x * 2 * Math.PI * sinusFrequency)));
            if (x == maxX) {
                break;
            }
        }
        series.setData(data);
        return series;
    }
 }
