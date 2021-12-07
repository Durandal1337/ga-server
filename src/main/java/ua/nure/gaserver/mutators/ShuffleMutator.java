package ua.nure.gaserver.mutators;

import ua.nure.gaserver.entities.Population;

import static ua.nure.gaserver.configurations.Configuration.*;

public class ShuffleMutator implements Mutator {
    @Override
    public void mutate(Population population) {
//        population.getIndividuals().forEach(individual -> {
//            if (ENABLE_ELITISM && population.getHallOfFame().contains(individual)) return;
//            if (RANDOM.nextDouble() < P_MUTATION) {
//                for (int i = 1; i < individual.getChromosome().size(); i++) {
//                    if (RANDOM.nextDouble() < P_MUTATION_OF_GEN) {
//                        Collections.shuffle(individual.getChromosome().get(i), RANDOM);
//                    }
//                }
//            }
//        });
    }
}
