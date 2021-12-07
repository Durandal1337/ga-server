package ua.nure.gaserver.mutators;

import ua.nure.gaserver.entities.Population;

import java.util.List;

import static ua.nure.gaserver.configurations.Configuration.*;

public class BitInversionMutator implements Mutator {
    @Override
    public void mutate(Population population) {
        population.getIndividuals().forEach(individual -> {
            if (ENABLE_ELITISM && population.getHallOfFame().contains(individual)) return;
            if (RANDOM.nextDouble() < P_MUTATION) {
                List<Integer> chromosome = individual.getChromosome();
                for (int i = 0; i < chromosome.size(); i++) {
                    if (MAIN_NODE_INDEX == i) continue;
                    if (RANDOM.nextDouble() < P_MUTATION_OF_GEN) {
                        chromosome.set(i, chromosome.get(i) == 0 ? 1 : 0);
                    }
                }
            }
        });
    }
}
