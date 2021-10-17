package recipe;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Recipe {
    String name;
    String description;
    /* String is the ingredient, and Double is the mass required for one person portion */
    HashMap<String, Double> ingredients;
    ArrayList<String> procedures;
    double estimatedCookingTime;

    public Recipe() {
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public HashMap<String, Double> getIngredients() {
        return ingredients;
    }

    public List<String> getProcedures() {
        return this.procedures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setIngredients(HashMap<String, Double> map) {
        this.ingredients = map;
    }

    public void setProcedures(ArrayList<String> procedures){
        this.procedures = procedures;
    }

    public void setEstimatedCookingTime(double estimatedCookingTime){
        this.estimatedCookingTime = estimatedCookingTime;
    }
}
