package ru.aleksandradeeva.university.entity;

import ru.aleksandradeeva.university.Main;

public class University {
    public static String thisUniversityName;
    public static String worker;
    public static String learner;

    public University() {
    }

    public void universityThoughts() {
        System.out.println("Я университет " + thisUniversityName + ", жду, когда на занятия придут профессор " + worker + " и студент " + learner + ".");
    }

    static {
        thisUniversityName = Main.universityName;
        worker = Professor.thisProfessorName;
        learner = Student.thisStudentName;
    }
}
