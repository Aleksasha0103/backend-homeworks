package ru.aleksandradeeva.additional_week_task19.entity;

public class Planet {
    String planetName;
    Star star;
    Moon moon;

    public Planet() {
    }

    public Planet(String planetName, Star star, Moon moon) {
        this.planetName = planetName;
    }

    public String getplanetName() {
        return planetName;
    }

    public void setplanetName(String getplanetName) {
        this.planetName = getplanetName;
    }
}
