package ua.nure.gaserver.mutators;

import ua.nure.gaserver.entities.Population;

public interface Mutator {
    void mutate(Population population);
}
