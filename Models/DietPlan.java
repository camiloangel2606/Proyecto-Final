package Models;

import java.util.List;

public class DietPlan {
    // Atributos del plan de dieta
    private int planId;
    private float dailyCalories;
    private String macronutrientDistribution;
    private String specificRecommendations;
    private Patient patient;
    private Dietitian dietitian;
    private List<Meal> meals;

    // Constructor vacío
    public DietPlan() {
    }

    // Constructor con parámetros
    public DietPlan(int planId, float dailyCalories, String macronutrientDistribution, String specificRecommendations,
            Patient patient, Dietitian dietitian, List<Meal> meals) {
        this.planId = planId;
        this.dailyCalories = dailyCalories;
        this.macronutrientDistribution = macronutrientDistribution;
        this.specificRecommendations = specificRecommendations;
        this.patient = patient;
        this.dietitian = dietitian;
        this.meals = meals;
    }
    // getters y setters

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public float getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public String getMacronutrientDistribution() {
        return macronutrientDistribution;
    }

    public void setMacronutrientDistribution(String macronutrientDistribution) {
        this.macronutrientDistribution = macronutrientDistribution;
    }

    public String getSpecificRecommendations() {
        return specificRecommendations;
    }

    public void setSpecificRecommendations(String specificRecommendations) {
        this.specificRecommendations = specificRecommendations;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dietitian getDietitian() {
        return dietitian;
    }

    public void setDietitian(Dietitian dietitian) {
        this.dietitian = dietitian;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "DietPlan[PlanId:" + planId + ", DailyCalories:" + dailyCalories + ", MacronutrientDistribution:"
                + macronutrientDistribution + ", SpecificRecommendations:" + specificRecommendations + ", Patient:"
                + patient + ", Dietitian:" + dietitian + ", Meals:" + meals + "]";
    }
}