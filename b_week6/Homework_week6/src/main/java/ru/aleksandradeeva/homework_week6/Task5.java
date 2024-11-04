package ru.aleksandradeeva.homework_week6;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Введите целое число:");
        Scanner inputNum3 = new Scanner(System.in);
        int n = inputNum3.nextInt();
        int result = 1;
        for (int b = 1; b <= n; b++) {
            result = result * b;
        }
        System.out.println(result);
    }
}
