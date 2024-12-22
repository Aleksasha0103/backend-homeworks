package ru.aleksandradeeva.homework_week11;

public class Task5_Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Поток 2");
        }
    }
}
