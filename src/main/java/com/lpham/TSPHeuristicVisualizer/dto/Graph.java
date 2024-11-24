package com.lpham.TSPHeuristicVisualizer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;

public class Graph {
    @JsonProperty("cities")
    private ArrayList<City> cities;
    @JsonProperty("distances")
    private double[][] distances;

    public Graph(ArrayList<City> cities, double[][] distances) {
        this.cities = cities;
        this.distances = distances;
    }
}
