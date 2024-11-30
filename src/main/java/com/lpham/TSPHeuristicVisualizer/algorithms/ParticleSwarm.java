package com.lpham.TSPHeuristicVisualizer.algorithms;

import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;

public class ParticleSwarm implements AlgorithmTemplate {
    private ArrayList<City> solution;

    public ParticleSwarm(ArrayList<City> initialSolution) {
        this.solution = initialSolution;
    }

    @Override
    public ArrayList<City> solveSolution() {
        return null;
    }
}
