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
        super(dietitianId, capitalizeName(fullName), 0, 0.0f, 0.0f, preexistingConditions);
        this.dietitianId = dietitianId;
        this.fullName = capitalizeName(fullName);
        this.preexistingConditions = preexistingConditions;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = capitalizeName(fullName);
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

    // Método para capitalizar la primera letra de cada palabra
    public static String capitalizeName(String name) {
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

    public static void addDietitian(int dietitianId, String fullName, String[] preexistingConditions) {
        List<String> preexistingConditionsList = Arrays.asList(preexistingConditions);
        String capitalizedFullName = capitalizeName(fullName); // Capitalizar el nombre aquí
        Dietitian newDietitian = new Dietitian(dietitianId, capitalizedFullName, preexistingConditionsList);
        for (Dietitian dietitian : dietitianList) {
            if (dietitian.getPatientId() == dietitianId) {
                System.out.println("El Nutricionista " + capitalizedFullName + " ya se encuentra agregado.");
                return;
            }
        }
        dietitianList.add(newDietitian);
        CSVDietitian.saveInfo(dietitianList);

        System.out.println("Se agregó correctamente al nutricionista " + capitalizedFullName + ".");
    }

    public static void addDietitianToList(Dietitian dietitian) {
        dietitianList.add(dietitian);
    }

    @Override
    public String toString() {
        return "Dietitian[DietitianId:" + dietitianId + ", FullName:" + fullName +
                ", Specialities:" + preexistingConditions + "]";
    }

    public static void printdietitianList() {
        for (Patient dietitian : dietitianList) {
            System.out.println(dietitian);
        }
    }
}
