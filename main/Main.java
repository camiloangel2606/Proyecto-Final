import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Helpers.CSVDietPlan;
import Helpers.CSVDietitian;
import Helpers.CSVPatient;
import Models.DietPlan;
import Models.Dietitian;
import Models.Meal;
import Models.Patient;

public class Main {
    // Constants for menu titles
    private static final String MENU_TITLE = "Welcome to the Patient Diet System.";
    private static final String PATIENT_MENU_TITLE = "Patient Management.";
    private static final String DIETITIAN_MENU_TITLE = "Dietitian Management.";
    private static final String MEAL_PLAN_MENU_TITLE = "Meal Plan.";
    private static final String MEAL_REGISTRATION_MENU_TITLE = "Meal Registration.";

    public static void main(String[] args) throws IOException {
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

    // Metodos para generar plan de alimentación, registro comida y manejar
    // pacientes y dientistas

    // Method to generate a meal plan
    private static void generateMealPlan(Scanner scanner) {
        List<Meal> meals = new ArrayList<>();
        int i = 1; // Asumimos que esto controla el bucle do-while
        // Solicitar información adicional necesaria para crear DietPlan
        System.out.print("Ingrese el ID del plan: ");
        int planId = scanner.nextInt();
        scanner.nextLine(); // consumir el salto de línea

        System.out.print("Ingrese las calorías diarias: ");
        float dailyCalories = scanner.nextFloat();
        scanner.nextLine(); // consumir el salto de línea

        System.out.print("Ingrese la distribución de macronutrientes: ");
        String macronutrientDistribution = scanner.nextLine();

        System.out.print("Ingrese recomendaciones específicas: ");
        String specificRecommendations = scanner.nextLine();

        // Aquí asumo que hay una forma de crear o obtener el paciente y el dietista
        Patient patient = new Patient(); // Crea una instancia de Patient según tu lógica
        Dietitian dietitian = new Dietitian(); // Crea una instancia de Dietitian según tu lógica

        try {
            // Obtener las opciones disponibles de cada grupo de alimentos
            List<String[]> cheesesAndSubstitutesOptions = CSVDietPlan.readCheesesAndSubstitutes();
            List<String[]> floursCerealsAndDerivadosOptions = CSVDietPlan.readFloursCerealsAndDerivados();
            List<String[]> fruitsOptions = CSVDietPlan.readFruits();
            List<String[]> fatsOptions = CSVDietPlan.readFats();
            List<String[]> vegetablesOptions = CSVDietPlan.readVegetables();
            List<String[]> nutsAndSeedsOptions = CSVDietPlan.readNutsAndSeeds();
            List<String[]> leguminosasOptions = CSVDietPlan.readLeguminosas();
            List<String[]> leanMeatsOptions = CSVDietPlan.readLeanMeats();

            do {
                System.out.println("¿Desea añadir desayuno? (si/no)");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles del desayuno:");

                    System.out.println("1. Quesos y Derivados Lácteos:");
                    for (int j = 0; j < cheesesAndSubstitutesOptions.size(); j++) {
                        System.out.println((j + 1) + ". " + cheesesAndSubstitutesOptions.get(j)[0]);
                    }
                    System.out.print(
                            "Selecciona un queso y derivado lácteo (1-" + cheesesAndSubstitutesOptions.size() + "): ");
                    int mealIndex1 = scanner.nextInt() - 1;
                    String[] selectedOption1 = cheesesAndSubstitutesOptions.get(mealIndex1);
                    scanner.nextLine(); // consume newline

                    System.out.println("2. Harinas, Cereales y Derivados:");
                    for (int j = 0; j < floursCerealsAndDerivadosOptions.size(); j++) {
                        System.out.println((j + 1) + ". " + floursCerealsAndDerivadosOptions.get(j)[0]);
                    }
                    System.out.print("Selecciona una harina, cereal o derivado (1-"
                            + floursCerealsAndDerivadosOptions.size() + "): ");
                    int mealIndex2 = scanner.nextInt() - 1;
                    String[] selectedOption2 = floursCerealsAndDerivadosOptions.get(mealIndex2);
                    scanner.nextLine(); // consume newline

                    System.out.println("3. Frutas:");
                    for (int j = 0; j < fruitsOptions.size(); j++) {
                        System.out.println((j + 1) + ". " + fruitsOptions.get(j)[0]);
                    }
                    System.out.print("Selecciona una fruta (1-" + fruitsOptions.size() + "): ");
                    int mealIndex3 = scanner.nextInt() - 1;
                    String[] selectedOption3 = fruitsOptions.get(mealIndex3);
                    scanner.nextLine(); // consume newline

                    System.out.println("4. Grasas:");
                    for (int j = 0; j < fatsOptions.size(); j++) {
                        System.out.println((j + 1) + ". " + fatsOptions.get(j)[0]);
                    }
                    System.out.print("Selecciona una grasa (1-" + fatsOptions.size() + "): ");
                    int mealIndex4 = scanner.nextInt() - 1;
                    String[] selectedOption4 = fatsOptions.get(mealIndex4);
                    scanner.nextLine(); // consume newline

                    Meal breakfast = new Meal("Desayuno", selectedOption1[0], selectedOption2[0], selectedOption3[0],
                            selectedOption4[0], "Morning");
                    meals.add(breakfast);
                }

                System.out.println("¿Desea añadir almuerzo? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles del almuerzo:");
                    System.out.print("Meats: ");
                    String meats = scanner.nextLine();
                    System.out.print("Legumes: ");
                    String legumes = scanner.nextLine();
                    System.out.print("Flour, cereals and derivados: ");
                    String flour2 = scanner.nextLine();
                    System.out.print("Vegetables: ");
                    String vegetables = scanner.nextLine();
                    System.out.print("Fats: ");
                    String fats2 = scanner.nextLine();

                    Meal lunch = new Meal("Almuerzo", meats, legumes, flour2, vegetables, fats2, "Afternoon");
                    meals.add(lunch);
                }

                System.out.println("¿Desea añadir cena? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles de la cena:");
                    System.out.print("Cheese and substitutes: ");
                    String cheese2 = scanner.nextLine();
                    System.out.print("Flour, cereals and derivados: ");
                    String flour3 = scanner.nextLine();
                    System.out.print("Fruits: ");
                    String fruits2 = scanner.nextLine();
                    System.out.print("Fats: ");
                    String fats3 = scanner.nextLine();

                    Meal dinner = new Meal("Cena", cheese2, flour3, fruits2, fats3, "Evening");
                    meals.add(dinner);
                }

                System.out.println("¿Desea añadir una mini comida? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles de la mini comida:");
                    System.out.print("Cheese and substitutes: ");
                    String cheese3 = scanner.nextLine();
                    System.out.print("Flour, cereals and derivados: ");
                    String flour4 = scanner.nextLine();
                    System.out.print("Time for eat (morning, afternoon, night): ");
                    String timeOfDay = scanner.nextLine();

                    Meal snack = new Meal("Mini comida", cheese3, flour4, timeOfDay);
                    meals.add(snack);
                }

                System.out.println("¿Desea añadir una Merienda? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles de la Merienda:");
                    System.out.print("Fruits: ");
                    String fruits3 = scanner.nextLine();
                    System.out.print("Nuts and seeds: ");
                    String nuts = scanner.nextLine();
                    System.out.print("Time for eat (morning, afternoon, night): ");
                    String timeOfDay2 = scanner.nextLine();

                    float calories = 150; // Esto es un ejemplo, ajusta según sea necesario
                    Meal merienda = new Meal("Merienda", fruits3 + ", " + nuts, calories, timeOfDay2);
                    meals.add(merienda);
                }

                System.out.println("¿Desea ver sus comidas? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    for (Meal meal : meals) {
                        System.out.println(meal);
                    }
                }

                // Crear una instancia de DietPlan con los detalles proporcionados y asignar el
                // plan al paciente
                DietPlan dietPlan = new DietPlan(planId, dailyCalories, macronutrientDistribution,
                        specificRecommendations, patient, dietitian, meals);
                patient.setDietPlan(dietPlan);

                System.out.println("Plan de alimentación generado exitosamente:");
                System.out.println(dietPlan); // Muestra los detalles del plan de alimentación
                i = 0; // Asumimos que el bucle debe terminar después de un ciclo completo
            } while (i != 0);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer los archivos CSV: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cierre de recursos o cualquier limpieza necesaria
            System.out.println("Cierre de recursos o cualquier limpieza necesaria.");
            // Puedes cerrar el scanner si es necesario
            scanner.close();
        }
    }

    private static void registerMeal(Scanner scanner) {
        System.out.println("Ingresa los detalles de la comida:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Macronutrientes: ");
        String macronutrients = scanner.nextLine();
        System.out.print("Calorías: ");
        float calories = Float.parseFloat(scanner.nextLine());
        System.out.print("Time of day (morning, afternoon, evening): ");
        String timeOfDay = scanner.nextLine();

        while (!timeOfDay.equalsIgnoreCase("morning") && !timeOfDay.equalsIgnoreCase("afternoon")
                && !timeOfDay.equalsIgnoreCase("evening")) {
            System.out.println("Entrada no válida. Por favor, ingresa 'morning', 'afternoon' o 'evening'.");
            System.out.print("Time of day (morning, afternoon, evening): ");
            timeOfDay = scanner.nextLine();
        }

        // Crea un nuevo objeto Meal con los parámetros proporcionados
        Meal meal = new Meal(id, name, macronutrients, calories, timeOfDay);
        Meal.addMealToList(null, meal); // Añadir la comida a la lista
        System.out.println("Comida registrada exitosamente: " + meal);
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

    // Métodos para registrar, actualizar y eliminar pacientes

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
        // método8
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

}
