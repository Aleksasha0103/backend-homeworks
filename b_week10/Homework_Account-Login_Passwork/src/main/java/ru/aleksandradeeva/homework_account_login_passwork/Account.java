package ru.aleksandradeeva.homework_account_login_passwork;

import java.util.HashMap;
import java.util.Scanner;

public class Account {
    String login;
    String password;
    HashMap<String, String> loginsAndPasswords;

    public Account(HashMap<String, String> loginsAndPasswords) {
        this.loginsAndPasswords = loginsAndPasswords;
    }

    public void checkLogin(Scanner scannerLogin) throws WrongLoginException {
        String inputLogin;
        inputLogin = scannerLogin.nextLine();
        if (inputLogin != null && inputLogin.length() >= 5 && inputLogin.length() <= 20) {
            login = inputLogin;
            System.out.println("Ваш логин: " + login);
        } else {
            System.out.println("Введите логин длиной от 5 до 20 символов.");
            throw new WrongLoginException();
        }

    }

    public void checkPassword(Scanner scannerPassword, Scanner scannerPasswordConfirmation) throws WrongPasswordException {
        String inputPassword;
        String inputPasswordConfirmation;
        inputPassword = scannerPassword.nextLine();
        if (inputPassword != null && inputPassword.length() >= 8 && inputPassword.length() <= 20) {
            while (true) {
                System.out.println("Подтвердите пароль: ");
                inputPasswordConfirmation = scannerPasswordConfirmation.nextLine();
                if (inputPassword.equals(inputPasswordConfirmation)) {
                    password = inputPassword;
                    System.out.println("Ваш пароль: " + password);
                    break;
                } else {
                    System.out.println("Пароль и его подтверждение должны совпадать.");
                }
            }
        } else {
            System.out.println("Введите пароль длиной от 8 до 20 символов.");
            throw new WrongPasswordException();
        }
    }


    public void checkLoginAndPassword(String login, String password) throws WrongLoginOrPasswordException {
        if (loginsAndPasswords.containsKey(login) && loginsAndPasswords.get(login).equals(password)) {
            System.out.println("Вы успешно вошли в аккаунт!");
        } else {
            System.out.println("Такой пользователь не зарегистрирован.");
            throw new WrongLoginOrPasswordException();
        }
    }
}
















