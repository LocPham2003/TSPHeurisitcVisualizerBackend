package com.lpham.TSPHeuristicVisualizer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;

public class Solution {
    @JsonProperty("solution")
    private ArrayList<City> solution;
    @JsonProperty("cost")
    private double cost;

    public Solution(ArrayList<City> solution, double cost) {
        this.solution = solution;
        this.cost = cost;
    }
}
