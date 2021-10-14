package com.tsybulko.cos4.calculations;

import java.util.ArrayList;

public class Corellation {

    public double generate(ArrayList<Double> signal1, ArrayList<Double> signal2) {

        Double sum = 0D;
        for (int i=0; i<Signal.N; i++){
            sum+=signal1.get(i)*signal2.get(i);
        }
        return sum/Signal.N;
    }

    public ArrayList<Double> autoCorrelation(ArrayList<Double> signal1){
        ArrayList<Double> R = new ArrayList<Double>();
        Double sum;

        for (int i=0;i<Signal.N;i++) {
            sum=0D;
            for (int j=0;j<Signal.N-i;j++) {
                sum+=signal1.get(j)*signal1.get(j+i);
            }
            R.add(sum);
        }
        return R;
    }
}
