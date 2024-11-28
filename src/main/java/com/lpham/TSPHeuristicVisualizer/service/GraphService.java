package com.lpham.TSPHeuristicVisualizer.service;

import com.lpham.TSPHeuristicVisualizer.dto.Graph;
import com.lpham.TSPHeuristicVisualizer.dto.GraphAttributes;
import com.lpham.TSPHeuristicVisualizer.repository.GraphRepository;

public class GraphService {
    GraphAttributes graphAttributes;

    public GraphService(GraphAttributes graphAttributes) {
        this.graphAttributes = graphAttributes;
    }

    public Graph generateGraph() {
        GraphRepository graph = new GraphRepository(graphAttributes.numCities(), graphAttributes.boundaries());
        return new Graph(graph.getCities());
    }
}
