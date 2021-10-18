package recipe;

import interfacepack.Searchable;

import java.util.HashMap;
import java.util.List;

public class AppetizerRecipe extends Recipe implements Searchable {

    public AppetizerRecipe(){}

    public AppetizerRecipe(String name, String description, HashMap<String, Double> ingredients, List<String> procedures,
                           double estimatedCookingTime){
        super(name, description, ingredients, procedures, estimatedCookingTime);
    }

    @Override
    public String getKeyword() {
        return getName();
    }

    @Override
    public String getCategory() {
        return "Appetizer";
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name +
                "', Category=" + "'Appetizer'" +
                ", description= '" + description + "'" +
                ", ingredients=" + ingredients.toString() +
                ", procedures=" + procedures.toString() +
                ", estimatedCookingTime=" + estimatedCookingTime +
                '}';
    }
}
