package lesson7.homework.clinic;

public class Patient {

    private String name;
    private String surname;
    private int age;
    private String gender;
    private String symptoms;
    private Doctors doctors;
    private String treatmentPlan;


    public Patient(String name, String surname, int age, String gender, String symptoms, Doctors doctors) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.doctors = doctors;
        this.symptoms = symptoms;
        this.treatmentPlan = "Not assigned";
    }
    public String getTreatmentPlan() {
        return treatmentPlan;
    }
    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }


    public String toString(boolean fullInfo) {
        String result = "\t\t\tName: " + this.name + "\n" +
                "\t\t\tSurname: " + this.surname + "\n" +
                "\t\t\tAge: " + this.age + "\n" +
                "\t\t\tGender: " + this.gender + "\n" +
                "\t\t\tSymptoms: " + this.symptoms + "\n" +
                "\t\t\tTreatment plan: " + this.treatmentPlan + "\n";


        if (fullInfo) {
            result += "\t\t\tThe attending doctor: " + doctors.getShortInfo() + "\n";
        }

        return result;
    }

    @Override
    public String toString() {
        return toString(true);
    }
}
