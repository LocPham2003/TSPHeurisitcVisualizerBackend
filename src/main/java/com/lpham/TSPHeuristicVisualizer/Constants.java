package com.lpham.TSPHeuristicVisualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static final String localSearch = "ls";
    public static final String tabuSearch = "ts";
    public static final String simulatedAnnealing = "sa";
    public static final String antColony = "ac";
    public static final String particleSwarmOptimization = "pso";

    public static final String heuristicSearchParams = "numIter";
    public static final String[] simulatedAnnealingParams = new String[]{"to", "c"};
    public static final String[] antColonyParams = new String[]{"alpha", "beta", "p", "q"};
    public static final String[] particleSwarmOptimizationParams = new String[]{"w", "c1", "c2"};

    public static final Set<String> AVAILABLE_ALGO_TYPES = new HashSet<>(Arrays.asList(localSearch, tabuSearch, simulatedAnnealing, antColony, particleSwarmOptimization));
}
