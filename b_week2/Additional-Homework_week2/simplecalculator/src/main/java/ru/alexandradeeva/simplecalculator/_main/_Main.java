package ru.alexandradeeva.simplecalculator._main;

import ru.alexandradeeva.simplecalculator.service.ResultWriterService;
import ru.alexandradeeva.simplecalculator.util.Calculator;

import java.util.Scanner;

import static ru.alexandradeeva.simplecalculator.util.Calculator.*;

public class _Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш простой калькулятор!");
        System.out.println("Введите первое число:");
        Scanner sc = new Scanner(System.in);
        int inputNumber1 = sc.nextInt();
        System.out.println("Введите второе число:");
        int inputNumber2 = sc.nextInt();
        int additionResult = Calculator.add(inputNumber1, inputNumber2);
        int subtractionResult = Calculator.subtract(inputNumber1, inputNumber2);
        int multiplicationResult = Calculator.multiply(inputNumber1, inputNumber2);
        String operationNameAdd = " – результат сложения";
        String operationNameSubtract = " – результат вычитания";
        String operationNameMultiply = " – результат умножения";
        ResultWriterService.printAddResult(inputNumber1, inputNumber2, additionResult, operationNameAdd);
        ResultWriterService.printSubstractResult(inputNumber1, inputNumber2, subtractionResult, operationNameSubtract);
        ResultWriterService.printMultiplyResult(inputNumber1, inputNumber2, multiplicationResult, operationNameMultiply);
    }

  }
