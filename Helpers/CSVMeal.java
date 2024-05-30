package Helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Models.Meal;

public class CSVMeal {
    private static final String CSV_FILE_PATH = "Meals.csv";

    public static void loadInfo() {
        List<Meal> meals = new ArrayList<>();
        try {
            readFromFile(CSV_FILE_PATH, meals);
            for (Meal meal : meals) {
                Meal.addMealToList(meals, meal); // Agregar comida a la lista estática
            }
            System.out.println("Información de comidas cargada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar leer el archivo: " + e.getMessage());
        }
    }

    private static void readFromFile(String filePath, List<Meal> meals) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> fields = Arrays.asList(line.split(","));
                String mealName = fields.get(0);
                String macronutrients = fields.get(1);
                int calories = Integer.parseInt(fields.get(2));
                String timeOfDay = fields.get(3);
                Meal meal = new Meal(mealName, macronutrients, calories, timeOfDay);
                meals.add(meal);
            }
        }
    }

    public static void writeInfo(List<Meal> meals) {
        try {
            writeToFile(CSV_FILE_PATH, meals);
            System.out.println("Información de comidas guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar escribir en el archivo: " + e.getMessage());
        }
    }

    private static void writeToFile(String filePath, List<Meal> meals) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Meal meal : meals) {
                String line = meal.getName() + "," + meal.getMacronutrients() + "," + meal.getCalories() + "," + meal.getTimeOfDay();
                writer.write(line);
                writer.newLine();
            }
        }
    }
}