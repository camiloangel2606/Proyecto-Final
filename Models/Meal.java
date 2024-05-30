package Models;

import java.util.List;

public class Meal {
    private String name;
    private String macronutrients;
    private int calories;
    private String timeOfDay;

    public Meal(String name, String macronutrients, int calories, String timeOfDay) {
        this.name = name;
        this.macronutrients = macronutrients;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }

    // getters y setters

        public static void addMealToList(List<Meal> meals, Meal meal) {
        meals.add(meal);
    }

    public String getName() {
        return name;
    }

    public String getMacronutrients() {
        return macronutrients;
    }

    public int getCalories() {
        return calories;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    @Override
  
    public String toString() {
        return "Meal[Name:" + name + ", Macronutrients:" + macronutrients + ", Calories:" + calories + ", TimeOfDay:" + timeOfDay + "]";
    }
}