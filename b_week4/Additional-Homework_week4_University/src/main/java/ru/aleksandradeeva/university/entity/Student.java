package ru.aleksandradeeva.university.entity;

import ru.aleksandradeeva.university.Main;

public class Student implements StudentActions, CommonActions {
    public static String thisStudentName = Main.studentName;
    public static String mentor = Professor.thisProfessorName;
    public static String studyingPlace = University.thisUniversityName;

    @Override
    public void doHomework() {
        System.out.println("Я студент " + thisStudentName + ", перед занятиями мне нужно выполнить ДЗ.");
    }

    @Override
    public void goUniversity() {
        System.out.println("Я сделал ДЗ и бегу на пары.");
    }

    public void goStudy() {
        System.out.println("Моё место учёбы - любимый университет, " + studyingPlace + ". Мой наставник - профессор " + mentor +
                ".");
    }
}
