# User (Entity)

Parent class: None

Child class: None

## Responsibilities
- Store the information of a user.
- Add favourite recipe to the user's favourite list.

### Attributes

- `String username`: Unique string indicating the username
- `String password`: The password for the user, used in login action
- `String description`: The customized description of a user
- `ArrayList<Recipe> favouriteList`: Arraylist which stores all recipes marked favourite by
the user

### Methods
- constructor: Construct User
- `addFavourite(Recipe recipe)`: Add a `recipe` to the user's `favouriteList`

## Collaborator

- UserManager
- Recipe
- Command