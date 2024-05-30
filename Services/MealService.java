package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Meal;

public class MealService {
    private static List<Meal> mealList = new ArrayList<>();

    public static void addMealToList(Meal meal) {
        mealList.add(meal);
    }

    public static List<Meal> getMealList() {
        return mealList;
    }
}