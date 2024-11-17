package ru.alexandradeeva.homework_week7;

import java.util.Iterator;
import java.util.LinkedList;

public class Task4 {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();

        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(12);
        numbers.add(7);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }
}


