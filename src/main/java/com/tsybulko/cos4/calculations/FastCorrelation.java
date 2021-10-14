package com.tsybulko.cos4.calculations;

import java.util.ArrayList;

public class FastCorrelation {

    public static double generate(ArrayList<Double> arrX, ArrayList<Double> arrY) {
        double result = 0.0;
        double sumXY = 0.0;
        double sumX = 0.0;
        double sumY = 0.0;
        double sumX2 = 0.0;
        double sumY2 = 0.0;

        for (int i = 0; i < arrX.size(); i++) {
            sumXY += arrX.get(i) * arrY.get(i);
        }
        for (int i = 0; i < arrX.size(); i++) {
            sumX += arrX.get(i);
        }
        for (int i = 0; i < arrX.size(); i++) {
            sumY += arrY.get(i);
        }
        for (int i = 0; i < arrX.size(); i++) {
            sumX2 += arrX.get(i) * arrX.get(i);
        }
        for (int i = 0; i < arrX.size(); i++) {
            sumY2 += arrY.get(i) * arrY.get(i);
        }

        result = (double) (arrX.size()* sumXY - sumX * sumY)
                / Math.sqrt((arrX.size() * sumX2 - Math.pow(sumX, 2)) * (arrX.size() * sumY2 - Math.pow(sumY, 2)))/3;

        return result;
    }


}
