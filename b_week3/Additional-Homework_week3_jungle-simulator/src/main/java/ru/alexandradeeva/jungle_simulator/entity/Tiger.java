package ru.alexandradeeva.jungle_simulator.entity;

public class Tiger {
    // health - начальное количество пунктов здоровья тигра Шер-Хана
    // energy - начальное количество пунктов энергии тигра Шер-Хана
    // energyValueCoefficientMeat - коэффициент энергетической ценности мяса (сколько энергии тигр получит, когда съест)
    // energyValueCoefficientFish - коэффициент энергетической ценности рыбы (сколько энергии тигр получит, когда съест)

    private int health = 100;
    private int energy = 100;
    private final double energyValueCoefficientMeat = 1.5;
    private final double energyValueCoefficientFish = 1.2;

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

    public double getEnergyValueCoefficientMeat() {
        return this.energyValueCoefficientMeat;
    }

    public double getEnergyValueCoefficientFish() {
        return this.energyValueCoefficientFish;
    }
}
