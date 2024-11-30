package com.lpham.TSPHeuristicVisualizer.controller;

import com.lpham.TSPHeuristicVisualizer.dto.Graph;
import com.lpham.TSPHeuristicVisualizer.dto.GraphAttributes;
import com.lpham.TSPHeuristicVisualizer.dto.Solution;
import com.lpham.TSPHeuristicVisualizer.dto.SolutionAttributes;
import com.lpham.TSPHeuristicVisualizer.service.GraphService;
import com.lpham.TSPHeuristicVisualizer.service.SolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.lpham.TSPHeuristicVisualizer.Constants.AVAILABLE_ALGO_TYPES;

@RestController
@RequestMapping("/solution")
public class SolutionController {
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Object> getSolution(@RequestBody SolutionAttributes solutionAttributes) {
        if (!AVAILABLE_ALGO_TYPES.contains(solutionAttributes.algoType())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid algorithm type");
        }
        SolutionService solutionService = new SolutionService(solutionAttributes);
        return ResponseEntity.status(HttpStatus.OK).body(solutionService.generateSolution());
    }
}
