package ru.alexandradeeva.simplecalculator.service;

public class ResultWriterService {
    public static void printResult(int printNumber1, String sign, int printNumber2, int result) {
        System.out.println(printNumber1 + sign + printNumber2 + " = " + result);
    }
}