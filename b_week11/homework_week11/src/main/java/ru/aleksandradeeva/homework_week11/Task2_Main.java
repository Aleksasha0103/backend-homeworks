package ru.aleksandradeeva.homework_week11;

public class Task2_Main {
    public static void main(String[] args) throws InterruptedException {
        Thread task2_Thread1 = new Thread(new Task2_Thread1());
        task2_Thread1.start();
        task2_Thread1.join();

        Thread task2_Thread2 = new Thread(new Task2_Thread2());
        task2_Thread2.start();
    }
}
