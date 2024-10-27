package ru.aleksandradeeva.university.entity;

import ru.aleksandradeeva.university.Main;

public class Professor implements ProfessorActions, CommonActions {
    public static String thisProfessorName;
    public static String workingPlace;
    public static String mentee;

    public Professor() {
    }

    public void checkHomework() {
        System.out.println("Я профессор " + thisProfessorName + ", мне нужно проверить перед работой все ДЗ студентов.");
    }

    public void goUniversity() {
        System.out.println("Я проверил все ДЗ и иду в университет на работу.");
    }

    public void goWork() {
        System.out.println("Моё место работы - самый престижный университет города - " + workingPlace + ". Мой лучший ученик - " + mentee + ".");
    }

    static {
        thisProfessorName = Main.professorName;
        workingPlace = University.thisUniversityName;
        mentee = Student.thisStudentName;
    }
}
