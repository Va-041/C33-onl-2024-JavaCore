package lesson7.homework.clinic;

public class Clinic {

    private Doctors[] doctors; // Изменил на Doctor
    private Patient[] patients;

    public Clinic(Doctors[] doctors, Patient[] patients) {
        this.doctors = doctors;
        this.patients = patients;
    }

    @Override
    public String toString() {
        String result = "\n\tClinic has: \n\n";

        result += "\t\tDoctors: \n";
        for (Doctors doctor : doctors) {
            result += doctor.toString(false) + "\n";
        }

        result += "\t\tPatients: \n";
        for (Patient patient : patients) {
            result += patient + "\n";
        }

        return result;
    }
}