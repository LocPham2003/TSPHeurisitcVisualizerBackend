package com.lpham.TSPHeuristicVisualizer.repository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SolutionRepository {
    private int numNodes;

    public SolutionRepository(int numNodes) {
        this.numNodes = numNodes;
    }

    // Make a solution and solution must be valid (travelled through all nodes)
    public ArrayList<Integer> getSolution() {
        // Since we are assuming a complete graph, generating a random sequence of node indices should suffice
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> solution = new ArrayList<>();

        while (visited.size() != numNodes) {
            int nextCityIndex = new Random().nextInt(numNodes);
            while (visited.contains(nextCityIndex)) {
                nextCityIndex = new Random().nextInt(numNodes);
            }

            visited.add(nextCityIndex);
            solution.add(nextCityIndex);
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
