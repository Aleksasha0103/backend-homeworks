package ru.aleksandradeeva.homeworkweek8;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String[] wordsLength = new String[]{"cat", "orange", "elephant", "bird"};

        mergeSort(wordsLength, new String[wordsLength.length], 0, wordsLength.length);

        System.out.println(Arrays.toString(wordsLength));
    }

    public static void mergeSort(String[] wordsLength, String[] buffer, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;

        mergeSort(wordsLength, buffer, startIndex, middle);
        mergeSort(wordsLength, buffer, middle, endIndex);

        merge(wordsLength, buffer, startIndex, middle, endIndex);
    }

    public static void merge(String[] wordsLength, String[] buffer, int startIndex, int middle, int endIndex) {
        int left = startIndex;
        int right = middle;
        int index = startIndex;

        while (left < middle && right < endIndex) {
            if (wordsLength[left].length() <= wordsLength[right].length()) {
                buffer[index++] = wordsLength[left++];
            } else {
                buffer[index++] = wordsLength[right++];
            }
        }

        while (left < middle) {
            buffer[index++] = wordsLength[left++];
        }
        while (right < endIndex) {
            buffer[index++] = wordsLength[right++];
        }

        System.arraycopy(buffer, startIndex, wordsLength, startIndex, endIndex - startIndex);
    }
}