package com.lpham.TSPHeuristicVisualizer.algorithms;

import com.lpham.TSPHeuristicVisualizer.dto.Solution;
import com.lpham.TSPHeuristicVisualizer.entities.City;
import com.lpham.TSPHeuristicVisualizer.entities.Parameter;

import java.util.ArrayList;

public class TabuSearch implements AlgorithmTemplate {
    private ArrayList<City> solution;
    private ArrayList<Parameter> parameters;
    public TabuSearch(ArrayList<City> initialSolution, ArrayList<Parameter> parameters) {
        this.solution = initialSolution;
        this.parameters = parameters;
    }

    @Override
    public Solution solveSolution() {
        return new Solution(new ArrayList<>(), 0);
    }
}
