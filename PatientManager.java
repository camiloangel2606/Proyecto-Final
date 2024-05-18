import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatientManager {
    private List<Patient> patientList = new ArrayList<>();

    public void listPatientAdd(int PatientId, String FullName, int Age, float Weight, float Height,
            String[] PreexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(PreexistingConditions);
        Patient newPatient = new Patient(PatientId, FullName, Age, Weight, Height, preexistingConditionsList);
        patientList.add(newPatient);
    }

    public void printPatientList() {
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }
}
