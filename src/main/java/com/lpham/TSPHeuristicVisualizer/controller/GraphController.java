package com.lpham.TSPHeuristicVisualizer.controller;

import com.lpham.TSPHeuristicVisualizer.dto.Graph;
import com.lpham.TSPHeuristicVisualizer.dto.GraphAttributes;
import com.lpham.TSPHeuristicVisualizer.service.GraphService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/graph")
public class GraphController {

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Object> getGraph(@RequestBody GraphAttributes graphAttributes) {
        if (graphAttributes.numCities() > 100) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Number of cities exceeds 100");
        }
        GraphService graphService = new GraphService(graphAttributes);
        return ResponseEntity.status(HttpStatus.OK).body(graphService.generateGraph());
    }

    @GetMapping("/index")
    public String index() {
        return "Greetings from ur mom!";
    }

}