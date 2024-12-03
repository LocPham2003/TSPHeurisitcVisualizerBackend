package com.lpham.TSPHeuristicVisualizer.dto;

import com.lpham.TSPHeuristicVisualizer.entities.City;
import com.lpham.TSPHeuristicVisualizer.entities.Parameter;

import java.util.ArrayList;

public record SolutionAttribute(ArrayList<City> cities, String algoType, ArrayList<Parameter> parameters) {
}
