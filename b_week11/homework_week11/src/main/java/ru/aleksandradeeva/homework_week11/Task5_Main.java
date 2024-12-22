package ru.aleksandradeeva.homework_week11;

public class Task5_Main {
    public static void main(String[] args) throws InterruptedException {
        Thread task5_Thread1 = new Thread(new Task5_Thread1());
        Thread task5_Thread2 = new Thread(new Task5_Thread2());
        task5_Thread1.setPriority(Thread. MIN_PRIORITY);
        task5_Thread2.setPriority(Thread. MAX_PRIORITY);
        task5_Thread1.start();
        task5_Thread2.start();
        task5_Thread1.join(1000);
        task5_Thread2.join(1000);
    }
}
