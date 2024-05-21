import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Patient {
    private int patientId;
    private String fullName;
    private int age;
    private float weight;
    private float height;
    private List<String> preexistingConditions;

    private static List<Patient> patientList = new ArrayList<>();

    public Patient(int patientId, String fullName, int age, float weight, float height,
            List<String> preexistingConditions) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.preexistingConditions = preexistingConditions;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return 2024 - age; // Pide el año de nacimiento para así no tener la necesidad de actualizar.
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public List<String> getPreexistingConditions() {
        return preexistingConditions;
    }

    public void setPreexistingConditions(List<String> preexistingConditions) {
        this.preexistingConditions = preexistingConditions;
    }

    @Override
    public String toString() {
        return "Patient[PatientId:" + patientId + ", FullName:" + fullName + ", Age:" + age + ", Weight:" + weight
                + ", Height:" + height + ", PreexistingConditions:" + preexistingConditions + "]";
    }

    public static void addPatient(int patientId, String fullName, int age, float weight, float height,
            String[] preexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
        Patient newPatient = new Patient(patientId, fullName, age, weight, height, preexistingConditionsList);
        for (Patient patient : patientList) {
            if (patient.getPatientId() == patientId) {
                System.out.println("El paciente ya se encuentra agregado.");
                return;
            }
        }
        patientList.add(newPatient);
        System.out.println("Se agregó correctamente al paciente.");
        CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
    }

    public static void addPatientToList(Patient patient) {
        patientList.add(patient);
    }

    public static void removePatient(int patientId) {
        for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
            Patient patient = iterator.next();
            if (patient.getPatientId() == patientId) {
                iterator.remove(); // Elimina el paciente de la lista
                System.out.println("Paciente eliminado exitosamente.");
                CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
                return; // Salir del método una vez que se elimine el paciente
            }
        }
        System.out.println("No se encontró ningún paciente con el ID especificado.");
    }

    public static void updatePatient(int patientId, String fullName, int age, float weight, float height,
            String[] preexistingConditions) {
        for (Patient patient : patientList) {
            if (patient.getPatientId() == patientId) {
                patient.setFullName(fullName);
                patient.setAge(age);
                patient.setWeight(weight);
                patient.setHeight(height);
                patient.setPreexistingConditions(Arrays.asList(preexistingConditions));
                CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
                System.out.println("Se actualizó correctamente la información del paciente.");
                return;
            }
        }
        System.out.println("No se encontró ningún paciente con el ID especificado.");
    }

    public static void printPatientList() {
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }
}
