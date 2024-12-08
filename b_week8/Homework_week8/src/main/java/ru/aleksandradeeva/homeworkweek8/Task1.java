package ru.aleksandradeeva.homeworkweek8;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        LinkedHashMap<Double, String> studentScore = new LinkedHashMap<>();
        studentScore.put(4.5, "Иванов");
        studentScore.put(3.7, "Петров");
        studentScore.put(4.2, "Сидоров");
        studentScore.put(5.0, "Козлов");
        studentScore.put(3.9, "Смирнов");

        bubbleSort(studentScore);
        System.out.println(studentScore);
    }

    public static void bubbleSort(LinkedHashMap<Double, String> studentScore) {
        List<Map.Entry<Double, String>> studentsList = new ArrayList<>(studentScore.entrySet());
        for (int i = 0; i < (studentsList.size() - 1); i++) {
            for (int j = 0; j < (studentsList.size() - 1 - i); j++) {
                if (studentsList.get(j).getKey() < studentsList.get(j + 1).getKey()) {
                    Map.Entry<Double, String> temp = studentsList.get(j);
                    studentsList.set(j, studentsList.get(j + 1));
                    studentsList.set(j + 1, temp);
                }
            }

        }
        studentScore.clear();
        for (Map.Entry<Double, String> entry:studentsList){
            studentScore.put(entry.getKey(), entry.getValue());
        }
    }
}





























