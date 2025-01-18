package lesson10.homework.firstTask;

public class MySystem {

    public static void main(String[] args) {
        createSystem();
    }

    public static void createSystem() {

        User firstUser = new User("Albertick001", "043Ba54i", "albertivanov2000@gmail.com");
        User secondUser = new User("Albertick001", "043Ba54i", "albertivanov2000@gmail.com");
        User thirdUser = new User("Albertick001", "043Ba54i", "albertivanov2000@gmail.com");

        System.out.println(firstUser);
        System.out.println(secondUser);
        System.out.println(thirdUser);

        if (firstUser.equals(secondUser) && secondUser.equals(thirdUser)) {
            System.out.println("All objects of the class User are identical");
        } else if (firstUser.equals(secondUser) && !secondUser.equals(thirdUser)) {
            System.out.println("Objects of class User 1 and 2 are identical, but 3 is different");
        } else if (!firstUser.equals(secondUser) && secondUser.equals(thirdUser)) {
            System.out.println("Objects of class User 2 and 3 are identical, but 1 is different");
        } else if (firstUser.equals(thirdUser) && !firstUser.equals(secondUser)) {
            System.out.println("Objects of class User 1 and 3 are identical, but 2 is different");
        } else {
            System.out.println("All objects of the class User are different");
        }

        System.out.println("\nFirst user hashcode: " + firstUser.hashCode());
        System.out.println("Second user hashcode: " + secondUser.hashCode());
        System.out.println("Third user hashcode: " + thirdUser.hashCode());
    }
}
