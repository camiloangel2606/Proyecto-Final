package Models;

import java.util.ArrayList;
import java.util.List;

import Services.PatientService;

public class Patient {
    private int patientId;
    private String fullName;
    private int birthYear; // Almacena el año de nacimiento en lugar de la edad
    private float weight;
    private float height;
    private List<String> preexistingConditions;
    private List<Meal> mealPlan; // this field to store the meal plan
    private DietPlan dietPlan; // this is so usefull to i can to asign a dietplan to patient (in class main
                               // with the method "generateMealPlan")

    // Metodos
    public Patient() {
        // Constructor vacío
        this.patientId = 0; // O inicializa con un valor por defecto según sea necesario
        this.fullName = "";
        this.birthYear = 0;
        this.weight = 0.0f;
        this.height = 0.0f;
        this.preexistingConditions = new ArrayList<>(); // Inicializa la lista de condiciones preexistentes
        this.mealPlan = new ArrayList<>(); // Inicializa el plan de comidas
    }

    public static Patient getPatientById(int id) {
        for (Patient patient : PatientService.getPatientList()) {
            if (patient.getPatientId() == id) {
                return patient; // Devuelve el paciente si se encuentra
            }
        }
        return null; // Devuelve null si no se encuentra el paciente
    }

    // Metodo para obtener un DietPlan
    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public static void addPatient(int patientId, String fullName, int age, float weight, float height,
            String[] preexistingConditionsArray) {
        // Implementación del método
    }

    public static void removePatient(int patientId) {
        // Implementación del método
    }

    public static void updatePatient(int patientId, String fullName, int age, float weight, float height,
            String[] preexistingConditionsArray) {
        // Implementación del método
    }

    public Patient(int patientId, String fullName, int birthYear, float weight, float height,
            List<String> preexistingConditions) {
        this.patientId = patientId;
        this.fullName = capitalizeName(fullName);
        this.birthYear = birthYear;
        this.weight = weight;
        this.height = height;
        this.preexistingConditions = preexistingConditions;
        this.mealPlan = new ArrayList<>(); // Initialize the meal plan list
    }

    // getters y setters
    public void setFullName(String fullName) {
        this.fullName = capitalizeName(fullName);
    }

    public void setAge(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setPreexistingConditions(List<String> preexistingConditions) {
        this.preexistingConditions = preexistingConditions;
    }

    public List<Meal> getMealPlan() {
        return mealPlan;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return birthYear; // or calculate the age based on the birth year
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public List<String> getPreexistingConditions() {
        return preexistingConditions;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

    @Override
    public String toString() {
        return "Patient[PatientId:" + patientId + ", FullName:" + fullName + ", Age:" + birthYear + ", Weight:" + weight
                + ", Height:" + height + ", PreexistingConditions:" + preexistingConditions + "]";
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