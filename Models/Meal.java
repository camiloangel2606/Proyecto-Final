package Models;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private int id;
    private String name;
    private String macronutrients;
    private float calories;
    private float protein;
    private float carbohydrates;
    private float fat;
    private String timeOfDay;
private static List<Meal> mealList = new ArrayList<>();


public static void addMealToList(List<Meal> mealList, Meal meal) {
    mealList.add(meal);
}
//CONSTRUCTOR MODIFICADO
public Meal(int id, String name, float calories, String macronutrients, float protein, float carbohydrates, float fat, String timeOfDay) {
    this.id = id;
    this.name = name;
    this.calories = calories;
    this.macronutrients = macronutrients;
    this.protein = protein;
    this.carbohydrates = carbohydrates;
    this.fat = fat;
    this.timeOfDay = timeOfDay;
}

    public static List<Meal> getMealList() {
        return mealList;
    }

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

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "Meal[Id: " + id + ", Name: " + name + ", Macronutrients: " + macronutrients + ", Calories: " + calories + ", Protein: " + protein + ", Carbohydrates: " + carbohydrates + ", Fat: " + fat + ", TimeOfDay: " + timeOfDay + "]";}
}