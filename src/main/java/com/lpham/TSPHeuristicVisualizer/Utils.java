package com.lpham.TSPHeuristicVisualizer;

import com.lpham.TSPHeuristicVisualizer.entities.Parameter;

import java.util.ArrayList;
import java.util.Objects;

import static com.lpham.TSPHeuristicVisualizer.Constants.*;

public class Utils {
    public static boolean checkParametersValidity(String algoType, ArrayList<Parameter> parameters) {
        if ((Objects.equals(algoType, localSearch) || Objects.equals(algoType, tabuSearch)) && parameters.size() == 1) {
            return Objects.equals(parameters.get(0).getName(), heuristicSearchParams);
        }

        if ((Objects.equals(algoType, simulatedAnnealing)) && parameters.size() == 2) {
            for (int i = 0; i < parameters.size(); i++) {
                if (!Objects.equals(parameters.get(i).getName(), simulatedAnnealingParams[i])) {
                    return false;
                }
            }

            return true;
        }

        if ((Objects.equals(algoType, antColony)) && parameters.size() == 4) {
            for (int i = 0; i < parameters.size(); i++) {
                if (!Objects.equals(parameters.get(i).getName(), antColonyParams[i])) {
                    return false;
                }
            }

            return true;
        }

        if ((Objects.equals(algoType, particleSwarmOptimization)) && parameters.size() == 3) {
            for (int i = 0; i < parameters.size(); i++) {
                if (!Objects.equals(parameters.get(i).getName(), particleSwarmOptimizationParams[i])) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
