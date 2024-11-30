package com.lpham.TSPHeuristicVisualizer.algorithms;

import com.lpham.TSPHeuristicVisualizer.entities.City;
import com.lpham.TSPHeuristicVisualizer.repository.SolutionRepository;

import java.util.ArrayList;
import java.util.Random;

public class LocalSearch implements AlgorithmTemplate {
    private ArrayList<City> solution;
    public LocalSearch(ArrayList<City> initialSolution) {
        this.solution = initialSolution;
    }

    @Override
    public ArrayList<City> solveSolution() {
        int numCities = solution.size();

        // Do 1000 iterations for now
        for (int i = 0; i < 1000; i++) {
            double currCost = SolutionRepository.getSolutionCost(this.solution);
            int firstCity = new Random().nextInt(numCities);
            int secondCity = new Random().nextInt(numCities);

            // Re-pick to make sure both cities are not the same
            while (firstCity == secondCity) {
                secondCity = new Random().nextInt(numCities);
            }

            ArrayList<City> tmp = new ArrayList<>(this.solution);
            City tmpCity = tmp.get(firstCity);
            tmp.set(firstCity, tmp.get(secondCity));
            tmp.set(secondCity, tmpCity);

            if (SolutionRepository.getSolutionCost(tmp) < currCost) {
                this.solution = tmp;
            }
        }

        System.out.println(SolutionRepository.getSolutionCost(this.solution));

        return this.solution;
    }
}
