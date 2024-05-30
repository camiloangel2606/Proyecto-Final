package Services;

import java.util.ArrayList;
import java.util.List;

import Models.DietPlan;
import Models.Meal;

public class DietPlanService {
    // Lista de planes de dieta
    private List<DietPlan> dietPlanList = new ArrayList<>();

    // Agrega un plan de dieta a la lista
    public void addDietPlan(DietPlan dietPlan) {
        dietPlanList.add(dietPlan);
    }

    // Imprime la lista de planes de dieta
    public void printDietPlanList() {
        for (DietPlan dietPlan : dietPlanList) {
            System.out.println(dietPlan.toString());
        }
    }

    // Calcula el total de calorías de un plan de dieta
    public void calculateTotalCalories(DietPlan dietPlan) {
        int totalCalories = 0;
        for (Meal meal : dietPlan.getMeals()) {
            totalCalories += meal.getCalories();
        }
        System.out.println("Total calories for diet plan " + dietPlan.getPlanId() + ": " + totalCalories);
    }

    // Imprime los detalles de un plan de dieta
    public void printDietPlanDetails(DietPlan dietPlan) {
        System.out.println("Diet Plan for " + dietPlan.getPatient().getFullName());
        System.out.println("Created by " + dietPlan.getDietitian().getFullName());
        System.out.println("Daily Calories: " + dietPlan.getDailyCalories());
        System.out.println("Macronutrient Distribution: " + dietPlan.getMacronutrientDistribution());
        System.out.println("Specific Recommendations: " + dietPlan.getSpecificRecommendations());
        System.out.println("Meals:");
        for (Meal meal : dietPlan.getMeals()) {
            System.out.println("  " + meal.getName() + " - " + meal.getCalories() + " calories");
        }
    }
}