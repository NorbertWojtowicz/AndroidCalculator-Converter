package com.example.systemyliczbowe.Calculator;

public class Calculator {

    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double execute(double l1, double l2) {
        return operation.execute(l1, l2);
    }
}
