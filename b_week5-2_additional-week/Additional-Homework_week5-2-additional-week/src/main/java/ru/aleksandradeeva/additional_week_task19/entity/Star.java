package ru.aleksandradeeva.additional_week_task19;

public class Star {
    String starName;
    Planet planet;

    public Star() {
    }

    public Star(String starName, Planet planet) {
        this.starName = starName;
    }

    public String getstarName() {
        return starName;
    }

    public void setstarName(String starName) {
        this.starName = starName;
    }


}
