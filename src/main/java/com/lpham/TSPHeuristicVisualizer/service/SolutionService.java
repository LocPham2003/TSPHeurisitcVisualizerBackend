package com.lpham.TSPHeuristicVisualizer.service;

import com.lpham.TSPHeuristicVisualizer.dto.Solution;
import com.lpham.TSPHeuristicVisualizer.dto.SolutionAttribute;
import com.lpham.TSPHeuristicVisualizer.repository.SolutionRepository;

public class SolutionService {
    SolutionAttribute solutionAttribute;

    public SolutionService(SolutionAttribute solutionAttribute) {
        this.solutionAttribute = solutionAttribute;
    }

    public Solution generateSolution() {
        SolutionRepository solutionRepository = new SolutionRepository(this.solutionAttribute.cities(),
                this.solutionAttribute.algoType(), this.solutionAttribute.parameters());
        return solutionRepository.getSolution();
    }

}
