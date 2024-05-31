import Helpers.CSVPatient;
import Models.Dietitian;
import Models.Meal;
import Models.Patient;
import Models.DietPlan;
import Helpers.CSVDietitian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Constants for menu titles
    private static final String MENU_TITLE = "Welcome to the Patient Diet System.";
    private static final String PATIENT_MENU_TITLE = "Patient Management.";
    private static final String DIETITIAN_MENU_TITLE = "Dietitian Management.";
    private static final String MEAL_PLAN_MENU_TITLE = "Meal Plan.";
    private static final String MEAL_REGISTRATION_MENU_TITLE = "Meal Registration.";

    public static void main(String[] args) {
        // Load patient information from CSV file at the start of the program
       
        CSVPatient.loadInfo();
        CSVDietitian.loadInfo();

        // Main menu
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println(MENU_TITLE);
            System.out.println("(1) " + PATIENT_MENU_TITLE);
            System.out.println("(2) " + DIETITIAN_MENU_TITLE);
            System.out.println("(3) " + MEAL_PLAN_MENU_TITLE);
            System.out.println("(4) " + MEAL_REGISTRATION_MENU_TITLE);
            System.out.println("(0) Exit.");
            option = Integer.parseInt(scanner.nextLine());

            // Switch statement to handle different menu options
            switch (option) {
                case 1:
                    managePatients(scanner);
                    break;
                case 2:
                    manageDietitians(scanner);
                    break;
                case 3:
                    generateMealPlan(scanner);
                    break;
                case 4:
                    registerMeal(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    // Method to generate a meal plan
private static void generateMealPlan(Scanner scanner) {
    System.out.println("Ingresa el ID del paciente:");
    int patientId = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    Patient patient = Patient.getPatientById(patientId);
    if (patient == null) {
        System.out.println("No se encontró un paciente con el ID proporcionado.");
        return;
    }

    Dietitian dietitian = null; // Aquí debes obtener el dietitian correspondiente al paciente

    // Solicitar al usuario los detalles del plan de alimentación
    System.out.println("Ingresa los detalles del plan de alimentación:");
    System.out.print("ID del plan: ");
    int planId = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    System.out.print("Calorías diarias: ");
    int dailyCalories = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    System.out.print("Distribución de macronutrientes: ");
    String macronutrientDistribution = scanner.nextLine();

    System.out.print("Recomendaciones específicas: ");
    String specificRecommendations = scanner.nextLine();

    // Obtener la lista de comidas registradas
    List<Meal> meals = Meal.getMealList();

    // por si tengo que añadir lo que ya esta en meal System.out.println("Ingresa los detalles de las comidas:");

    
    // Crear una instancia de DietPlan con los detalles proporcionados y asignar el plan al paciente
    DietPlan dietPlan = new DietPlan(planId, dailyCalories, macronutrientDistribution, specificRecommendations, patient, dietitian, meals);
    patient.setDietPlan(dietPlan);

    System.out.println("Plan de alimentación generado exitosamente:");
    System.out.println(dietPlan); // Muestra los detalles del plan de alimentación
}

// Method to register a meal
private static void registerMeal(Scanner scanner) {
    // Implementación del método
     // Código para registrar una comida
    System.out.println("Ingresa los detalles de la comida:");
    System.out.print("Nombre: ");
    String name = scanner.nextLine();
    System.out.print("Macronutrientes: ");
    String macronutrients = scanner.nextLine();
    System.out.print("Calorías: ");
    int calories = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    //The user should to write (yes or yes) the 3 words
    System.out.print("Time of day (morning, afternoon, evening): ");
    String timeOfDay = scanner.nextLine();
    while (!timeOfDay.equals("morning") && !timeOfDay.equals("afternoon") && !timeOfDay.equals("evening")) {
        System.out.println("Invalid input. Please enter 'morning', 'afternoon', or 'evening'.");
        System.out.print("Time of day (morning, afternoon, evening): ");
        timeOfDay = scanner.nextLine();
    }
    

    Meal meal = new Meal(name, macronutrients, calories, timeOfDay);
    List<Meal> mealList = new ArrayList<>(); // Create a new List<Meal> object
    mealList.add(meal); // Add the new Meal object to the List
    Meal.addMealToList(mealList, meal); // Pass the List<Meal> and Meal objects to the addMealToList method
    System.out.println("Comida registrada exitosamente.");

}

// Method to register a patient
private static void registerPatient(Scanner scanner) {
    // Implementación del método
    System.out.println("Escribe el id del paciente.");
                        int patientId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Escribe el nombre completo del paciente.");
                        String fullName = scanner.nextLine();
                        System.out.println("Escribe el año de nacimiento del paciente.");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.println("Escribe el peso del paciente.");
                        float weight = Float.parseFloat(scanner.nextLine());
                        System.out.println("Escribe la altura del paciente.");
                        float height = Float.parseFloat(scanner.nextLine());
                        System.out.println("Escribe las condiciones preexistentes separándolas con ','");
                        String preexistingConditions = scanner.nextLine();

                        // Divide la entrada en partes individuales usando el delimitador ","
                        String[] preexistingConditionsArray = preexistingConditions.split(",");

                        // Elimina los espacios en blanco alrededor de cada condición
                        for (int k = 0; k < preexistingConditionsArray.length; k++) {
                            preexistingConditionsArray[k] = preexistingConditionsArray[k].trim();
                        }

                        Patient.addPatient(patientId, fullName, age, weight, height, preexistingConditionsArray);

}

// Method to update a patient
private static void updatePatient(Scanner scanner) {
    // Implementación del método
    System.out.println("Escribe el id del paciente a actualizar.");
    int patientId = Integer.parseInt(scanner.nextLine());
    System.out.println("Escribe el nuevo nombre completo del paciente.");
    String fullName = scanner.nextLine();
    System.out.println("Escribe el año de nacimiento del paciente.");
    int age = Integer.parseInt(scanner.nextLine());
    System.out.println("Escribe el nuevo peso del paciente.");
    float weight = Float.parseFloat(scanner.nextLine());
    System.out.println("Escribe la nueva altura del paciente.");
    float height = Float.parseFloat(scanner.nextLine());
    System.out.println("Escribe las nuevas condiciones preexistentes separándolas con ','");
    String preexistingConditions = scanner.nextLine();

    // Divide la entrada en partes individuales usando el delimitador ","
    String[] preexistingConditionsArray = preexistingConditions.split(",");

    // Elimina los espacios en blanco alrededor de cada condición
    for (int k = 0; k < preexistingConditionsArray.length; k++) {
        preexistingConditionsArray[k] = preexistingConditionsArray[k].trim();
    }

    Patient.updatePatient(patientId, fullName, age, weight, height, preexistingConditionsArray);


    
}

// Method to delete a patient
private static void deletePatient(Scanner scanner) {
    // Implementación del método
    System.out.println("Escribe el id del paciente a eliminar.");
    int patientId = Integer.parseInt(scanner.nextLine());
    Patient.removePatient(patientId);
}

// Method to register a dietitian
private static void registerDietitian(Scanner scanner) {
   // método
   System.out.println("Ingresa el id del nutricionista.");
                        int dietitianId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Ingresa el nombre del nutricionista.");
                        String FullName = scanner.nextLine();
                        System.out.println("Ingresa las especialidades del nutricionista separadas por ','");
                        String preexistingConditions = scanner.nextLine();

                        // Divide la entrada en partes individuales usando el delimitador ","
                        String[] preexistingConditionsArray = preexistingConditions.split(",");

                        // Elimina los espacios en blanco alrededor de cada condición
                        for (int k = 0; k < preexistingConditionsArray.length; k++) {
                            preexistingConditionsArray[k] = preexistingConditionsArray[k].trim();
                        }

                        Dietitian.addDietitian(dietitianId, FullName, preexistingConditionsArray);
                    
}

// Method to assign a dietitian to a patient
private static void assignDietitianToPatient(Scanner scanner) {
    // Implementación del método
}

    // Method to manage patients
    private static void managePatients(Scanner scanner) {
        int option;
        do {
            System.out.println(PATIENT_MENU_TITLE);
            System.out.println("(1) Register a new patient.");
            System.out.println("(2) Update patient information.");
            System.out.println("(3) Delete patient information.");
            System.out.println("(0) Return to main menu.");
            option = Integer.parseInt(scanner.nextLine());

            // Switch statement to handle different patient management options
            switch (option) {
                case 1:
                    registerPatient(scanner);
                    break;
                case 2:
                    updatePatient(scanner);
                    break;
                case 3:
                    deletePatient(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    // Method to manage dietitians
    private static void manageDietitians(Scanner scanner) {
        int option;
        do {
            System.out.println(DIETITIAN_MENU_TITLE);
            System.out.println("(1) Register a new dietitian.");
            System.out.println("(2) Assign a dietitian to a patient.");
            System.out.println("(0) Return to main menu.");
            option = Integer.parseInt(scanner.nextLine());

            // Switch statement to handle different dietitian management options
            switch (option) {
                case 1:
                    registerDietitian(scanner);
                    break;
                case 2:
                    assignDietitianToPatient(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    
}