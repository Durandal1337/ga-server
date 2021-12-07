package ua.nure.gaserver.mutators;

import ua.nure.gaserver.entities.Population;

public class ConcurrentBitInversionMutator implements Mutator {
    @Override
    public void mutate(Population population) {
//        Set<Callable<Individual>> tasks = individuals.stream().map(individual -> (Callable<Individual>) () -> {
//            ThreadLocalRandom random = ThreadLocalRandom.current();
//            if (random.nextDouble() < P_MUTATION_OF_CHROMOSOME) {
//                List<Integer> chromosome = individual.getChromosome()
//                        .stream()
//                        .map(gen -> {
//                            if (random.nextDouble() < P_MUTATION_OF_GEN) {
//                                return gen == 0 ? 1 : 0;
//                            }
//                            return gen;
//                        })
//                        .collect(Collectors.toList());
//                individual.setChromosome(chromosome);
//            }
//            return individual;
//        })
//                .collect(Collectors.toSet());
//        try {
//            ExecutorManager.executeSync(tasks);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
