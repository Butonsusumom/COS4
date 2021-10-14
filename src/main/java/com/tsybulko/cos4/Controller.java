package com.tsybulko.cos4;

import com.tsybulko.cos4.calculations.Corellation;
import com.tsybulko.cos4.calculations.FastCorrelation;
import com.tsybulko.cos4.calculations.Signal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

import java.net.URL;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    LineChart<Number,Number> Signal1;
    @FXML
    LineChart<Number,Number> Signal2;
    @FXML
    LineChart<Number,Number> AutoSignal;
    @FXML
    Text SimpleF;
    @FXML
    Text SimpleT;
    @FXML
    Text FastF;
    @FXML
    Text FastT;
    @FXML
    Text AutoT;

    Signal signal1 = new Signal(10,2,0);
    Signal signal2 = new Signal(7,5,Math.PI);

    ArrayList<Double> arrSignal1 = new ArrayList<>();
    ArrayList<Double> arrSignal2 = new ArrayList<>();

    Corellation simpleCorrelation = new Corellation();
    FastCorrelation fastCorrelation = new FastCorrelation();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();

        for(int i = 0; i < Signal.N; i++) {
            arrSignal1.add(signal1.generateHarmonicSignal(i));
            arrSignal2.add(signal2.generateHarmonicSignal(i));

            series1.getData().add(new XYChart.Data(i, arrSignal1.get(i)));
            series2.getData().add(new XYChart.Data(i, arrSignal2.get(i)));
        }

        Signal1.getData().add(series1);
        Signal2.getData().add(series2);

        processSimpleCorrelation();
        processFastCorrelation();
        processAutoCorreletion();
    }

    public void processSimpleCorrelation (){
        long m = System.currentTimeMillis();
        SimpleF.setText(Double.toString(simpleCorrelation.generate(arrSignal1,arrSignal2)));
        SimpleT.setText(Double.toString((double) (System.currentTimeMillis() - m)));
    }

    public void processFastCorrelation(){
        long m = System.currentTimeMillis();
        FastF.setText(Double.toString(fastCorrelation.generate(arrSignal1,arrSignal2)));
        FastT.setText(Double.toString((double) (System.currentTimeMillis() - m)));
    }

    public void processAutoCorreletion(){
        long m = System.currentTimeMillis();
        ArrayList<Double> autoArr = simpleCorrelation.autoCorrelation(arrSignal1);
        AutoT.setText(Double.toString((double) (System.currentTimeMillis() - m)));
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        for (int i=0; i<Signal.N;i++) {
            series.getData().add(new XYChart.Data(i, autoArr.get(i)));
        }
        AutoSignal.getData().add(series);
    }
}