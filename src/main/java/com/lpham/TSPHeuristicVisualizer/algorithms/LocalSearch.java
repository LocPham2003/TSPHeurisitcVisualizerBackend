package com.lpham.TSPHeuristicVisualizer.algorithms;

import com.lpham.TSPHeuristicVisualizer.dto.Solution;
import com.lpham.TSPHeuristicVisualizer.entities.City;
import com.lpham.TSPHeuristicVisualizer.entities.Parameter;
import com.lpham.TSPHeuristicVisualizer.repository.SolutionRepository;

import java.util.ArrayList;
import java.util.Random;

public class LocalSearch implements AlgorithmTemplate {
    private ArrayList<City> solution;
    private ArrayList<Parameter> parameters;
    public LocalSearch(ArrayList<City> initialSolution, ArrayList<Parameter> parameters) {
        this.solution = initialSolution;
        this.parameters = parameters;
    }

    @Override
    public Solution solveSolution() {
        int numCities = solution.size();
        int numIter = (int) parameters.get(0).getValue();

        for (int i = 0; i < numIter; i++) {
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

        return new Solution(this.solution, SolutionRepository.getSolutionCost(this.solution));
    }
}
