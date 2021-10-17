package recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Recipe {
    protected String name;
    protected String description;
    /* String is the ingredient, and Double is the mass required for one person portion */
    protected HashMap<String, Double> ingredients;
    protected ArrayList<String> procedures;
    protected double estimatedCookingTime;

    public Recipe() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<String, Double> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getProcedures() {
        return this.procedures;
    }

    public void setProcedures(ArrayList<String> procedures) {
        this.procedures = procedures;
    }

    public double getEstimatedCookingTime() {
        return this.estimatedCookingTime;
    }

    public void setEstimatedCookingTime(double estimatedCookingTime) {
        this.estimatedCookingTime = estimatedCookingTime;
    }

    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", procedures=" + procedures +
                ", estimatedCookingTime=" + estimatedCookingTime +
                '}';
    }

}
