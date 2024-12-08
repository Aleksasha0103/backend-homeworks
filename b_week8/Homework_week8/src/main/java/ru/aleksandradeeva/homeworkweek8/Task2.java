package ru.aleksandradeeva.homeworkweek8;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("grape");
        fruits.add("banana");

        quickSort(fruits, 0, fruits.size() - 1);
        System.out.println(fruits);
    }

    public static void quickSort(List<String> fruits, int min, int max) {
        if (fruits.size() == 0 || min >= max) return;
        if (min < max) {
            int i = min;
            int j = max;
            String border = fruits.get((min + max) / 2);

            while (i <= j) {
                while (fruits.get(i).compareTo(border) < 0) {
                    i++;
                }
                while (fruits.get(j).compareTo(border) > 0) {
                    j--;
                }
                if (i <= j) {
                    String temporary = fruits.get(i);
                    fruits.set(i, fruits.get(j));
                    fruits.set(j, temporary);
                    i++;
                    j--;
                }
            }
            if (min < j) {
                quickSort(fruits, min, j);
            }
            if (i < max) {
                quickSort(fruits, i, max);
            }
        }


    }

}


















