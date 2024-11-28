package com.lpham.TSPHeuristicVisualizer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;

public class Solution {
    @JsonProperty("solution")
    private ArrayList<City> solution;

    public Solution(ArrayList<City> solution) {
        this.solution = solution;
    }
}
