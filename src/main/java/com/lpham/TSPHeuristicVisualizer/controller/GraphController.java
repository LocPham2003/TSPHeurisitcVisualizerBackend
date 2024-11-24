package com.lpham.TSPHeuristicVisualizer.controller;

import com.lpham.TSPHeuristicVisualizer.dto.Graph;
import com.lpham.TSPHeuristicVisualizer.dto.GraphAttributes;
import com.lpham.TSPHeuristicVisualizer.service.GraphService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/graph")
public class GraphController {

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Graph> getGraph(@RequestBody GraphAttributes graphAttributes) {
        GraphService graphService = new GraphService(graphAttributes);
        return new ResponseEntity<>(graphService.generateGraph(), HttpStatus.OK);
    }

    @GetMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}