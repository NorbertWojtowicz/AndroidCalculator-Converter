package com.example.systemyliczbowe.kalkulator;

public class OperationAdd implements Operation {

    @Override
    public double execute(double l1, double l2) {
        return l1 + l2;
    }
}
