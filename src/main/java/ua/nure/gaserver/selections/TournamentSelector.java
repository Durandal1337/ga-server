package ua.nure.gaserver.selections;

import ua.nure.gaserver.entities.Individual;
import ua.nure.gaserver.entities.Population;

import java.util.*;
import java.util.stream.Collectors;

import static ua.nure.gaserver.configurations.Configuration.*;

public class TournamentSelector implements Selector {
    @Override
    public void doSelection(Population population) {
        List<Individual> individuals = population.getIndividuals();
        List<Individual> offspring = new ArrayList<>(POPULATION_SIZE);
        int i = 0;
        if (ENABLE_ELITISM) {
            i += HALL_OF_FAME_SIZE;
            List<Individual> hallOfFame = individuals.stream()
                    .sorted(Comparator.comparingDouble(Individual::getFitness))
                    .limit(HALL_OF_FAME_SIZE)
                    .peek(Individual::clone)
                    .collect(Collectors.toList());
            offspring.addAll(hallOfFame);
            population.setHallOfFame(hallOfFame);
        }
        for (; i < POPULATION_SIZE; i++) {
            Set<Integer> indexes = new HashSet<>();
            while (indexes.size() < 3) {
                int point = RANDOM.nextInt(POPULATION_SIZE);
                indexes.add(point);
            }

            Individual individual = indexes
                    .stream()
                    .map(individuals::get)
                    .min(Comparator.comparingDouble(Individual::getFitness))
                    .orElse(null);
            offspring.add(individual.clone());
        }
        population.setIndividuals(offspring);
    }
}
