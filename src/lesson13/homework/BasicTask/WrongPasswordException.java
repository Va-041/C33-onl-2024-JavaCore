package lesson13.homework.BasicTask;

public class WrongPasswordException extends Exception {

  public WrongPasswordException() {}

    public WrongPasswordException(String message) {
        super(message);
    }
}
