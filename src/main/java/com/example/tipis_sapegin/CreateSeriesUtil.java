package com.example.tipis_sapegin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;

public class CreateSeriesUtil {

    public static XYChart.Series createSinusSeries(int maxX, int sinusFrequency) {
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();
        int pointsForUnitSegment = 100;
        for (int i = 0;; i++) {
            double x = (i + 0.0) / pointsForUnitSegment;
            if (x == maxX) {
                break;
            }
            data.add(new XYChart.Data(x, Math.sin(x * 2 * Math.PI * sinusFrequency)));
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

        data.add(new XYChart.Data(0, 0));

        for (int i = 0; i < stepAmount; i++) {
            data.add(new XYChart.Data(x, y));

            if (i % 2 == 0) {
                x += step;
            }

            if (i % 2 == 1) {
                y = (y == 1 ? 0 : 1);
            }
        }

        XYChart.Series series = new XYChart.Series();
        series.setName(Integer.toString(meanderFrequency));
        series.setData(data);

        return series;
    }

    public static XYChart.Series createSeriesForRange(double[] y) {
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();
        for (int i = 0; i < y.length; i++) {
//            XYChart.Data da = new XYChart.Data(i, y[i] * 100);
//            if (y[i] * 100 > 1) { //лепим подсказки только на большие игреки
//                Node node = da.getNode();
//                Tooltip tooltip = new Tooltip('('+da.getXValue().toString()+';'+da.getYValue().toString()+')');
//                Tooltip.install(node, tooltip);
//            }
//            data.add(da);
            data.add(new XYChart.Data(i, y[i] * 100)); //множитель - для наглядности отображения
        }
//        data.forEach(d->{
//            Node node = d.getNode();
//            Tooltip tooltip = new Tooltip('('+d.getXValue().toString()+';'+d.getYValue().toString()+')');
//            Tooltip.install(node, tooltip);
//        });
        XYChart.Series series = new XYChart.Series();
        series.setData(data);
        return series;
    }
 }
