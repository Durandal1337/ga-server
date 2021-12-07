package ua.nure.gaserver.services;

import org.springframework.stereotype.Service;
import ua.nure.gaserver.crossing.Crossover;
import ua.nure.gaserver.crossing.SinglePointCrossover;
import ua.nure.gaserver.entities.Population;
import ua.nure.gaserver.json.GraphRequest;
import ua.nure.gaserver.mutators.BitInversionMutator;
import ua.nure.gaserver.mutators.Mutator;
import ua.nure.gaserver.selections.Selector;
import ua.nure.gaserver.selections.TournamentSelector;
import ua.nure.gaserver.utils.DrawGraph;

import java.util.Map;

import static ua.nure.gaserver.configurations.Configuration.*;

@Service
public class GraphService {
    public Map<String, String> getGraph(GraphRequest graphRequest) {
        long l = System.currentTimeMillis();
        initAdjacencyMatrix();
        Population population = new Population();
        Selector selector = new TournamentSelector();
//        Selector selector = new ConcurrentTournamentSelector();
        Crossover crossover = new SinglePointCrossover();
//        Crossover crossover = new OrderedCrossover();
//        Crossover crossover = new ConcurrentSinglePointCrossover();
        Mutator mutator = new BitInversionMutator();
//        Mutator mutator = new ShuffleMutator();
//        Mutator mutator = new ConcurrentBitInversionMutator();
        population.run(selector, crossover, mutator);
        System.out.println("Method execution took " + (System.currentTimeMillis() - l) + " ms");
        return DrawGraph.draw(population.getIndividualsWithMinFitness());
    }

    private static void initAdjacencyMatrix() {
        for (int i = 0; i < COORDINATES.length; i++) {
            for (int j = i; j < COORDINATES.length; j++) {
                double[] a = COORDINATES[i];
                double[] b = COORDINATES[j];
                double distance = Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
                distance *= SCALE;
                distance *= COEFFICIENT_TO_CONVERT_DISTANCE_IN_KM;
                ADJACENCY_MATRIX[i][j] = distance;
                ADJACENCY_MATRIX[j][i] = distance;
            }
        }
    }
}
