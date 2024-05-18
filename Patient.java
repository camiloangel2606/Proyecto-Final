import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {
    // Campos para almacenar la información del paciente
    private int PatientId;
    private String FullName;
    private int Age;
    private float Weight;
    private float Height;
    private List<String> preexistingConditions;

    // Lista estática para almacenar todos los pacientes
    private static List<Patient> patientList = new ArrayList<>();

    // Constructor para inicializar los campos del paciente
    public Patient(int PatientId, String FullName, int Age, float Weight, float Height,
            List<String> preexistingConditions) {
        this.PatientId = PatientId;
        this.FullName = FullName;
        this.Age = Age;
        this.Weight = Weight;
        this.Height = Height;
        this.preexistingConditions = preexistingConditions;
    }

    // Métodos getters y setters para los campos
    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int PatientId) {
        this.PatientId = PatientId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float Height) {
        this.Height = Height;
    }

    public List<String> getPreexistingConditions() {
        return preexistingConditions;
    }

    public void setPreexistingConditions(List<String> preexistingConditions) {
        this.preexistingConditions = preexistingConditions;
    }

    // Método para añadir un paciente a la lista
    public static void addPatient(int PatientId, String FullName, int Age, float Weight, float Height,
            String[] PreexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(PreexistingConditions);
        Patient newPatient = new Patient(PatientId, FullName, Age, Weight, Height, preexistingConditionsList);
        patientList.add(newPatient);
    }

    // Método para mostrar la lista de pacientes
    public static void printPatientList() {
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

    // Método toString para una representación en cadena de la información del
    // paciente
    @Override
    public String toString() {
        return "Patient[PatientId:" + PatientId + ", FullName:" + FullName + ", Age:" + Age + ", Weight:" + Weight
                + ", Height:" + Height
                + ", PreexistingConditions:" + preexistingConditions + "]";
    }
}
