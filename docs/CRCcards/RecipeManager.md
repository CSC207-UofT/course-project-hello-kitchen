# RecipeManager (Use Case)

Not abstract

Parent class: None

Child class: None

## Responsibilities

Create, modify

### Attributes

- `List<Recipe> recipes`

### Methods

- `boolean add(String name, String description, Hashmap<Ingredient, double> ingredients, List<String> procedures, double estimatedCookingTime)`
- `Recipe delete(String id)`
- 
- `boolean modifyRecipeName(Recipe, String)`
- 
- `boolean modifyRecipeDescription(Recipe, String)`
- `boolean modifyRecipeIngredients(Recipe, Hashmap<Ingredient, double>)`
- `boolean modifyRecipeProcedures(Recipe, List<String>)`
- `boolean modifyRecipeEstimatedCookingTime(Recipe, double)`
- `List<Recipe> searchRecipe(String)`

## Collaborators

- Recipe
- UserManager
