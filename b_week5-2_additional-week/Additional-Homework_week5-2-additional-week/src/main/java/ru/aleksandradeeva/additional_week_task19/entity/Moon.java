package ru.aleksandradeeva.additional_week_task19.entity;

public class Moon {
    String moonName;
    Planet planet;

    public Moon() {
    }

    public Moon(String moonName, Planet planet) {
        this.moonName = moonName;
    }

    public String moonName() {
        return moonName;
    }

    public void setmoonName(String moonName) {
        this.moonName = moonName;
    }
}
