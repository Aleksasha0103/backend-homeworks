package ru.aleksandradeeva.jungle_simulator_example_with_wolf.util;

import ru.aleksandradeeva.jungle_simulator_example_with_wolf.entity.Wolf;

public class EventSimulator {
    // 0 - 40 // 40% // волк поспал - +7 энергии
    // 40 - 60 // 20% // волк просто пробежал - -5 энергии
    // волк съел зайца - -7 энергии; +8 здоровья
    // 60 - 80 // 20% // волк съел кабана - -10 энергии; coeff * 4 здоровья
    // 80 - 100  // 20% // на волка напал охотник = -20 здоровья
    // энергия = 0 - -5 здоровья

    public void startSimulation(Wolf wolf) {
        // 0.0 * 100 = 0
        // 1.0 * 100 = 100
        while (checkStatus(wolf)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber <= 40) {
                sleepEvent(wolf);
            } else if (eventNumber >= 40 && eventNumber < 60) {
                move(wolf);
            } else if (eventNumber >= 60 && eventNumber < 80) {
                eatPig(wolf);
            } else if (eventNumber >= 80 && eventNumber < 100) {
                hunterAttack(wolf);
            }
        }
        System.out.println("Оооо нееет! Волк умер!(");
    }


    private void sleepEvent(Wolf wolf) {
        int energy = wolf.getEnergy();
        energy = energy + 7;
        if (energy > 100) {
            energy = 100;
        }

        wolf.setEnergy(energy);
        checkEnergy(wolf);
        System.out.println("Волк поспал! +7 энергии. Текущий уровень энергии: " + wolf.getEnergy());
    }

    private void move(Wolf wolf) {
        int energy = wolf.getEnergy();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }

        wolf.setEnergy(energy);
        checkEnergy(wolf);
        System.out.println("Волк побегал впустую! -5 энергии. Текущий уровень энергии: " + wolf.getEnergy());
    }


    private void eatPig(Wolf wolf) {
        int energy = wolf.getEnergy();
        int health = wolf.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (wolf.getFangs() * 4);
        if (health > 100) {
            health = 100;
        }

        wolf.setEnergy(energy);
        wolf.setHealth(health);
        checkEnergy(wolf);
        System.out.println("Волк съел кабана! -5 энергии. Но улучшил своё здоровье. +8 здоровья. " +
                "Текущий уровень энергии: " + wolf.getEnergy() + ". Текущий уровень здоровья: " + wolf.getHealth());
    }

    private void hunterAttack(Wolf wolf) {
        int health = wolf.getHealth();
        health = health - 20;
        if (health < 0) {
            health = 0;
        }

        wolf.setHealth(health);
        checkEnergy(wolf);
        System.out.println("На волка напал охотник! -20 энергии. Текущий уровень здоровья: " + wolf.getHealth());
    }

    // true - продолжается симуляция
    // false - волк умер
    private boolean checkStatus(Wolf wolf) {
        System.out.println("Здоровье: " + wolf.getHealth() + ". Энергия: " + wolf.getEnergy() + ".");
        if (wolf.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void checkEnergy(Wolf wolf) {
        if (wolf.getEnergy() <= 0) {
            int health = wolf.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
        }
    }
}
