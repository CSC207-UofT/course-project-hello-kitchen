package recipe;

import interfacepack.Searchable;

import java.util.HashMap;
import java.util.List;

public class SoupRecipe extends Recipe implements Searchable {

    public SoupRecipe(){}

    public SoupRecipe(String name, String description, HashMap<String, Double> ingredients, List<String> procedures,
                      double estimatedCookingTime){
        super(name, description, ingredients, procedures, estimatedCookingTime);
    }

    @Override
    public String getKeyword() {
        return getName();
    }

    @Override
    public String getCategory() {
        return "Soup";
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name +
                "', Category=" + "'Soup'" +
                ", description= '" + description + "'" +
                ", ingredients=" + ingredients.toString() +
                ", procedures=" + procedures.toString() +
                ", estimatedCookingTime=" + estimatedCookingTime +
                '}';
    }
}
