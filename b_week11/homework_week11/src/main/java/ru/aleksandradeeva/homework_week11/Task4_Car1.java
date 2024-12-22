package ru.aleksandradeeva.homework_week11;

public class Task4_Car1 implements Runnable {
    static int speed1;
    @Override
    public void run() {
        double i = (Math.random() * 5) + 1;
        speed1 = (int) Math.round(i);
        System.out.println("Скорость автомобиля № 1: " + speed1 + " м/с");
    }
    public static int getSpeed1() {
        return speed1;
    }
}