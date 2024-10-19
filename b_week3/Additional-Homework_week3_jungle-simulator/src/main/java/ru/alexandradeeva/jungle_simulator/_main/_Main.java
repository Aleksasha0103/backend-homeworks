package ru.alexandradeeva.jungle_simulator._main;

import ru.alexandradeeva.jungle_simulator.model.Wolf;
import ru.alexandradeeva.jungle_simulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(wolf);
    }
}
