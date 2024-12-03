package com.lpham.TSPHeuristicVisualizer.algorithms;

import com.lpham.TSPHeuristicVisualizer.dto.Solution;
import com.lpham.TSPHeuristicVisualizer.entities.City;
import com.lpham.TSPHeuristicVisualizer.entities.Parameter;

import java.util.ArrayList;

public class ParticleSwarm implements AlgorithmTemplate {
    private ArrayList<City> solution;
    private ArrayList<Parameter> parameters;
    public ParticleSwarm(ArrayList<City> initialSolution, ArrayList<Parameter> parameters) {
        this.solution = initialSolution;
        this.parameters = parameters;
    }

    @Override
    public Solution solveSolution() {
        return new Solution(new ArrayList<>(), 0);
    }
}
