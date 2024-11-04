package ru.aleksandradeeva.homework_week6;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введите c клавиатуры температуру целым числом:");
        Scanner inputNum1 = new Scanner(System.in);
        int t = inputNum1.nextInt();
        if (t < 0) {
            System.out.println("Сейчас очень холодно.");
        } else if (t <= 16) {
            System.out.println("Сейчас прохладно.");
        } else {
            System.out.println("Отличный летний денёк!");
        }
    }
}
