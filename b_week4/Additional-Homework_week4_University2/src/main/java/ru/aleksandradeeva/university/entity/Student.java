package ru.aleksandradeeva.university.entity;

import ru.aleksandradeeva.university.Main;

public class Student implements StudentActions, CommonActions {
    public static String thisStudentName;
    public static String mentor;
    public static String studyingPlace;

    public Student() {
    }

    public void doHomework() {
        System.out.println("Я студент " + thisStudentName + ", перед занятиями мне нужно выполнить ДЗ.");
    }

    public void goUniversity() {
        System.out.println("Я сделал ДЗ и бегу на пары.");
    }

    public void goStudy() {
        System.out.println("Моё место учёбы - любимый университет, " + studyingPlace + ". Мой наставник - профессор " + mentor + ".");
    }

    static {
        thisStudentName = Main.studentName;
        mentor = Professor.thisProfessorName;
        studyingPlace = University.thisUniversityName;
    }
}
