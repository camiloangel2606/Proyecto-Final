import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dietitian extends Patient {
    private int dietitianId;
    private String fullName;
    private List<String> preexistingConditions;
    private static List<Dietitian> dietitianList = new ArrayList<>();

    public Dietitian(int dietitianId, String fullName, List<String> preexistingConditions) {
        // Llamada al constructor de la clase madre (Patient)
        super(dietitianId, fullName, 0, 0.0f, 0.0f, preexistingConditions);
        this.dietitianId = dietitianId;
        this.fullName = fullName;
        this.preexistingConditions = preexistingConditions;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public void setPatientId(int patientId) {
        this.dietitianId = patientId;
    }

    @Override
    public int getPatientId() {
        return this.dietitianId;
    }

    @Override
    public void setPreexistingConditions(List<String> preexistingConditions) {
        this.preexistingConditions = preexistingConditions;
    }

    @Override
    public List<String> getPreexistingConditions() {
        return this.preexistingConditions;
    }

    public static void addDietitian(int patientId, String fullName, String[] preexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
        Dietitian newDietitian = new Dietitian(patientId, fullName, preexistingConditionsList);
        for (Dietitian dietitian : dietitianList) {
            if (dietitian.getPatientId() == patientId) {
                System.out.println("El Nutricionista" + fullName + "ya se encuentra agregado.");
                return;
            }
        }
        dietitianList.add(newDietitian);
        System.out.println("Se agregó correctamente al nutricionista " + fullName + ".");
    }

    @Override
    public String toString() {
        return "Dietitian[DietitianId:" + dietitianId + ", FullName:" + fullName +
                ", Specialitys:" + preexistingConditions + "]";
    }
}
