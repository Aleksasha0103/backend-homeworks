package ru.aleksandradeeva.homework_week11;

import java.util.Scanner;


public class Task3_Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите целое число больше или равное 1");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Task3_Thread1 task3_thread1 = new Task3_Thread1(n);
        Task3_Thread2 task3_thread2 = new Task3_Thread2(n);

        Thread thread1 = new Thread(task3_thread1);
        Thread thread2 = new Thread(task3_thread2);

       thread1.start();
       thread2.start();
       thread1.join();
       thread2.join();

        int finalResult = task3_thread1.getSum() + task3_thread2.getSum();
        System.out.println("Сумма квадратов первых " + n + " натуральных чисел равна " + finalResult);
    }
}

