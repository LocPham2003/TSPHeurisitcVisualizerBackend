package com.lpham.TSPHeuristicVisualizer.dto;

import com.lpham.TSPHeuristicVisualizer.entities.City;
import java.util.ArrayList;

public record SolutionAttributes(ArrayList<City> cities, String algoType) {
}
