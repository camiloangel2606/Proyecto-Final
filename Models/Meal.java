package Models;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String name;
    private String macronutrients;
    private int calories;
    private String timeOfDay;
private static List<Meal> mealList = new ArrayList<>();

public static void addMealToList(List<Meal> mealList, Meal meal) {
    mealList.add(meal);
}
    public Meal(String name, String macronutrients, int calories, String timeOfDay) {
        this.name = name;
        this.macronutrients = macronutrients;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }

    public static List<Meal> getMealList() {
        return mealList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacronutrients() {
        return macronutrients;
    }

    public void setMacronutrients(String macronutrients) {
        this.macronutrients = macronutrients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "Meal[Name:" + name + ", Macronutrients:" + macronutrients + ", Calories:" + calories + ", TimeOfDay:" + timeOfDay + "]";
    }
}