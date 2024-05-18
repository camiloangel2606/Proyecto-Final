public class Main {
    public static void main(String[] args) {
        PatientManager manager = new PatientManager();
        manager.listPatientAdd(1105346806, "John Doe", 30, 70.5f, 180.2f, new String[] { "Diabetes", "Hypertension" });
        manager.listPatientAdd(1345698093, "Jane Smith", 25, 60.0f, 170.5f, new String[] { "Asthma" });

        manager.printPatientList();
    }
}