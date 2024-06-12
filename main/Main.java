import Helpers.CSVPatient;
import Models.Dietitian;
import Models.Meal;
import Models.Patient;
import Models.DietPlan;
import Helpers.CSVDietitian;
import Helpers.CSVMeal;
import Helpers.CSVDietPlan;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        // Load patient information from CSV file at the start of the program

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

    //Metodos para generar plan de alimentación, registro comida y manejar pacientes y dientistas
 
    // 
    // Method to generate a meal plan
private static void generateMealPlan(
        System.out.println("Ingresa el ID del paciente:");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consumir el
        

        if (patient == null) {
            System.out.println
            return;
            
        

        

        System.out.println("Ingresa los detalles del plan de alimenta
        System.out.print("ID del plan: ");
        int planId = scanner.nextInt();
        scanner.nextLine(); // Consumir
        

        int dailyCalories = scanner.nextInt();
        scanner.nextLine(); // Consumir el sal
        

        String macronutrientDistribution = scanner.nextLine();
        

        String specificRecommendations = scanner.nextLine(
        

        List<Meal> meals = Meal.getMealList(); // 
        

        List<String[]> cheesesAndSubstitutesOptions = CSVDietPlan.read
        List<String[]> floursCerealsAndDerivadosOptions = CSVDietPlan.readFloursCerealsAndDeri
        List<String[]> fruitsOptions = CSVDietPlan.readFruits();
        List<String[]> fatsOptions = CSVDietPlan.readFats();
        List<String[]> vegetablesOptions = CSVDietPlan.readV
        List<String[]> nutsAndSeedsOptions = CSVDietPlan.readNutsAndSeed
        List<String[]> leguminosasOptions = CSVDietPlan.readLeguminosas();
        List<String[]> leanMeatsOptions = CSVDietPlan.readLeanMeats();
        

        
        // 

         

        System.out.println("¿Desea añ
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("si")) 
            System.out.println("Ingrese los 
            List<Meal> mealsList = new ArrayList<>();
            

            for (int i = 0; i < cheesesAndSubstitutesOptions.size
                System.out.println((i + 1) + ". " + cheesesAndSubstitutesOp
                
            S
            int mealIndex1 = scanner.nextInt() - 1;
            String[] selectedOption1 = cheesesAndSu
            Meal meal1 = new Meal(selectedOption1[0], selectedOption1[1], selectedOp
            meals.add(meal1);
            

            

            for (int i = 0; i < floursCerealsAndDerivadosOptions.siz
                System.out.println((i + 1) + ". " + floursCerealsAndDerivadosOp
                
            S
            int mealIndex2 = 
                    scanner.nextInt() - 1;
            String[] selectedOption2 = floursCereal
            Meal meal2 = new Meal(selectedOption2[0], selectedOption2[1], selectedOption
            meals.add(meal2); 
            

            for (int i = 0; i < fruitsOptions
                System.out.println((i + 1) + ". " + fruitsOp
                
            S
            int mealIndex3 = scanner.nextInt() - 1;
            String[] selectedOption3 = fruitsOption
            Meal meal3 = new Meal(selectedOption3[0], selectedOption3
            meals.add(meal3);
            

            for (int i = 0; i < fatsOptions.s
                System.out.println((i + 1) + ". " + fatsOp
                
            S
            int mealIndex4 = scanner.nextInt() - 1;
            String[] selectedOption4 = fatsOptions.
            Meal meal4 = new Meal(selectedOption4[0], selectedOptio
            meals.add(meal4);
            

            meals.add(breakfast);
            
        

        System.out.println("¿Desea añ
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(
            System.out.println("Ingrese los 
            System.out.print("Meatas: ");
            String meats = scanner.nextLi
            System.out.print("Legumes: ");
            String legumes = scanner.nextL
            System.out.print("Flour, cerals and 
            String flour2 = scanner.nextLine();
            System.out.print("Vegetables: ");
            String vegetables = scanner.nextL
            System.out.print("Fats: ");
            String fats2 = scanner.next
            

            meals.add(lunch);
            
        

        System.out.println("¿Dese
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(
            System.out.println("Ingrese los 
            System.out.print("Cheese and substitutes: ");
            String cheese2 = scanner.nextLine();
            System.out.print("Flour, cerals and 
            String flour3 = scanner.nextLine();
            System.out.print("Fruits: ");
            String fruits2 = scanner.next
            System.out.print("Fats: ");
            String fats3 = scanner.next
            

            meals.add(dinner);
            
        

        System.out.println("¿Desea añadir una mini comida? (si/no)")
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(
            System.out.println("Ingrese los 
            System.out.print("Cheese and substitutes: ");
            String cheese3 = scanner.nextLine();
            System.out.print("Flour, cerals and 
            String flour4 = scanner.nextLine();
            System.out.print("Time for eat (mor
            String timeOfDay = scanner.nextLine();
            

            meals.add(snack);
            
        

        System.out.println("¿Desea añadir una Merienda? (si/no)")
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(
            System.out.println("Ingrese los 
            System.out.print("Fruits: ");
            String fruits3 = scanner.next
            System.out.print("Nuts an seeds: ");
            String nuts = scanner.nextLine();
            System.out.print("Time for eat (m
            String timeOfDay2 = scanner.nextLine();
            

            meals.add(merienda);
            
        

        System.out.println("¿Desea ver sus comidas? (si/no)");
        // 
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(
            for (Meal meal : meals) {
                System.out.println(me
                
            
        

        DietPlan dietPlan = new DietPlan(planId, dailyCalories, macronutrientDistributi
        // n, specificRecom
        patient.setDietPlan(dietPlan);
                
        

        System.out.println(dietPlan); // Muestra los detalles del plan de 
            

    

    private static void register
        // Implementación del método
         // Código para registrar un
        ystem.out.println("Ingresa los deta
        System.out.print("Nombre: ");
        String name = scanner.nextLin
        System.out.print("Macronutrientes
        String macronutrients = scanner.nextLi
        System.out.print("Calorías: ");
        int calories = scanner.nextInt(
        scanner.nextLine(); // Consumir e
        

        Sy stem.out.print("Time of day (morning, afternoon, 
        String timeOfDay = scanner.nextLine();
        while (!timeOfDay.equals("morning") &&
            System.out.println("Invalid input. Please enter 'morning', 'afternoon', or 'evening'.");
            System.out.print("Time of day (morning, afternoon, evening): ");
            timeOfDay = scanner.nextLine();
            
        

        List<Meal> mealList = new ArrayList<>(); // Create a new List<Me
        mealList.add(meal); // Add the new Meal object to the List
        Meal.addMealToList(mealList, meal); // Pass the List<Meal>
        System.out.println("Comida registrada exitosamente.");
        
    

    private static void managePa
       int option;
        do {
            
            System.out.println("(1) Register a new 
            System.out.println("(2) Update patient information
            System.out.println("(3) Delete patient information.");
            System.out.println("(0) Return to main menu.");
            option = Integer.parseInt(scanner.nextLine());
            

            switch (option) {
                case 1:
                    reg
                    break;
                     2:
                    upd
                    break;
                     3:
                    del
                    break;
                    ult:
                    Syst
                    
            i
        
    

    private static void manageDiet
        int option;
        do {
            
            System.out.println("(1) Register a new di
            System.out.println("(2) Assign a dietitian to a pati
            System.out.println("(0) Return to main menu.");
            option = Integer.parseInt(scanner.nextLine());
            

            switch (option) {
                case 1:
                    reg
                    break;
                     2:
                    ass
                    break;
                    ult:
                    Syst
                    
            i
        
    

     

    private static void registerPat
        // Implementación del método
        System.out.println("Escribe 
                            int patientId = Integer.parseI
        System.out.println("Escribe el nombre completo del pa
        String fullName = scanner.nextLine();
        System.out.println("Escribe el año de
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Escribe el peso del pacient
        float weight = Float.parseFloat(scanner.nextLine());
        System.out.println("Escribe la altura del paciente."
        float height = Float.parseFloat(scanner.nextLine());
        System.out.println("Escribe las condiciones preexist
        String preexistingConditions = scanner.nextLine();
        

        String[] preexistingConditionsArray = preexistingConditions.split(","
        

        for (int k = 0; k < preexistingConditionsArray.length; k++) {
            preexistingConditionsArray[k] = preexistingConditionsArra
            
        

        

    

    private static void updatePat
        // Implementación del método
        System.out.println("Escribe 
        int patientId = Integer.parseInt(scanner.nextLine());
        System.out.println("Escribe el nuevo nombre completo 
        String fullName = scanner.nextLine();
        System.out.println("Escribe el año de
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Escribe el nuevo peso del p
        float weight = Float.parseFloat(scanner.nextLine());
        System.out.println("Escribe la nueva altura del paci
        float height = Float.parseFloat(scanner.nextLine());
        System.out.println("Escribe las nuevas condiciones p
        String preexistingConditions = scanner.nextLine();
        

        String[] preexistingConditionsArray = preexistingConditions.split(","
        

        for (int k = 0; k < preexistingConditionsArray.length; k++) {
            preexistingConditionsArray[k] = preexistingConditionsArra
            
        

        

    

    private static void deletePat
        // Implementación del método
        System.out.println("Escribe 
        int patientId = Integer.parseInt(scanner.nextLine());
        Patient.removePatient(patientId);
        
    

    private static void registerDieti
       // método
        System.ou
                             int dietitianId = Integer.parseInt
        System.out.println("Ingresa el nombre del nutricionista
        String FullName = scanner.nextLine();
        System.out.println("Ingresa las espec
        String preexistingConditions = scanner.nextLine();
        

        String[] preexistingConditionsArray = preexistingConditions.split(","
        

        for (int k = 0; k < preexistingConditionsArray.length; k++) {
            preexistingConditionsArray[k] = preexistingConditionsArra
            
        

        

    

    private static void assignDietitianToPatient
        // Implementación del método
        
    

