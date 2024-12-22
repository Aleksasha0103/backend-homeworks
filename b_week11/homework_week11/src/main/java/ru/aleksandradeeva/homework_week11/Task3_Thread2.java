package ru.aleksandradeeva.homework_week11;

public class Task3_Thread2 implements Runnable {
    private int n;
    private static int sum = 0;

    public Task3_Thread2(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = n / 2; i <= n; i++) {
            sum += i * i;
        }
    }

    public int getSum() {
        return sum;
    }
}

