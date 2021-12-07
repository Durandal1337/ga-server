package ua.nure.gaserver.entities;

import ua.nure.gaserver.crossing.Crossover;
import ua.nure.gaserver.mutators.Mutator;
import ua.nure.gaserver.selections.Selector;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ua.nure.gaserver.configurations.Configuration.*;

public class Population {
    private List<Individual> individuals;
    private List<Individual> hallOfFame;

    public Population() {
        this.individuals = Stream.generate(Individual::new)
                .limit(POPULATION_SIZE)
                .collect(Collectors.toList());
    }

    public void run(Selector selector, Crossover crossover, Mutator mutator) {
        int generationCounter = 0;
        while (generationCounter < MAX_GENERATIONS) {
            generationCounter++;
            System.out.println("Generation " + generationCounter);
            calcFitness();
            System.out.println("Min fitness " + getMinFitness());
            selector.doSelection(this);
            crossover.doCrossing(this);
            mutator.mutate(this);
        }
        System.out.println("Solution found on " + generationCounter + "th generation with min fitness " + getMinFitness());
        System.out.println("Best individual " + getIndividualsWithMinFitness());
    }

    public void calcFitness() {
        individuals.forEach(Individual::calcFitness);
    }

    public double getMinFitness() {
        return individuals
                .stream()
                .map(Individual::getFitness)
                .min(Double::compareTo)
                .orElse(0d);
    }

    public Individual getIndividualsWithMinFitness() {
        return individuals
                .stream()
                .min(Comparator.comparingDouble(Individual::getFitness))
                .orElse(null);
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public List<Individual> getHallOfFame() {
        return hallOfFame;
    }

    public void setHallOfFame(List<Individual> hallOfFame) {
        this.hallOfFame = hallOfFame;
    }

    public void setIndividuals(List<Individual> individuals) {
        this.individuals = individuals;
    }
}
