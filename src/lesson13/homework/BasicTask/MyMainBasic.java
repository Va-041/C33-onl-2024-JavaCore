package lesson13.homework.BasicTask;

import static lesson13.homework.BasicTask.User.makeRegistration;

public class MyMainBasic {

    public static void main(String[] args) {

        System.out.println("\n=============== Basic Task ==============\n");
        try {
            makeRegistration(null, null, null);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
