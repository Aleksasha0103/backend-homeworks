package ru.aleksandradeeva.homework_week12_copying_of_strings;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String text = "";
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             FileWriter fileWriter1 = new FileWriter("text1.txt");
             FileReader fileReader = new FileReader("text1.txt");
             FileWriter fileWriter2 = new FileWriter("text2.txt")) {
            System.out.println("Введите текст в консоль: ");
            int inputChar = inputStreamReader.read();
            while (inputStreamReader.ready()) {
                text = text + (char) inputChar;
                inputChar = inputStreamReader.read();
            }
            fileWriter1.write(text);
            int symbols = fileReader.read();
            while (symbols != -1) {
                text += (char) symbols;
                symbols = fileReader.read();
            }
            fileWriter2.write(text);
            System.out.println("Ваш текст записан.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
