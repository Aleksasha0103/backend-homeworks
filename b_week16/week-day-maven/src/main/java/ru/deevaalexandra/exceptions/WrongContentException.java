package ru.deevaalexandra.exceptions;

public class WrongContentException extends Exception {
    public WrongContentException() {
        System.out.println("Введены некорректные данные.");
    }
}
