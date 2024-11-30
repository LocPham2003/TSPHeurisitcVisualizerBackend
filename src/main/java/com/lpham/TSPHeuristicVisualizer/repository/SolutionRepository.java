package com.lpham.TSPHeuristicVisualizer.repository;


import com.lpham.TSPHeuristicVisualizer.algorithms.*;
import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SolutionRepository {
    private ArrayList<City> cities;
    private String algoType;
    public SolutionRepository(ArrayList<City> cities, String algoType) {
        this.cities = cities;
        this.algoType = algoType;
    }

    public ArrayList<City> initializeSolution() {
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
    public ArrayList<City> getSolution() {
        ArrayList<City> initialSolution = this.initializeSolution();

        return switch (this.algoType) {
            case "ls" -> new LocalSearch(initialSolution).solveSolution();
            case "ts" -> new TabuSearch(initialSolution).solveSolution();
            case "ac" -> new AntColony(initialSolution).solveSolution();
            case "sa" -> new SimulatedAnnealing(initialSolution).solveSolution();
            case "pso" -> new ParticleSwarm(initialSolution).solveSolution();
            default -> new ArrayList<>();
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
