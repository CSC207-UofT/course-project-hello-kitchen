package recipe;

import interfacepack.Serializable;

import java.util.HashMap;

public class Recipe implements Serializable {
   public String name;
   public String description;
   public HashMap<String, String> ingredients;
   public HashMap<Integer, String> procedures;
   public int estimatedCookingTime;
   public int id;

   public Recipe() {}

    public Recipe(String name, String description, HashMap<String, String> ingredients,
                  HashMap<Integer, String> procedures, int estimatedCookingTime) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.procedures = procedures;
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

    @Override
    public HashMap<String, Object> serialize() {
       HashMap<String, Object> map = new HashMap<>();
       map.put("name", this.name);
       map.put("description", this.description);
       return map;
    }

    @Override
    public void deserialize(HashMap<String, Object> record) {
       String name = (String) record.get("name");
       String description = (String) record.get("description");
       this.name = name;
       this.description = description;
    }
}
