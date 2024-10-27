package ru.alexandradeeva.shipandfish;

public class Fish implements Swimmable {
    @Override
    public void swim() {
        eat();
        System.out.println("Now fish can swim.");
    }
    private void eat() {
        System.out.println("Fish need food to have energy to swim. Fish is eating.");
    }

}

