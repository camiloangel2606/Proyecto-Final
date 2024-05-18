public class Main {
    public static void main(String[] args) {
        Patient.addPatient(1, "John Doe", 30, 70.5f, 180.2f, new String[] { "Diabetes", "Hypertension" });
        Patient.addPatient(2, "Jane Smith", 25, 60.0f, 170.5f, new String[] { "Asthma" });

        Patient.printPatientList();
    }
}
