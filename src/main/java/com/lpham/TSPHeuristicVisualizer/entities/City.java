package com.lpham.TSPHeuristicVisualizer.entities;

public class City {
    private double x;
    private double y;

    public City(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setCoordinates(double[] coordinates) {
        this.x = coordinates[0];
        this.y = coordinates[1];
    }
}
