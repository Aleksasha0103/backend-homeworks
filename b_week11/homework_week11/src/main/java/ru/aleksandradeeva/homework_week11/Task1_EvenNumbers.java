package ru.aleksandradeeva.homework_week11;

public class Task1_EvenNumbers extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
