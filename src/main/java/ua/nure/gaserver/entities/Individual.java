package ua.nure.gaserver.entities;

import java.util.*;

import static ua.nure.gaserver.configurations.Configuration.*;

public class Individual implements Cloneable {
    private List<Integer> chromosome;
    private double fitness;

    public Individual() {
        chromosome = new ArrayList<>(CHROMOSOME_LENGTH);
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            int val;
            if (i == MAIN_NODE_INDEX) {
                val = 1;
            } else {
                val = RANDOM.nextInt(2);
            }
            chromosome.add(val);
        }
    }

    @Override
    public Individual clone() {
        Individual individual = new Individual();
        individual.setChromosome(new ArrayList<>(chromosome));
        individual.setFitness(fitness);
        return individual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return chromosome.equals(that.chromosome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chromosome);
    }

    @Override
    public String toString() {
        return chromosome.toString();
    }

    public void calcFitness() {
        double fitness = MAIN_NODE_COST;
        List<Integer> nodePositions = new ArrayList<>();
        for (int i = 0; i < chromosome.size(); i++) {
            if (chromosome.get(i) == 1) nodePositions.add(i);
        }
        int numberOfAdditionalNodes = nodePositions.size() - 1;
        fitness += numberOfAdditionalNodes * COST_PER_1_NODE;
        fitness += (CHROMOSOME_LENGTH - 1) * ADDITIONAL_NODE_COST;

        Map<Integer, Integer> connections = getConnections(nodePositions);

        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            Integer i = entry.getKey();
            Integer j = entry.getValue();
            fitness += ADJACENCY_MATRIX[i][j] * COST_PER_1_KM_OF_CANAL;
        }
        this.fitness = fitness;
    }

    public static Map<Integer, Integer> getConnections(List<Integer> nodePositions) {
        Map<Integer, Integer> connections = new HashMap<>();
        setNodeEdgesWithMinWeight(nodePositions, connections);
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            if (connections.containsKey(i)) continue;
            setAdditionalNodeEdgesWithMinWeight(i, nodePositions, connections);
        }
        return connections;
    }

    public static void setNodeEdgesWithMinWeight(List<Integer> nodePositions, Map<Integer, Integer> connections) {
        for (int i = 0; i < nodePositions.size(); i++) {
            Integer source = nodePositions.get(i);
            int minIndex = 0;
            double minWeight = Double.MAX_VALUE;
            for (int j = i+1; j < nodePositions.size(); j++) {
                Integer destination = nodePositions.get(j);
                if (connections.containsValue(source) || connections.containsValue(destination)) continue;
                double weight = ADJACENCY_MATRIX[source][destination];
                if (weight < minWeight) {
                    minIndex = destination;
                    minWeight = weight;
                }
            }
            connections.put(source, minIndex);
        }
    }

    public static void setAdditionalNodeEdgesWithMinWeight(Integer i, List<Integer> nodePositions,
                                                           Map<Integer, Integer> connections) {
        int minIndex = 0;
        double minWeight = Double.MAX_VALUE;
        for (int j = 0; j < nodePositions.size(); j++) {
            Integer destination = nodePositions.get(j);
            if (i.equals(destination)) continue;
            double weight = ADJACENCY_MATRIX[i][destination];
            if (weight < minWeight) {
                minIndex = destination;
                minWeight = weight;
            }
        }
        connections.put(i, minIndex);
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public List<Integer> getChromosome() {
        return chromosome;
    }

    public void setChromosome(List<Integer> chromosome) {
        this.chromosome = chromosome;
    }
}
