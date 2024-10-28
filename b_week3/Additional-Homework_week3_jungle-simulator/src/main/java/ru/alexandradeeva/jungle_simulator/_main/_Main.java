package ru.alexandradeeva.jungle_simulator._main;

import ru.alexandradeeva.jungle_simulator.entity.Tiger;
import ru.alexandradeeva.jungle_simulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(tiger);
    }
}
