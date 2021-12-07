package ua.nure.gaserver.selections;

import ua.nure.gaserver.entities.Population;

public class ConcurrentTournamentSelector implements Selector {
    @Override
    public void doSelection(Population population) {
//        List<Individual> offspring = new ArrayList<>(POPULATION_SIZE);
//        int i = POPULATION_SIZE;
//        if (ENABLE_ELITISM) {
//            i -= ELITE_SIZE;
//            individuals.stream()
//                    .sorted(Comparator.comparingInt(Individual::getFitness))
//                    .limit(ELITE_SIZE)
//                    .forEach(offspring::add);
//        }
//        Set<Callable<Individual>> tasks = Stream.generate(() -> (Callable<Individual>) () -> {
//            int i1 = 0, i2 = 0, i3 = 0;
//            ThreadLocalRandom random = ThreadLocalRandom.current();
//            while (i1 == i2 || i1 == i3 || i2 == i3) {
//                i1 = random.nextInt(POPULATION_SIZE);
//                i2 = random.nextInt(POPULATION_SIZE);
//                i3 = random.nextInt(POPULATION_SIZE);
//            }
//            Individual individual = Stream.of(individuals.get(i1), individuals.get(i2), individuals.get(i3))
//                    .min(Comparator.comparingInt(Individual::getFitness))
//                    .orElse(null);
//            return individual.clone();
//        })
//                .limit(i)
//                .collect(Collectors.toSet());
//        try {
//            offspring.addAll(ExecutorManager.executeSync(tasks));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return offspring;
//        return Collections.emptyList();
    }
}
