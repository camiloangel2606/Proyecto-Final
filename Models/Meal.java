package Models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Meal {
    private int id;
    private String name;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    private String ingredient5;
    private float protein;
    private float carbohydrates;
    private float fat;
    private String timeOfDay;
    private String macronutrients;
    private float calories;

    private static List<Meal> mealList = new ArrayList<>();

    public Meal(int id, String name, float calories, String macronutrients, float protein, float carbohydrates,
            float fat, String timeOfDay) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.macronutrients = macronutrients;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.timeOfDay = timeOfDay;
    }

    // Constructor con 7 parámetros
    public Meal(String name, String ingredient1, String ingredient2, String ingredient3, String ingredient4,
            String ingredient5, String timeOfDay) {
        this.name = name;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.timeOfDay = timeOfDay;
    }

    // Constructor con 6 parámetros
    public Meal(String name, String ingredient1, String ingredient2, String ingredient3, String ingredient4,
            String timeOfDay) {
        this.name = name;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.timeOfDay = timeOfDay;
    }

    // Constructor con 5 parámetros
    public Meal(String name, String ingredient1, String ingredient2, String ingredient3, String timeOfDay) {
        this.name = name;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.timeOfDay = timeOfDay;
    }

    // Constructor con 4 parámetros
    public Meal(String name, String ingredient1, String ingredient2, String timeOfDay) {
        this.name = name;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.timeOfDay = timeOfDay;
    }

    // Constructor con 3 parámetros
    public Meal(String name, String ingredient1, String ingredient2) {
        this.name = name;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
    }

    // Constructor con 2 parámetros
    public Meal(String name, String ingredient1) {
        this.name = name;
        this.ingredient1 = ingredient1;
    }

    // Constructor con 5 parámetros específicos
    public Meal(int id, String name, String macronutrients, float calories, String timeOfDay) {
        this.id = id;
        this.name = name;
        this.macronutrients = macronutrients;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }

    // Constructor con 4 parámetros específicos
    public Meal(String name, String ingredient1, float calories, String timeOfDay) {
        this.name = name;
        this.ingredient1 = ingredient1;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }

    // Método estático para guardar las comidas en un archivo CSV
    public static void saveMealsToCSV(List<Meal> meals) {
        String csvFileName = "meal_plan.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFileName))) {
            // Escribir la cabecera del CSV
            writer.println("Meal Name,Ingredient 1,Ingredient 2,Ingredient 3,Time of Day");

            // Escribir cada comida en una línea del CSV
            for (Meal meal : meals) {
                writer.print(meal.getName());
                writer.print(",");
                writer.print(meal.getIngredient1());
                writer.print(",");
                writer.print(meal.getIngredient2());
                writer.print(",");
                writer.print(meal.getIngredient3());
                writer.print(",");
                writer.println(meal.getTimeOfDay());
            }

            System.out.println("Información de comidas guardada en '" + csvFileName + "'");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

    public static void addMealToCSV(String fileName, int id, String name, float portion) {
        String[] mealData = { String.valueOf(id), name, String.valueOf(portion) };

        try (FileWriter writer = new FileWriter(fileName, true);
                PrintWriter pw = new PrintWriter(writer)) {
            for (String data : mealData) {
                pw.print(data);
                pw.print(",");
            }
            pw.println();
            System.out.println("Comida agregada exitosamente al archivo " + fileName);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public String getIngredient4() {
        return ingredient4;
    }

    public void setIngredient4(String ingredient4) {
        this.ingredient4 = ingredient4;
    }

    public String getIngredient5() {
        return ingredient5;
    }

    public void setIngredient5(String ingredient5) {
        this.ingredient5 = ingredient5;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public String getMacronutrients() {
        return macronutrients;
    }

    public void setMacronutrients(String macronutrients) {
        this.macronutrients = macronutrients;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    // Método estático para agregar una comida a la lista
    public static void addMealToList(List<Meal> meals, Meal meal) {
        mealList.add(meal);
    }

    // Método estático para obtener la lista de comidas
    public static List<Meal> getMealList() {
        return mealList;
    }

    @Override
    public String toString() {
        return "Meal [Id: " + id + ", Name: " + name + ", Ingredient1: " + ingredient1 + ", Ingredient2: " + ingredient2
                +
                ", Ingredient3: " + ingredient3 + ", Ingredient4: " + ingredient4 + ", TimeOfDay: " + timeOfDay + "]";
    }
}
