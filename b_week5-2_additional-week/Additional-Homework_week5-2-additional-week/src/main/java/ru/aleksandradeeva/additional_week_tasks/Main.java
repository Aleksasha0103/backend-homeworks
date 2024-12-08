package ru.aleksandradeeva.additional_week_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1:");
        task1();
        System.out.println("Task2:");
        task2();
        System.out.println("Task3:");
        task3();
        System.out.println("Task4:");
        task4();
        System.out.println("Task5:");
        task5();
        System.out.println("Task6:");
        task6();
        System.out.println("Task7:");
        task7();
        System.out.println("Task8:");
        task8();
        System.out.println("Task9:");
        task9();
        System.out.println("Task10:");
        task10();
        System.out.println("Task11:");
        task11();
        System.out.println("Task12:");
        task12();
        System.out.println("Task13:");
        task13();
        System.out.println("Task14:");
        task14();
        System.out.println("Task15:");
        task15();
        System.out.println("Task16:");
        task16();
        System.out.println("Task17:");
        task17();
        System.out.println("Task18:");
        task18();
//        System.out.println("Task19:");
//        task19();
//        System.out.println("Task20:");
//        task20();
//        System.out.println("Task21:");
//        task21();
//        System.out.println("Task22:");
//        task22();
    }

    public static void task1() {
        int num1 = 5;
        int num2 = 7;
        int num3 = num1;
        num1 = num2;
        num2 = num3;
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void task2() {
        int num1 = 3;
        int num2 = 4;
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void task3() {
        float x = 2.6F;
        int y = (int) x;
        System.out.println(x);
    }

    public static void task4() {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1 == str2);
    }

    public static void task5() {
        Integer num1 = new Integer(5);
        Integer num2 = new Integer(5);
        System.out.println(num1 == num2);
    }

    public static void task6() {
        int c = 1;
        int d = 2;
        System.out.println(c <= d ? true : false);
    }

    public static void task7() {
        int x = 5;
        System.out.println(x++);
    }

    public static void task8() {
        int x = 7;
        System.out.println(++x);
    }

    public static void task9() {
        char sign = 'a';
        while (sign <= 'z') {
            System.out.print(sign++ + " ");
        }
        System.out.println(" ");
    }

    public static void task10() {
        int a = 1;
        while (true) {
            System.out.print(a + " ");
            a++;
            if (a > 5) {
                break;
            }
        }
        System.out.println(" ");
    }

    public static void task11() {
        int i;
        for (i = 100; i <= 999; i++) {
            if (i % 7 == 0) {
                int a = i / 100;
                int b = (i / 10) % 10;
                int c = i % 10;
                int ost = a + b + c;
                if (ost % 7 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void task12() {
        String str = "Dorothy lived in the midst of the great Kansas prairies, with Uncle Henry, who was a farmer, and Aunt Em, who was the farmer's wife.";
        int spaceQuantity = 0;
        int i;
        for (i = 0; i < str.length(); i++) {
            char space = str.charAt(i);
            if (space == ' ') {
                spaceQuantity++;
            }
        }
        System.out.println(spaceQuantity + 1);
    }

    public static void task13() {
        int[] phiboArr = new int[10];
        phiboArr[0] = 0;
        phiboArr[1] = 1;
        for (int i = 2; i < phiboArr.length; ++i) {
            phiboArr[i] = phiboArr[i - 1] + phiboArr[i - 2];
        }
        String phibo = Arrays.toString(phiboArr);
        System.out.print(phibo);
        System.out.println(" ");
    }

    public static void task14() {
        char[] upperLetters = new char[26];
        for (int i = 0; i < upperLetters.length; i++) {
            upperLetters[i] = (char) ('A' + i);
        }
        String letters = Arrays.toString(upperLetters);
        System.out.print(letters);
        System.out.println(" ");
    }

    public static void task15() {
        float[] random = new float[20];
        for (int i = 0; i < random.length; i++) {
            random[i] = 163.0F + (float) Math.random() * (197.0F - 163.0F);
        }
        System.out.println(Arrays.toString(random));
    }

    public static void task16() {
        int[] numbers = {11, 22, 33};
        numbers[1] = numbers[2];
        numbers[2] = numbers[0];
        numbers[0] = numbers[1] - numbers[2];
        System.out.println(Arrays.toString(numbers));
    }

    public static void task17() {
        int x = -5;
        if (x == 0) {
            System.out.println("0");
        } else if (x > 0) {
            System.out.println("1");
        } else {
            System.out.println("-1");
        }
    }

    public static void task18() {
        String str1 = "desserts";
        char[] commonArray = str1.toCharArray();
        char[] revertArray = new char[commonArray.length];
        for (int i = commonArray.length - 1; i >= 0; i--) {
            revertArray[i] = commonArray[commonArray.length - 1 - i];
        }
        String str2 = new String(revertArray);
        System.out.println(str2);
    }
}


















