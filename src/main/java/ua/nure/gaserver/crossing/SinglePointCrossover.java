package ua.nure.gaserver.crossing;

import ua.nure.gaserver.entities.Individual;
import ua.nure.gaserver.entities.Population;

import java.util.List;

import static ua.nure.gaserver.configurations.Configuration.*;

public class SinglePointCrossover implements Crossover {
    @Override
    public void doCrossing(Population population) {
        for (int i = 0; i < POPULATION_SIZE; i += 2) {
            Individual individual = population.getIndividuals().get(i);
            Individual individual1 = population.getIndividuals().get(i + 1);
            if (ENABLE_ELITISM && (population.getHallOfFame().contains(individual) || population.getHallOfFame().contains(individual1)))
                continue;
            if (RANDOM.nextDouble() < P_CROSSOVER) {
                int point = RANDOM.ints(1, 1, CHROMOSOME_LENGTH)
                        .findFirst()
                        .orElse(0);
                List<Integer> tail = individual1.getChromosome().subList(point, CHROMOSOME_LENGTH);
                for (int j = point; j < CHROMOSOME_LENGTH; j++) {
                    individual1.getChromosome().set(j, individual.getChromosome().get(j));
                    individual.getChromosome().set(j, tail.get(j - point));
                }
            }
        }
    }
}
