package com.lpham.TSPHeuristicVisualizer.repository;


import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SolutionRepository {
    private ArrayList<City> cities;

    public SolutionRepository(ArrayList<City> cities) {
        this.cities = cities;
    }

    // Make a solution and solution must be valid (travelled through all nodes)
    public ArrayList<City> getSolution() {
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

    public double getSolutionCost(ArrayList<Integer> solution, double[][] distance) {
        double cost = 0;
        for (int i = 0; i < solution.size() - 1; i++) {
            cost += distance[solution.get(i)][solution.get(i+1)];
        }

        return cost;
    }
}
