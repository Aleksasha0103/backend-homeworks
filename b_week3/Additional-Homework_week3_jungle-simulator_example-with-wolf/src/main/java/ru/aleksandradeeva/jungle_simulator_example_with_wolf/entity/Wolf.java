package ru.aleksandradeeva.jungle_simulator_example_with_wolf.entity;


public class Wolf {
    // 100 hp
    // 100 energy
    // коэффициент зубов (fangs) - сколько энергии волк получает, когда кого-то съест

    private int health = 100;
    private int energy = 100;
    private final double fangs = 2.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getFangs() {
        return this.fangs;
    }

}
