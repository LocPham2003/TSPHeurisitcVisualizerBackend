package com.lpham.TSPHeuristicVisualizer.entities;

public class Parameter {
    private String name;
    private double value;

    public Parameter(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
