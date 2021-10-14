package com.tsybulko.cos4.calculations;

public class Signal {
    public static final int N=512;
    private int A;
    private int f;
    private double phi;

    public Signal(int a, int f, double phi) {
        A = a;
        this.f = f;
        this.phi = phi;
    }

    public double generateHarmonicSignal(int n){
        return A*Math.sin(2*Math.PI*f*n/N+phi);
    }


}
