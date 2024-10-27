package ru.aleksandradeeva.university.entity;

import ru.aleksandradeeva.university.Main;

public class University {
    public static String thisUniversityName = Main.universityName;
    public static String worker = Professor.thisProfessorName;
    public static String learner = Student.thisStudentName;

    public void universityThoughts() {
        System.out.println("Я университет " + thisUniversityName + ", жду, когда на занятия придут профессор " +
                worker + " и студент " + learner + ".");
    }
}
