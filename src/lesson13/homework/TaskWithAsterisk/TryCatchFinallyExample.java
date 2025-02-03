package lesson13.homework.TaskWithAsterisk;

public class TryCatchFinallyExample {

    public static void startTaskWithAsterisk() {
        try {
            System.out.println("\nInside try block");
            // преднамеренно вызываем исключение
            throw new Exception("Exception in try block");
        } catch (Exception e) {
            System.out.println("Inside catch block: " + e.getMessage());
            // выход из программмы
            System.exit(0);
        } finally {
            // не вызывается из-за system.exit
            System.out.println("Inside finally block");
        }
    }
}

