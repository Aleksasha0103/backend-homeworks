package ru.aleksandradeeva.homework_week6;

public class Task3_1 {
    enum DayOfTheWeek {Понедельник, Вторник, Среда, Четверг, Пятница, Суббота, Воскресенье}

    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = DayOfTheWeek.Суббота;
        switch (dayOfTheWeek) {
            case Понедельник:
                System.out.println("Понедельник – это будний день.");
                break;
            case Вторник:
                System.out.println("Вторник – это будний день.");
                break;
            case Среда:
                System.out.println("Среда – это будний день.");
                break;
            case Четверг:
                System.out.println("Четверг – это будний день.");
                break;
            case Пятница:
                System.out.println("Пятница – это будний день.");
                break;
            case Суббота:
                System.out.println("Суббота – это выходной день.");
                break;
            case Воскресенье:
                System.out.println("Воскресенье – это выходной день.");
                break;
        }
    }
}
