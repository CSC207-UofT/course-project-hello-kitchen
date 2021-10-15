# Recipe

Abstract

Parent class: None

Child class: SoupRecipe, DesertRecipe, *

## Responsibilities

Stores the recipe for a dish.

### Attributes

- `String name`
- `String description`
- `Hashmap<Ingredient, double> ingredients`
- `List<String> procedures`
- `double estimatedCookingTime`

### Methods

- `String getName()`
- `String getDescription()`
- `Hashmap<Ingredient, double> getIngredients()`
- `List<String> getProcedures()`
- `double getEstimatedCookingTime()`
- `void setName(String)`
- `void setDescription(String)`
- `void setIngredients(Hashmap<Ingredient, double>)`
- `void setProcedures(String)`
- `void setEstimatedCookingTime(double)`

## Collaborators

- Dish
- Ingredient
- RecipeManager
