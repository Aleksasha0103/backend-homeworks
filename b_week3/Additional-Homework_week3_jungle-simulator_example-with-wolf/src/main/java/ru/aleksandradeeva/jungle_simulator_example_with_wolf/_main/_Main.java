package ru.aleksandradeeva.jungle_simulator_example_with_wolf._main;

import ru.aleksandradeeva.jungle_simulator_example_with_wolf.entity.Wolf;
import ru.aleksandradeeva.jungle_simulator_example_with_wolf.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(wolf);
    }
}
