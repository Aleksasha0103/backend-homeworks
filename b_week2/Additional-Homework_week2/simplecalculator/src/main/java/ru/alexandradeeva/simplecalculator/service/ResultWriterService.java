package ru.alexandradeeva.simplecalculator.service;

public class ResultWriterService {
    public static void printAddResult(int printNumber1, int printNumber2, int printAdditionResult, String printAddName) {
        System.out.println(printNumber1 + " + " + printNumber2 + " = " + printAdditionResult + printAddName);
          }

          public static void printSubstractResult(int printNumber1, int printNumber2, int printSubtractionResult, String printSubtractName) {
        System.out.println(printNumber1 + " - " + printNumber2 + " = " + printSubtractionResult + printSubtractName);
    }
    public static void printMultiplyResult(int printNumber1, int printNumber2, int printMultiplicationResult, String printMultiplyName) {
        System.out.println(printNumber1 + " * " + printNumber2 + " = " + printMultiplicationResult + printMultiplyName);
    }
}
