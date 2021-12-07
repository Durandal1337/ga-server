package ua.nure.gaserver.utils;

import ua.nure.gaserver.entities.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ua.nure.gaserver.configurations.Configuration.CHROMOSOME_LENGTH;
import static ua.nure.gaserver.configurations.Configuration.LABELS;

public class DrawGraph {
    public static Map<String, String> draw(Individual individual) {
        List<Integer> nodePositions = new ArrayList<>();
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            if (individual.getChromosome().get(i) == 1) nodePositions.add(i);
        }
        return Individual.getConnections(nodePositions).entrySet()
                         .stream()
                         .collect(Collectors.toMap(entry -> LABELS.get(entry.getKey()), entry -> LABELS.get(entry.getValue())));
    }
}
