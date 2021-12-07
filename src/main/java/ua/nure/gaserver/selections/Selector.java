package ua.nure.gaserver.selections;

import ua.nure.gaserver.entities.Population;

public interface Selector {
    void doSelection(Population population);
}
