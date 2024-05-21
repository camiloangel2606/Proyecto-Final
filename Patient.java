import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Patient {
    private int patientId;
    private String fullName;
    private int birthYear; // Almacena el año de nacimiento en lugar de la edad
    private float weight;
    private float height;
    private List<String> preexistingConditions;

    private static List<Patient> patientList = new ArrayList<>();

    public Patient(int patientId, String fullName, int birthYear, float weight, float height,
            List<String> preexistingConditions) {
        this.patientId = patientId;
        this.fullName = capitalizeName(fullName);
        this.birthYear = birthYear;
        this.weight = weight;
        this.height = height;
        this.preexistingConditions = preexistingConditions;
    }

    // Métodos getters y setters para los campos
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
        this.fullName = capitalizeName(fullName);
    }

    public int getAge() {
        int currentYear = java.time.Year.now().getValue(); // Obtener el año actual
        return currentYear - birthYear;
    }

    public void setAge(int birthYear) {
        this.birthYear = birthYear;
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
        return "Patient[PatientId:" + patientId + ", FullName:" + fullName + ", Age:" + birthYear + ", Weight:" + weight
                + ", Height:" + height + ", PreexistingConditions:" + preexistingConditions + "]";
    }

    public static void addPatient(int patientId, String fullName, int birthYear, float weight, float height,
            String[] preexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
        Patient newPatient = new Patient(patientId, capitalizeName(fullName), birthYear, weight, height,
                preexistingConditionsList);
        for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
            Patient patient = iterator.next();
            if (patient.getPatientId() == patientId) {
                System.out.println("El paciente ya se encuentra agregado.");
                return; // Salir del método si el paciente ya está agregado
            }
        }
        patientList.add(newPatient);
        System.out.println("Se agregó correctamente al paciente.");
        CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
    }

    public static void addPatientToList(Patient patient) {
        patientList.add(patient);
    }

    public static void removePatient(int PatientId) {
        for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
            Patient patient = iterator.next();
            if (patient.getPatientId() == PatientId) {
                iterator.remove(); // Elimina el paciente de la lista
                System.out.println("Paciente eliminado exitosamente.");
                CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
                return; // Salir del método una vez que se elimine el paciente
            }
        }
        System.out.println("No se encontró ningún paciente con el ID especificado.");
    }

    public static void updatePatient(int patientId, String fullName, int birthYear, float weight, float height,
            String[] preexistingConditions) {
        for (Patient patient : patientList) {
            if (patient.getPatientId() == patientId) {
                patient.setFullName(capitalizeName(fullName));
                patient.setAge(birthYear);
                patient.setWeight(weight);
                patient.setHeight(height);
                patient.setPreexistingConditions(Arrays.asList(preexistingConditions));
                System.out.println("Se actualizó correctamente la información del paciente.");
                CSVPatient.saveInfo(patientList); // Guardamos la lista actualizada en archivos CSV.
                return; // Salir del método una vez que se actualice el paciente
            }
        }
        System.out.println("No se encontró ningún paciente con el ID especificado.");
    }

    public static void printPatientList() {
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

    public static List<Patient> getPatientList() {
        return patientList;
    }

    // Método para capitalizar la primera letra de cada palabra
    public static String capitalizeName(String name) {// Usaremos este metodo para ajustar los nombres de las personas.
        String[] words = name.split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return capitalized.toString().trim();
    }
}
