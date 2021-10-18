package recipe;

import interfacepack.Searchable;

import java.util.HashMap;
import java.util.List;

public class DessertRecipe extends Recipe implements Searchable {

    public DessertRecipe(){}

    public DessertRecipe(String name, String description, HashMap<String, Double> ingredients, List<String> procedures,
                         double estimatedCookingTime){
        super(name, description, ingredients, procedures, estimatedCookingTime);
    }

    @Override
    public String getKeyword() {
        return getName();
    }

    @Override
    public String getCategory() {
        return "Dessert";
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name +
                "', Category=" + "'Dessert'" +
                ", description= '" + description + "'" +
                ", ingredients=" + ingredients.toString() +
                ", procedures=" + procedures.toString() +
                ", estimatedCookingTime=" + estimatedCookingTime +
                '}';
    }
}
