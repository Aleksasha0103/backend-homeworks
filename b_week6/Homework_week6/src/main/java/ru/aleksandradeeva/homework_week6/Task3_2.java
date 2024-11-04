package ru.aleksandradeeva.homework_week6;

import java.util.Scanner;

public class Task3_2 {
    enum DayOfTheWeek {
        Понедельник, понедельник, Вторник, вторник, Среда, среда,
        Четверг, четверг, Пятница, пятница, Суббота, суббота, Воскресенье, воскресенье
    }

    public static void main(String[] args) {
        System.out.println("Введите название дня недели:");
        Scanner inputDay = new Scanner(System.in);
        String i = inputDay.nextLine();
        DayOfTheWeek dayOfTheWeek = DayOfTheWeek.valueOf(i);
        switch (dayOfTheWeek) {
            case Понедельник:
                System.out.println("Это будний день.");
                break;
            case понедельник:
                System.out.println("Это будний день.");
                break;
            case Вторник:
                System.out.println("Это будний день.");
                break;
            case вторник:
                System.out.println("Это будний день.");
                break;
            case Среда:
                System.out.println("Это будний день.");
                break;
            case среда:
                System.out.println("Это будний день.");
                break;
            case Четверг:
                System.out.println("Это будний день.");
                break;
            case четверг:
                System.out.println("Это будний день.");
                break;
            case Пятница:
                System.out.println("Это будний день.");
                break;
            case пятница:
                System.out.println("Это будний день.");
                break;
            case Суббота:
                System.out.println("Это выходной день.");
                break;
            case суббота:
                System.out.println("Это выходной день.");
                break;
            case Воскресенье:
                System.out.println("Это выходной день.");
                break;
            case воскресенье:
                System.out.println("Это выходной день.");
                break;
        }
    }
}
