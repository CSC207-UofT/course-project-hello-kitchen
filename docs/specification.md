# Specification

## Intro to Hello Kitchen 
Hello Kitchen is a command line app developed using Java with no backend and no DB,
with stored data written to disk.

This app will run with a command line interface which will open a prompt
when being executed.
The user will be able to type commands in the prompt to use the features.

When using this application, users can **browse**, **save**, 
and **upload** recipes on the go.
The users can search for recipes in the app by keyword.
The users can also mark a recipe as favourite. 
The user can also see a list of all stored recipes.
The users will also be able to login and logout of the app.

## Statement of Scope

The app will be built using gradle to a JAR file and run in JRE 11. It will
have a CLI (Command Line Interface).

## Architectural and component-level design

### User

- The user can sign up an account with a unique `username`, they will
also provide their own `password` and `description` when signing up.
- The user can log in to the app using his/her unique `username` and
providing the right `password` they created.
- The user will have a customized `description` which can be modified
at any time after signing up.
- The user will also be able to change their `password` to their preference
after signing up.
- The `username` will be unique to every user thus it cannot be modified
after signing up.
- After logged in, the user will have access to their favourite list, where
they can check all the recipes they marked as favourite.
- The user will be able to log out after he/she is done.
- The app will also have the ability to show the list of all signed-up user
in case the user forget his/her `username`.

### Recipe
- Recipe is a class that stores different attributes.
- The users can create different recipes by providing information to the
attributes. The `name` of a recipe is not necessarily unique, however, when
a recipe is created, it will be assigned a unique `id` for future access
to it.
- The recipe will also be able to be modified for the field specified by the
user.
- The recipe can be marked as favourite by a user.
- The recipe cna also be searched using keyword.
- The app will also be able to print out a list showing information
about all the recipes it stores.

## Commands
Since the layout of input is defined differently, please consult the help
guide to use the input commands.

### User

add: Signup a new user. The user will provide `username`, `passsword` and `description`
        for the signup process.
        The `username` must be unique.
        If the `username` already exists in the users list, the app will
        throw an error indicating that the username is not available.

signin: Sign in to the user with `username` and `password`. The operator can then use the
             account to access the features for recipes.

signout: Sign out current user account. Favourite feature will not be able
            to be accessed.

favourite: Display the list of all favourite recipes of the current user.
    The list will show only the **name**, **description** and **id** of a recipe.

delete: Delete a user with `username` from the signed-up users list.

current: Display the information of the current logged-in user.
         The information will include the **name** and **description** of the current user.

list: Display the list of all the sign-up users. The list will show the
    **name** and **description** of the users.

help: Display the help message for all the commands related to user.

### Recipe

add: Start the process to create a new recipe. The prompt will
     ask for user input of the following parts in order.
     `name`, `description`, `ingredients`, `procedures` and
     `estimated cooking time`.
     Note that when taking in inputs for `procedures` and
     `ingredients`, after one step or ingredient is typed in,
     the prompt will ask the user whether the user want to 
     add another ingredient or step.
     The prompt will then take `y` for yes and `n` for no.
     After a new recipe is created, it will be assigned an
     **id** automatically.

modify: Modify a specific field of a recipe with `id`. There will also be
different actions for `procedures` and `ingredients`, including add, delete and modify.

delete: Delete the recipe with `id` from the data. The recipe will
             no longer be able to be viewed, searched or modified.

favourite: Mark the recipe with `id` as favourite.
                The user can view the list of the favourite recipes
                using the user favourite command.

unfavourite: Remove the recipe with `id` from favourite list.

show: Display the recipe with `id`. The recipe will be displayed in full version
containing all information.

search：Display a list of recipes which contain the
                        `key words` in their names or descriptions.
                        The list will be showing only **name**, **description** and **id**.

list: Display a list of all the recipes.
    The list will only show the **name**, **description** and **id** 
    of a recipe.

help: Display the help message for all the commands related to recipe.