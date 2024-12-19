package lesson7.homework.clinic;

public class Therapist extends Doctors {

    public Therapist(String name, String surname, int age, String gender, String speciality, String qualification, String[] tasks) {
        super(name, surname, age, gender, speciality, qualification, tasks);
    }

    public void treatmentMethod(Patient patient) {
        System.out.println("\t---------------------------------------------");
        System.out.println("\tPerforming treatment for patient by therapist");
        System.out.println("\t---------------------------------------------");
        // Логика лечения пациента терапевтом
    }
}
