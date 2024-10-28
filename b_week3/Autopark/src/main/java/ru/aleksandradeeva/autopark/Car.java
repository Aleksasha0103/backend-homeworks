package ru.aleksandradeeva.autopark;

public class Car {

    String color;
    String brand;

    public Car() {
    }

    public Car(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }


    public String move() {
        return "is moving";
    }

    public String slowDown() {
        return "is slowing down";
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.color = "white";
        car1.brand = "BMW";

        Car car2 = new Car("black", "Audi");

        Car car3 = new Car("blue", "Mercedes");


        System.out.println("And now this " + car1.color + " " + car1.brand + " " + car1.slowDown() + " now.");
        System.out.println("But this " + car2.color + " " + car2.brand + " " + car2.move() + " still.");
        System.out.println("And this " + car3.color + " " + car3.brand + " " + car3.move() + " as the previous one.");
    }

}