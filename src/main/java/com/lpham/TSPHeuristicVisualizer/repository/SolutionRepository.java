package com.lpham.TSPHeuristicVisualizer.repository;


import com.lpham.TSPHeuristicVisualizer.algorithms.*;
import com.lpham.TSPHeuristicVisualizer.dto.Solution;
import com.lpham.TSPHeuristicVisualizer.entities.City;
import com.lpham.TSPHeuristicVisualizer.entities.Parameter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SolutionRepository {
    private ArrayList<City> cities;
    private String algoType;
    private ArrayList<Parameter> parameters;
    public SolutionRepository(ArrayList<City> cities, String algoType, ArrayList<Parameter> parameters) {
        this.cities = cities;
        this.algoType = algoType;
        this.parameters = parameters;
    }

    private ArrayList<City> initializeSolution() {
        // Since we are assuming a complete graph, generating a random sequence of node indices should suffice
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<City> solution = new ArrayList<>();

        int numCities = cities.size();

        while (visited.size() != numCities) {
            int nextCityIndex = new Random().nextInt(numCities);
            while (visited.contains(nextCityIndex)) {
                nextCityIndex = new Random().nextInt(numCities);
            }

            visited.add(nextCityIndex);
            solution.add(this.cities.get(nextCityIndex));
        }

        return solution;
    }

    // Make a solution and solution must be valid (travelled through all nodes)
    public Solution getSolution() {
        ArrayList<City> initialSolution = initializeSolution();

        return switch (this.algoType) {
            case "ls" -> new LocalSearch(initialSolution, this.parameters).solveSolution();
            case "ts" -> new TabuSearch(initialSolution, this.parameters).solveSolution();
            case "ac" -> new AntColony(initialSolution, this.parameters).solveSolution();
            case "sa" -> new SimulatedAnnealing(initialSolution, this.parameters).solveSolution();
            case "pso" -> new ParticleSwarm(initialSolution, this.parameters).solveSolution();
            default -> new Solution(new ArrayList<>(), 0);
        };
    }

    public static double getSolutionCost(ArrayList<City> solution) {
        double cost = 0;
        for (int i = 0; i < solution.size() - 1; i++) {
            double distance = Math.sqrt(Math.pow(solution.get(i).getX() - solution.get(i + 1).getX(), 2) +
                    Math.pow(solution.get(i).getY() - solution.get(i + 1).getY(), 2));
            cost += distance;
        }

        return cost;
    }
}
