package lesson7.homework.clinic;

import java.util.Scanner;

public class Doctors {

    public static boolean goBack = false;
    public static boolean goNext = false;

    private String name;
    private String surname;
    private int age;
    private String gender;
    private String speciality;
    private String qualification;
    private String[] tasks;

    public Doctors(String name, String surname, int age, String gender, String speciality, String qualification, String[] tasks) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.speciality = speciality;
        this.qualification = qualification;
        this.tasks = tasks;
    }

    public String getShortInfo() {
        return name + " " + surname + ", " + speciality;
    }

    public String toString(boolean fullInfo) {
        String result = "\t\t\tName: " + this.name + "\n" +
                "\t\t\tSurname: " + this.surname + "\n" +
                "\t\t\tAge: " + this.age + "\n" +
                "\t\t\tGender: " + this.gender + "\n" +
                "\t\t\tSpeciality: " + this.speciality + "\n" +
                "\t\t\tQualification: " + this.qualification + "\n";

        if (fullInfo) {
            result += "\n\t\t\tThe list of services performed:\n";
            for (int i = 0; i < tasks.length; i++) {
                result += "\t\t\t\t" + (i + 1) + ". " + tasks[i] + "\n";
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return toString(true);
    }
    public void treatmentMethod(Patient patient) {
    }

    public static void treatmentMethod(Patient patient, Doctors[] doctors) {
        System.out.println("\tWhat treatment plan should be prescribed?");
        System.out.println("\t1. Code 1 - appoint a surgeon");
        System.out.println("\t2. Code 2 - appoint a dentist");
        System.out.println("\t3. Code 3 - appoint a therapist");
        System.out.println("\t4. Go back");
        System.out.println("\t5. Go next");
        System.out.println("\t6. Exit");
        System.out.print("\n\tEnter your choice: ");

        Scanner choice = getScannerInput();
        boolean nextPatient = true;

        while (nextPatient) {
            if (choice.hasNextInt()) {
                int choiceAction = choice.nextInt();

                switch (choiceAction) {
                    case 1:
                        patient.setTreatmentPlan("treatment by a surgeon");
                        System.out.println("\n\tThe patient has been prescribed treatment by a surgeon");
                        doctors[1].treatmentMethod(patient);
                        nextPatient = false;
                        break;
                    case 2:
                        patient.setTreatmentPlan("treatment by a dentist");
                        System.out.println("\n\tThe patient has been prescribed treatment by a dentist");
                        doctors[2].treatmentMethod(patient);
                        nextPatient = false;
                        break;
                    case 3:
                        patient.setTreatmentPlan("treatment by a therapist");
                        System.out.println("\n\tThe patient has been prescribed treatment by a therapist");
                        doctors[0].treatmentMethod(patient);
                        nextPatient = false;
                        break;
                    case 4:
                        goBack = true;
                        nextPatient = false;
                        break;
                    case 5:
                        goNext = true;
                        nextPatient = false;
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("\tChoose one of the available actions!");
                        System.out.print("\n\tEnter your choice: ");
                }
            } else {
                System.out.println("\tInvalid input, please enter a number.");
                choice.next(); // очистка неправильного ввода
                System.out.print("\n\tEnter your choice: ");
            }
        }
    }



    public static Scanner getScannerInput() {
        return new Scanner(System.in);
    }
}

