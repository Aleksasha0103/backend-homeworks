package ru.aleksandradeeva.university.entity;

import ru.aleksandradeeva.university.Main;

public class Professor implements ProfessorActions, CommonActions {
    public static String thisProfessorName = Main.professorName;
    public static String workingPlace = University.thisUniversityName;
    public static String mentee = Student.thisStudentName;

    @Override
    public void checkHomework() {
        System.out.println("Я профессор " + thisProfessorName + ", мне нужно проверить перед работой все ДЗ студентов.");
    }

    @Override
    public void goUniversity() {
        System.out.println("Я проверил все ДЗ и иду в университет на работу.");
    }

    public void goWork() {
        System.out.println("Моё место работы - самый престижный университет города - " + workingPlace + ". " +
                "Мой лучший ученик - " + mentee + ".");
    }
}
