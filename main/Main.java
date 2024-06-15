import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Helpers.CSVDietitian;
import Helpers.CSVPatient;
import Models.DietPlan;
import Models.Dietitian;
import Models.Meal;
import Models.Patient;
import Services.PatientService;

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
                case 0:
                    System.out.println("Gracias por usar nuestro programa.");
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
        int i = 1; // Controla el bucle do-while

        // Solicitar información adicional necesaria para crear DietPlan
        System.out.print("Ingrese el ID del plan: ");
        int planId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese las calorías diarias: ");
        float dailyCalories = scanner.nextFloat();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese la distribución de macronutrientes: ");
        String macronutrientDistribution = scanner.nextLine();

        System.out.print("Ingrese recomendaciones específicas: ");
        String specificRecommendations = scanner.nextLine();

        Patient patient = new Patient();
        Dietitian dietitian = new Dietitian();

        try {
            do {
                System.out.println("¿Desea añadir desayuno? (si/no)");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles del desayuno:");

                    System.out.println("1. Quesos y Derivados Lácteos:");
                    // Aquí iría la lógica para mostrar opciones de quesos y derivados lácteos
                    System.out.println("Selecciona un queso y derivado lácteo: ");
                    String cheeseOption = scanner.nextLine();

                    System.out.println("2. Harinas, Cereales y Derivados:");
                    // Aquí iría la lógica para mostrar opciones de harinas, cereales y derivados
                    System.out.println("Selecciona una harina, cereal o derivado: ");
                    String flourOption = scanner.nextLine();

                    System.out.println("3. Frutas:");
                    // Aquí iría la lógica para mostrar opciones de frutas
                    System.out.println("Selecciona una fruta: ");
                    String fruitOption = scanner.nextLine();

                    System.out.println("4. Grasas:");
                    // Aquí iría la lógica para mostrar opciones de grasas
                    System.out.println("Selecciona una grasa: ");
                    String fatOption = scanner.nextLine();

                    Meal breakfast = new Meal("Desayuno", cheeseOption, flourOption, fruitOption, fatOption, "Morning");
                    meals.add(breakfast);
                }

                System.out.println("¿Desea añadir almuerzo? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles del almuerzo:");
                    // Aquí iría la lógica para preguntar detalles específicos del almuerzo
                    System.out.print("Meats: ");
                    String meats = scanner.nextLine();
                    System.out.print("Legumes: ");
                    String legumes = scanner.nextLine();
                    System.out.print("Flour, cereals and derivados: ");
                    String flour = scanner.nextLine();
                    System.out.print("Vegetables: ");
                    String vegetables = scanner.nextLine();
                    System.out.print("Fats: ");
                    String fats = scanner.nextLine();

                    Meal lunch = new Meal("Almuerzo", meats, legumes, flour, vegetables, fats, "Afternoon");
                    meals.add(lunch);
                }

                System.out.println("¿Desea añadir cena? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles de la cena:");
                    // Aquí iría la lógica para preguntar detalles específicos de la cena
                    System.out.print("Cheese and substitutes: ");
                    String cheese = scanner.nextLine();
                    System.out.print("Flour, cereals and derivados: ");
                    String flour = scanner.nextLine();
                    System.out.print("Fruits: ");
                    String fruits = scanner.nextLine();
                    System.out.print("Fats: ");
                    String fats = scanner.nextLine();

                    Meal dinner = new Meal("Cena", cheese, flour, fruits, fats, "Evening");
                    meals.add(dinner);
                }

                System.out.println("¿Desea añadir una mini comida? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles de la mini comida:");
                    // Aquí iría la lógica para preguntar detalles específicos de la mini comida
                    System.out.print("Cheese and substitutes: ");
                    String cheese = scanner.nextLine();
                    System.out.print("Flour, cereals and derivados: ");
                    String flour = scanner.nextLine();
                    System.out.print("Time for eat (morning, afternoon, night): ");
                    String timeOfDay = scanner.nextLine();

                    Meal snack = new Meal("Mini comida", cheese, flour, timeOfDay);
                    meals.add(snack);
                }

                System.out.println("¿Desea añadir una Merienda? (si/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese los detalles de la Merienda:");
                    // Aquí iría la lógica para preguntar detalles específicos de la merienda
                    System.out.print("Fruits: ");
                    String fruits = scanner.nextLine();
                    System.out.print("Nuts and seeds: ");
                    String nuts = scanner.nextLine();
                    System.out.print("Time for eat (morning, afternoon, night): ");
                    String timeOfDay = scanner.nextLine();

                    Meal snack = new Meal("Merienda", fruits + ", " + nuts, timeOfDay);
                    meals.add(snack);
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

                // Guardar las comidas en un archivo CSV
                Meal.saveMealsToCSV(meals);

                i = 0; // Finalizar el bucle después de un ciclo completo
            } while (i != 0);

        } finally {
            // Cierre de recursos o cualquier limpieza necesaria
            System.out.println("Cierre de recursos o cualquier limpieza necesaria.");
            // Puedes cerrar el scanner si es necesario
            scanner.close();
        }
    }

    private static void registerMeal(Scanner scanner) {
        System.out.print("Ingrese el ID del paciente: ");
        int patientId = Integer.parseInt(scanner.nextLine());

        Patient patient = Patient.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }
        System.out.println("Ingresa los detalles de la comida:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Porción: ");
        float portion = Float.parseFloat(scanner.nextLine());

        System.out.println("¿En qué grupo de alimentos desea agregar la nueva comida?");
        System.out.println("1. Quesos y derivados lácteos");
        System.out.println("2. Grasas");
        System.out.println("3. Harinas, cereales y derivados");
        System.out.println("4. Frutas");
        System.out.println("5. Carnes magras");
        System.out.println("6. Leguminosas");
        System.out.println("7. Plan de comidas");
        System.out.println("8. Leches");
        System.out.println("9. Nueces y semillas");
        System.out.println("10. Verduras");
        System.out.print("Ingrese el número correspondiente al grupo: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Meal.addMealToCSV("cheeses_and_substitutes.csv", id, name, portion);
                break;
            case 2:
                Meal.addMealToCSV("fats.csv", id, name, portion);
                break;
            case 3:
                Meal.addMealToCSV("flours_cereals_and_derivados.csv", id, name, portion);
                break;
            case 4:
                Meal.addMealToCSV("fruits.csv", id, name, portion);
                break;
            case 5:
                Meal.addMealToCSV("lean_meats.csv", id, name, portion);
                break;
            case 6:
                Meal.addMealToCSV("leguminosas.csv", id, name, portion);
                break;
            case 7:
                Meal.addMealToCSV("meal_plan.csv", id, name, portion);
                break;
            case 8:
                Meal.addMealToCSV("milks.csv", id, name, portion);
                break;
            case 9:
                Meal.addMealToCSV("nuts_and_seeds.csv", id, name, portion);
                break;
            case 10:
                Meal.addMealToCSV("vegetables.csv", id, name, portion);
                break;
            default:
                System.out.println("Opción no válida. No se ha agregado la comida a ningún archivo.");
        }
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

        PatientService.addPatient(patientId, fullName, age, weight, height, preexistingConditionsArray);

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

        PatientService.updatePatient(patientId, fullName, age, weight, height, preexistingConditionsArray);

    }

    // Method to delete a patient
    private static void deletePatient(Scanner scanner) {
        // Implementación del método
        System.out.println("Escribe el id del paciente a eliminar.");
        int patientId = Integer.parseInt(scanner.nextLine());
        PatientService.removePatient(patientId);
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
