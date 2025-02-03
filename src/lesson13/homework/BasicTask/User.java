package lesson13.homework.BasicTask;

import java.util.Scanner;

public class User {

    public static boolean makeRegistration(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        Scanner input = getInputScanner();

        while (true) {
            try {
                System.out.print("Please create your login (6-20): ");
                login = input.nextLine();
                throwStringCheckLoginException(login);
                break; // закончили цикл, если логин введен правильно
            } catch (WrongLoginException e) {
                System.out.println("WrongLoginException: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("\nPlease create your password (6-20, 1 digit, no spaces): ");
                password = input.nextLine();
                throwStringCheckPasswordException(password);

                System.out.print("Please confirm your password: ");
                confirmPassword = input.nextLine();

                if (!password.equals(confirmPassword)) {
                    System.out.println("The passwords don't match. Try again.");
                } else {
                    break; // Прекращаем цикл, если пароли совпадают
                }
            } catch (WrongPasswordException e) {
                System.out.println("WrongPasswordException: " + e.getMessage());
            }
        }

        System.out.println("\nRegistration is successful for the user: " + login);
        return true;
    }

    public static void throwStringCheckLoginException(String login) throws WrongLoginException {
        if (login.isEmpty()) {
            throw new WrongLoginException("Your login is empty!");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Your login is too long! You must fit 20 letters.");
        } else if (login.length() < 6) {
            throw new WrongLoginException("Your login is too short! Enter from 6 to 20 characters.");
        } else if (login.contains(" ")) {
            throw new WrongLoginException("Your login must not contain spaces!");
        }
    }

    public static void throwStringCheckPasswordException(String password) throws WrongPasswordException {
        if (password.isEmpty()) {
            throw new WrongPasswordException("Your password is empty!");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Your password is too long! You must fit 20 letters!");
        } else if (password.length() < 6) {
            throw new WrongPasswordException("Your password is too short! Enter from 6 to 20 characters.");
        } else if (password.contains(" ")) {
            throw new WrongPasswordException("Your password must not contain spaces!");
        } else if (!password.matches(".*\\d.*")) {
            throw new WrongPasswordException("Your password must contain at least one digit!");
        }
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] args) {
        try {
            makeRegistration(null, null, null);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
