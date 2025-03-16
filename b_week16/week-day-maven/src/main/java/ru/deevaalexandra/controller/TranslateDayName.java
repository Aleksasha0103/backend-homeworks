package ru.deevaalexandra.controller;

import ru.deevaalexandra.exceptions.WrongContentException;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class TranslateDayName {
    public Scanner scanner;

    public enum DayOfWeekList {
        Sunday("воскресенье"),
        Monday("понедельник"),
        Tuesday("вторник"),
        Wednesday("среда"),
        Thursday("четверг"),
        Friday("пятница"),
        Saturday("суббота");

        private final String russianName;

        DayOfWeekList(String russianName) {
            this.russianName = russianName;
        }

        public String getRussianName() {
            return russianName;
        }
    }

    public TranslateDayName(Scanner scanner) {
        this.scanner = scanner;
    }

    public void readData() throws WrongContentException {
        System.out.println("Введите название дня недели на английском языке.");
        String inputText = scanner.nextLine();

        DayOfWeekList resultDay;
        try {
            resultDay = DayOfWeekList.valueOf(inputText.substring(0, 1).toUpperCase() + inputText.substring(1).toLowerCase());
            String resultRussianName = resultDay.getRussianName();
            System.out.println("Сегодня " + resultRussianName + ".");
        } catch (IllegalArgumentException e) {
            throw new WrongContentException();
        } finally {
            scanner.close();
        }
    }
}