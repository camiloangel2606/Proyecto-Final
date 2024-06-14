package Models;

import java.util.ArrayList;
import java.util.List;

public class Dietitian extends Patient {
    private int dietitianId;
    private String fullName;
    private List<String> preexistingConditions;

    public Dietitian(int dietitianId, String fullName, List<String> preexistingConditions) {
        // Llamada al constructor de la clase madre (Patient)
        super(dietitianId, capitalizeName(fullName), 0, 0.0f, 0.0f, preexistingConditions);
        this.dietitianId = dietitianId;
        this.fullName = capitalizeName(fullName);
        this.preexistingConditions = preexistingConditions;
    }

    public Dietitian() {
        // Constructor vacío
        super(); // Llama al constructor sin argumentos de la clase madre (Patient)
        this.dietitianId = 0; // O inicializa con un valor por defecto según sea necesario
        this.fullName = "";
        this.preexistingConditions = new ArrayList<>(); // Inicializa la lista de condiciones preexistentes
    }

    public static void addDietitian(int dietitianId, String fullName, String[] preexistingConditionsArray) {
        // Implementación del método
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = capitalizeName(fullName);
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    public void setDietitianId(int dietitianId) {
        this.dietitianId = dietitianId;
    }

    public int getDietitianId() {
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
}