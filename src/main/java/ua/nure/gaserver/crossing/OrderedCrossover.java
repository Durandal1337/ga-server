package ua.nure.gaserver.crossing;

import ua.nure.gaserver.entities.Population;

import static ua.nure.gaserver.configurations.Configuration.*;

public class OrderedCrossover implements Crossover {
    @Override
    public void doCrossing(Population population) {
//        for (int i = 0; i < POPULATION_SIZE; i += 2) {
//            Individual individual = population.getIndividuals().get(i);
//            Individual individual1 = population.getIndividuals().get(i + 1);
//            if (ENABLE_ELITISM && (population.getHallOfFame().contains(individual) || population.getHallOfFame().contains(individual1)))
//                continue;
//            if (RANDOM.nextDouble() < P_CROSSOVER) {
//                for (int j = 1; j < CHROMOSOME_LENGTH; j++) {
//                    if (RANDOM.nextDouble() < P_GEN_CROSSOVER) {
//                        Set<Integer> pointsSet = new HashSet<>();
//                        while (pointsSet.size() < 2) {
//                            int point = RANDOM.ints(1, 1, CHROMOSOME_LENGTH).findFirst().orElse(0);
//                            pointsSet.add(point);
//                        }
//                        List<Integer> points = pointsSet
//                                .stream()
//                                .sorted()
//                                .collect(Collectors.toList());
//                        List<Integer> route = individual.getChromosome().get(j);
//                        List<Integer> route1 = individual1.getChromosome().get(j);
//                        Integer start = points.get(0);
//                        Integer end = points.get(1);
//                        List<Integer> subList = route.subList(start, end);
//                        List<Integer> subList1 = route1.subList(start, end);
//                        for (int k = start, l = 0; k < end; k++, l++) {
//                            route.set(k, subList1.get(l));
//                            route1.set(k, subList.get(l));
//                        }
//                        List<Integer> unorderedValues = Stream.iterate(1, integer -> ++integer)
//                                .limit(CHROMOSOME_LENGTH - 1)
//                                .filter(integer -> !subList1.contains(integer))
//                                .collect(Collectors.toList());
//                        Collections.shuffle(unorderedValues, RANDOM);
//                        List<Integer> unorderedValues1 = Stream.iterate(1, integer -> ++integer)
//                                .limit(CHROMOSOME_LENGTH - 1)
//                                .filter(integer -> !subList.contains(integer))
//                                .collect(Collectors.toList());
//                        Collections.shuffle(unorderedValues1, RANDOM);
//
//                        for (int k = 1, l = 0; k < CHROMOSOME_LENGTH; k++) {
//                            if (k >= start && k < end) continue;
//                            route.set(k, unorderedValues1.get(l));
//                            route1.set(k, unorderedValues.get(l));
//                            l++;
//                        }
//                    }
//                }
//            }
//        }
    }
}
