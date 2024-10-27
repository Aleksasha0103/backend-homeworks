package ru.alexandradeeva.simplecalculator._main;

import ru.alexandradeeva.simplecalculator.service.ResultWriterService;
import ru.alexandradeeva.simplecalculator.util.Calculator;

import java.util.Scanner;


public class _Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш простой калькулятор!");
        System.out.println("Введите первое число:");
        Scanner sc = new Scanner(System.in);
        int inputNumber1 = sc.nextInt();
        System.out.println("Введите второе число:");
        int inputNumber2 = sc.nextInt();
        int result = Calculator.add(inputNumber1, inputNumber2);
        ResultWriterService.printResult(inputNumber1, " + ", inputNumber2, result);
        result = Calculator.subtract(inputNumber1, inputNumber2);
        ResultWriterService.printResult(inputNumber1, " - ", inputNumber2, result);
        result = Calculator.multiply(inputNumber1, inputNumber2);
        ResultWriterService.printResult(inputNumber1, " * ", inputNumber2, result);
    }
}
