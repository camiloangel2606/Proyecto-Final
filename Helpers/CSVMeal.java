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
    private static final String CSV_FILE_PATH = "Data/Meals.csv";

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

    public static void saveInfo(List<Meal> meals) {
        try {
            writeToFile(CSV_FILE_PATH, meals);
            System.out.println("Información de comidas guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al intentar guardar el archivo: " + e.getMessage());
        }
    }

    private static void readFromFile(String filePath, List<Meal> meals) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> fields = Arrays.asList(line.split(","));
                String macronutrients = fields.get(1);
                String timeOfDay = fields.get(3);
                int id = Integer.parseInt(fields.get(0));
                String name = fields.get(1);
                float calories = Float.parseFloat(fields.get(2));
                float protein = Float.parseFloat(fields.get(3));
                float carbohydrates = Float.parseFloat(fields.get(4));
                float fat = Float.parseFloat(fields.get(5));
                Meal meal = new Meal(id, name, calories, macronutrients, protein, carbohydrates, fat, timeOfDay);
                meals.add(meal);
            }
        }
    }

    public static void writeInfo(List<Meal> meals) {// este método no es tan necesario
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
                String line = meal.getId() + "," + meal.getName() + "," + meal.getCalories() + ","
                        + meal.getMacronutrients() + "," + meal.getProtein() + "," + meal.getCarbohydrates() + ","
                        + meal.getFat() + "," + meal.getTimeOfDay();
                writer.write(line);
                writer.newLine();
            }
        }
    }
}