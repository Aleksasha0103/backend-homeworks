package ru.aleksandradeeva.shipandfish;

public class Ship implements Swimmable {
    @Override
    public void swim() {
        fuel();
        System.out.println("Now ship can sail.");
    }
    private void fuel() {
        System.out.println("Ship need fuel to be able to sail. Ship is putting fuel in.");
    }
}
