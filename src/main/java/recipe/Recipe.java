package recipe;

import java.util.HashMap;
import java.util.List;

public class Recipe {
    protected String name;
    protected String description;
    /* String is the ingredient, and Double is the mass required for one person portion */
    protected HashMap<String, Double> ingredients;
    protected List<String> procedures;
    protected double estimatedCookingTime;

    public Recipe(String name, String description, HashMap<String, Double> ingredients, List<String> procedures,
                  double estimatedCookingTime) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.procedures = procedures;
        this.estimatedCookingTime = estimatedCookingTime;
    }

    public Recipe(){}

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

    public void setProcedures(List<String> procedures) {
        this.procedures = procedures;
    }

    public double getEstimatedCookingTime() {
        return this.estimatedCookingTime;
    }

    public void setEstimatedCookingTime(double estimatedCookingTime) {
        this.estimatedCookingTime = estimatedCookingTime;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name +
                "', description= '" + description + "'" +
                ", ingredients=" + ingredients.toString() +
                ", procedures=" + procedures.toString() +
                ", estimatedCookingTime=" + estimatedCookingTime +
                '}';
    }

}
