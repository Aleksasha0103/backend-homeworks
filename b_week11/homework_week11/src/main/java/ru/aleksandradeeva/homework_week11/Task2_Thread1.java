package ru.aleksandradeeva.homework_week11;

public class Task2_Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Поток 1: число " + i);
        }
    }
}
