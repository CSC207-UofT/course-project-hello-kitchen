# SoupRecipe (Entity)

Parent class: Recipe

Child class: HotSoupRecipe, ColdSoupRecipe

## Responsibilities

- implement Searchable interface

### Attributes

- `String name`
- `String description`
- `Hashmap<Ingredient, double> ingredients`
- `ArryList<String> procedures`
- `double estimatedCookingTime`

## Collaborators

- RecipeManager