package ru.aleksandradeeva.university.entity;

public class LetsDo {
    public void letsDoHomework(StudentActions studentActions) {
        studentActions.doHomework();
    }

    public void letsCheckHomework(ProfessorActions professorActions) {
        professorActions.checkHomework();
    }

    public void letsGoUniversity(CommonActions commonActions) {
        commonActions.goUniversity();
    }
}
