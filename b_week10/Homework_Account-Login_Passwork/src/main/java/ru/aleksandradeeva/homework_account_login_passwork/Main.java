package ru.aleksandradeeva.homework_account_login_passwork;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerLogin = new Scanner(System.in);
        Scanner scannerPassword = new Scanner(System.in);
        Scanner scannerPasswordConfirmation = new Scanner(System.in);
        HashMap<String, String> loginsAndPasswords = new HashMap<>();
        loginsAndPasswords.put("misha", "12345678");
        loginsAndPasswords.put("masha", "87654321");
        loginsAndPasswords.put("katya", "192837465");
        Account account = new Account(loginsAndPasswords);

        System.out.println("Введите логин: ");
        while (true) {
            try {
                account.checkLogin(scannerLogin);
                break;
            } catch (WrongLoginException e) {
                System.out.println("Исключение: " + e);
            }
        }

        System.out.println("Введите пароль: ");
        while (true) {
            try {
                account.checkPassword(scannerPassword, scannerPasswordConfirmation);
                break;
            } catch (WrongPasswordException e) {
                System.out.println("Исключение: " + e);
            }
        }

        try {
            account.checkLoginAndPassword(account.login, account.password);
        } catch (WrongLoginOrPasswordException e) {
            System.out.println("Исключение: " + e);
        }
    }
}
