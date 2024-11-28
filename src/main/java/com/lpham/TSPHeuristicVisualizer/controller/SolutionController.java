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

@RestController
@RequestMapping("/solution")
public class SolutionController {
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Solution> getSolution(@RequestBody SolutionAttributes solutionAttributes) {
        SolutionService solutionService = new SolutionService(solutionAttributes);
        return new ResponseEntity<>(solutionService.generateSolution(), HttpStatus.OK);
    }

    @GetMapping("/index")
    public String index() {
        return "Greetings from solution!";
    }
}
