package ru.aleksandradeeva.homework_week11;

public class Task4_Car2 implements Runnable {
    static int speed2;
    @Override
    public void run() {
        double x = (Math.random() * 5) + 1;
        speed2 = (int) Math.round(x);
        System.out.println("Скорость автомобиля № 2: " + speed2 + " м/с");
    }

    public static int getSpeed2() {
        return speed2;
    }
}