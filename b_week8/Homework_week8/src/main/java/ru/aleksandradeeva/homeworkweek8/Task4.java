package ru.aleksandradeeva.homeworkweek8;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static int countVowels(String word) {
        int vowelCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("orange");
        words.add("elephant");
        words.add("bird");

        for (int i = 1; i < words.size(); i++) {
            String currentWord = words.get(i);
            int currentVowels = countVowels(currentWord);
            int j = i - 1;

            while (j >= 0 && countVowels(words.get(j)) > currentVowels) {
                words.set(j + 1, words.get(j));
                j--;
            }
            words.set(j + 1, currentWord);
        }

        System.out.println(words);
    }
}


