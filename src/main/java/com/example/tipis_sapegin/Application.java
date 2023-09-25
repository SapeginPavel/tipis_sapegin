package com.example.tipis_sapegin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tipis");
        stage.setScene(scene);
        stage.show();

//        double[] y = new double[1200]; // 300 точек в 1 периоде
//
//        for (int i = 0; i < y.length; i++) {
//
//        }
//        double maxX = 4;
//        int pointsForUnitSegment = 100;
//
//        for (int i = 0;; i++) {
//            double x = (i + 0.0) / pointsForUnitSegment;
//            y[i] = Math.sin(x * 2 * Math.PI * 4);
//            if (x == maxX) {
//                break;
//            }
//        }
//
//        DFT.dft(y, 300);
    }

    public static void main(String[] args) {
        launch();
    }
}