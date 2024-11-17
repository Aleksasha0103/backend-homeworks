package ru.alexandradeeva.homework_week7;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        String words = "hello world";
        HashMap<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < words.length(); i++) {
            char x = words.charAt(i);
            letters.put(x, letters.getOrDefault(x, 0) + 1);
        }

        for (HashMap.Entry<Character, Integer> entry : letters.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}