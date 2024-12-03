package com.lpham.TSPHeuristicVisualizer.controller;

import com.lpham.TSPHeuristicVisualizer.dto.SolutionAttribute;
import com.lpham.TSPHeuristicVisualizer.service.SolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.lpham.TSPHeuristicVisualizer.Constants.AVAILABLE_ALGO_TYPES;
import static com.lpham.TSPHeuristicVisualizer.Utils.checkParametersValidity;

@RestController
@RequestMapping("/solution")
public class SolutionController {
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Object> getSolution(@RequestBody SolutionAttribute solutionAttribute) {
        if (!AVAILABLE_ALGO_TYPES.contains(solutionAttribute.algoType())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid algorithm type");
        }

        if (!checkParametersValidity(solutionAttribute.algoType(), solutionAttribute.parameters())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid parameters for provided algorithm");
        }

        SolutionService solutionService = new SolutionService(solutionAttribute);
        return ResponseEntity.status(HttpStatus.OK).body(solutionService.generateSolution());
    }
}
