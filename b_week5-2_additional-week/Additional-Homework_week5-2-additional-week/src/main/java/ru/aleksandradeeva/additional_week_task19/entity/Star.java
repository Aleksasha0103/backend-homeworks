package ru.aleksandradeeva.additional_week_task19.entity;

public class Star {
    private String starName;
    private int starWeight;

    public Star() {
    }

    public Star(String starName, int starWeight) {
        this.starName = starName;
        this.starWeight = starWeight;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public int getStarWeight() {
        return starWeight;
    }

    public void setStarWeight(int starWeight) {
        this.starWeight = starWeight;
    }

    @Override
    public String toString() {
        return "Звезда по имени " + starName + " весит " + starWeight + "т.";
    }


}
