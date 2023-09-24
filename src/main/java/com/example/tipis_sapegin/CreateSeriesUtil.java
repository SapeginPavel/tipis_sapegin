package com.example.tipis_sapegin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.Arrays;

public class CreateSeriesUtil {

    public static XYChart.Series createSinusSeries(int maxX, int sinusFrequency) {

        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();

        int pointsForUnitSegment = 100;

        for (int i = 0;; i++) {
            double x = (i + 0.0) / pointsForUnitSegment;
            data.add(new XYChart.Data(x, Math.sin(x * 2 * Math.PI * sinusFrequency)));
            if (x == maxX) {
                break;
            }
        }

        XYChart.Series series = new XYChart.Series();
        series.setName(Integer.toString(sinusFrequency));
        series.setData(data);

        return series;
    }

    public static XYChart.Series createMeanderSeries(int maxX, int meanderFrequency) {
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();

        double step = (1 + 0.0) / meanderFrequency / 2;
        int stepAmount = (int) (maxX / step) * 2;

        double x = 0;
        int y = 1;

        double[] xx = new double[stepAmount];
        double[] yy = new double[stepAmount];

        for (int i = 0; i < stepAmount; i++) {
            xx[i] = x;
            yy[i] =  y;
            data.add(new XYChart.Data(x, y));

            if (i % 2 == 0) {
                x += step;
            }

            if (i % 2 == 1) {
                y = (y == 1 ? 0 : 1);
            }
        }

        XYChart.Series series = new XYChart.Series();
        series.setData(data);

        return series;

    }
 }
