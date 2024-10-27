package ru.aleksandradeeva.university;

import ru.aleksandradeeva.university.entity.LetsDo;
import ru.aleksandradeeva.university.entity.Professor;
import ru.aleksandradeeva.university.entity.Student;
import ru.aleksandradeeva.university.entity.University;

public class Main {

    public static String universityName = "МГУ";
    public static String professorName = "Анатолий Иванович";
    public static String studentName = "Андрей";

    public static void main(String[] args) {
        Professor professor = new Professor();
        Student student = new Student();
        University university = new University();

        LetsDo letsDo = new LetsDo();

        letsDo.letsDoHomework(student);
        letsDo.letsGoUniversity(student);
        student.goStudy();
        letsDo.letsCheckHomework(professor);
        letsDo.letsGoUniversity(professor);
        professor.goWork();
        university.universityThoughts();
    }
}
