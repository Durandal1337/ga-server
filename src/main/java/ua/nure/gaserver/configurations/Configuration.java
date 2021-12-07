package ua.nure.gaserver.configurations;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Configuration {
    public static final Random RANDOM = new Random(42);
    public static final boolean ENABLE_ELITISM = false;
    public static final int HALL_OF_FAME_SIZE = 1;
    public static final int CHROMOSOME_LENGTH = 25;
    public static final int POPULATION_SIZE = 500;
    public static final double P_CROSSOVER = 0.9;
    public static final double P_MUTATION = 0.1;
    public static final double P_MUTATION_OF_GEN = 0.1;
    public static final int MAX_GENERATIONS = 20;
    public static final int MAIN_NODE_INDEX = 0;
    public static final double[][] ADJACENCY_MATRIX = new double[CHROMOSOME_LENGTH][CHROMOSOME_LENGTH];
    public static final double[][] COORDINATES = {
            {205, 295},
            {194.5, 317},
            {219, 237},
            {259, 264},
            {165, 245},
            {175, 345},
            {114, 326},
            {134.5, 267},
            {287, 350},
            {201, 183},
            {77.5, 313},
            {272, 190},
            {146, 168},
            {312, 238},
            {109.5, 180},
            {340, 308},
            {365, 241},
            {372.5, 269},
            {158.5, 141},
            {323, 147},
            {83.5, 153},
            {206.5, 92},
            {361.5, 181},
            {232, 85},
            {288, 93}
    };
    public static final int SCALE = 1_000_000;
    public static final double COEFFICIENT_TO_CONVERT_DISTANCE_IN_KM = 0.000001;
    public static final double COST_PER_1_KM_OF_CANAL = 0.88;
    public static final double COST_PER_1_NODE = 16.3;
    public static final double MAIN_NODE_COST = 104.6;
    public static final double ADDITIONAL_NODE_COST = 4.9;
    public static final List<String> LABELS = Stream.iterate(0, i -> ++i)
            .map(i -> i == MAIN_NODE_INDEX ? "Main node" : "A" + i)
            .limit(CHROMOSOME_LENGTH)
            .collect(Collectors.toList());

}
