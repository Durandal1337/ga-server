package ua.nure.gaserver.crossing;

import ua.nure.gaserver.entities.Population;

public class ConcurrentSinglePointCrossover implements Crossover {
    @Override
    public void doCrossing(Population population) {
//        Set<Callable<Void>> tasks = Stream.iterate(0, i -> i++)
//                .map(i -> (Callable<Void>) () -> {
//                    Individual individual = individuals.get(i);
//                    Individual individual1 = individuals.get(i + 1);
//                    ThreadLocalRandom random = ThreadLocalRandom.current();
//                    if (random.nextDouble() < P_CROSSOVER) {
//                        int point = random.ints(1, 1, CHROMOSOME_LENGTH)
//                                .findFirst()
//                                .orElse(0);
//                        List<Integer> tail = individual1.getChromosome().subList(point, CHROMOSOME_LENGTH);
//                        for (int j = point; j < CHROMOSOME_LENGTH; j++) {
//                            individual1.getChromosome().set(j, individual.getChromosome().get(j));
//                            individual.getChromosome().set(j, tail.get(j - point));
//                        }
//                    }
//                    return null;
//                })
//                .limit(POPULATION_SIZE)
//                .collect(Collectors.toSet());
//        try {
//            ExecutorManager.executeSync(tasks);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
