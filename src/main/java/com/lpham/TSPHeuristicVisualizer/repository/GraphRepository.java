package com.lpham.TSPHeuristicVisualizer.repository;

import com.lpham.TSPHeuristicVisualizer.entities.City;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GraphRepository {
    private Set<Integer> generatedX = new HashSet<>();
    private Set<Integer> generatedY = new HashSet<>();

    private ArrayList<City> cities = new ArrayList<>();

    private double[][] distance;

    private int numNodes;
    private int[] boundaries;

    public GraphRepository(int numCities, int[] boundaries) {
        this.numNodes = numCities;
        this.boundaries = boundaries;
        this.distance = new double[numCities][numCities];
        generateDistance();
    }

    public void generateDistance() {
        // Generate the points
        for (int i = 0; i < numNodes; i++) {
            int x = new Random().nextInt(boundaries[0] - boundaries[1]);
            int y = new Random().nextInt(boundaries[0] - boundaries[1]);

            while (generatedX.contains(x) && generatedY.contains(y)) {
                x = new Random().nextInt(boundaries[0] - boundaries[1]);
                y = new Random().nextInt(boundaries[0] - boundaries[1]);
            }

            generatedX.add(x);
            generatedY.add(y);
            cities.add(new City(x, y));
        }

        // Generate edges weight
        for (int i = 0; i < numNodes; i++) {
            City currNode = cities.get(i);
            for (int j = 0; j < numNodes; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    City iterNode = cities.get(j);
                    distance[i][j] = (int) Math.abs(
                            Math.sqrt(
                                    Math.pow(currNode.getX() - iterNode.getX(), 2) +
                                            Math.pow(currNode.getY() - iterNode.getY(), 2))
                    );
                }
            }
        }
    }

    public double[][] getDistance() {
        return distance;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

}
