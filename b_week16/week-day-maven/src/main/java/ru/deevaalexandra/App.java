package ru.deevaalexandra;

import ru.deevaalexandra.controller.TranslateDayName;
import ru.deevaalexandra.exceptions.WrongContentException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws WrongContentException {
        Scanner scanner = new Scanner(System.in);
        TranslateDayName translateDayName = new TranslateDayName(scanner);
        translateDayName.readData();
    }
}
