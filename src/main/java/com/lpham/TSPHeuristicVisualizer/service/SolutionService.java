package com.lpham.TSPHeuristicVisualizer.service;

import com.lpham.TSPHeuristicVisualizer.dto.Solution;
import com.lpham.TSPHeuristicVisualizer.dto.SolutionAttributes;
import com.lpham.TSPHeuristicVisualizer.repository.SolutionRepository;

public class SolutionService {
    SolutionAttributes solutionAttribute;

    public SolutionService(SolutionAttributes solutionAttribute) {
        this.solutionAttribute = solutionAttribute;
    }

    public Solution generateSolution() {
        SolutionRepository solutionRepository = new SolutionRepository(this.solutionAttribute.cities());
        return new Solution(solutionRepository.getSolution());
    }

}
