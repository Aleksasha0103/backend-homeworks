package ru.aleksandradeeva.homework_week6;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите целое число:");
        Scanner inputNum2 = new Scanner(System.in);
        int n = inputNum2.nextInt();
        String result = n % 2 == 0 ? "Введённое число является чётным." : "Введённое число является нечётным.";
        System.out.println(result);
    }
}
