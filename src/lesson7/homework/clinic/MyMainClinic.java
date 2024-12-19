package lesson7.homework.clinic;

public class MyMainClinic {
    public static void main(String[] args) {
        buildClinic();
    }

    public static void buildClinic() {
        System.out.println("\n\t========================================================================");

        Doctors[] doctors = new Doctors[]{
                new Therapist("Anna", "Smirnova", 45, "Female", "Therapist",
                        "High qualification",
                        new String[]{"Anamnesis collection", "Examination of the patient", "Palpation",
                                "Prescribing a course of treatment for various diseases",
                                "Issuance of medical certificates on the state of health",
                                "Auscultation", "Measurement of blood pressure and heart rate",
                                "The purpose of laboratory instrumental diagnostic procedures"}),

                new Surgeon("Nick", "Braun", 35, "Male", "Surgeon",
                        "First qualification",
                        new String[]{""}),

                new Dentist("Ivan", "Malkov", 32, "Male", "Dentist",
                        "Second qualification",
                        new String[]{""})
        };

        Patient[] patients = new Patient[]{
                new Patient("Alex", "Milton", 28, "Male", "Toothache", doctors[2]),
                new Patient("Svetlana", "Kislova", 38, "Female", "Temperature", doctors[0]),
                new Patient("Nickolai", "Akimov", 45, "Male", "Suspected appendicitis", doctors[1])
        };

        Clinic clinic = new Clinic(doctors, patients);
        System.out.println(clinic);
        System.out.println("\t========================================================================");

        startClinicWork(doctors, patients);
    }

    public static void startClinicWork(Doctors[] doctors, Patient[] patients) {
        System.out.println("\n\tThe admission of patients to the therapist begins....");
        System.out.println("\n" + doctors[0]);

        int currentIndex = 0;

        while (true) {
            System.out.println("\t------------------------------------------------------------------------");
            System.out.println("\n\tPatient № " + (currentIndex + 1) + ":");
            System.out.println("\n" + patients[currentIndex].toString(false));

            Doctors.treatmentMethod(patients[currentIndex], doctors);

            System.out.println("\n\tUpdated patient info after treatment:");
            System.out.println("\n" + patients[currentIndex].toString(false));
            System.out.println("\t------------------------------------------------------------------------");

            if (Doctors.goBack) {
                currentIndex = (currentIndex == 0) ? patients.length - 1 : currentIndex - 1;
                Doctors.goBack = false;
            } else if (Doctors.goNext) {
                currentIndex = (currentIndex == patients.length - 1) ? 0 : currentIndex + 1;
                Doctors.goNext = false;
            } else {
                currentIndex++;
                if (currentIndex >= patients.length) {
                    currentIndex = 0;
                }
            }
        }
    }
}



