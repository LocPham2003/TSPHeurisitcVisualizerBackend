package com.lpham.TSPHeuristicVisualizer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;

public class Graph {
    @JsonProperty("cities")
    private ArrayList<City> cities;

    public Graph(ArrayList<City> cities) {
        this.cities = cities;
    }
}
