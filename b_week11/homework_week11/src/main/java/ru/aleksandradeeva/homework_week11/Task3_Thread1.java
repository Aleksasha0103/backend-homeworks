package ru.aleksandradeeva.homework_week11;

public class Task3_Thread1 implements Runnable {
    private int n;
    private static int sum = 0;

    public Task3_Thread1(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n / 2; i++) {
            sum += i * i;
        }
    }

    public int getSum() {
        return sum;
    }
}