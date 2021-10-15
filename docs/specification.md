# Specification

## Intro
This is a desktop app developed using Java with no backend and no DB,
with stored data written to disk.

This app will run with a command line interface which will open a prompt
when being executed.
The user will be able to type commands in the prompt to use the features.

When using this application, users can **browse**, **save**, 
and **upload** recipes on the go.
The users can search for recipes in the app by recipe names and categories.
The users can also mark a recipe as favourite. 
The user can create their own recipes and upload it.

## Commands

### User

signup: Start the signup process for a new user. The app will ask for
        the input from the user for `name` and `description`.
        If the `name` already exists in the users list, then the app
        will ask for another input until there's no conflict.
        If the user choose to leave `description` blank, there will be
        a default `description` "Hello Kitchen!".
        All users after signing up will be assigned 
        an **id** automatically.
        This command will create a viewingUser by default.

signup -a: Start the signup process for a new user. The app will ask for
           the input from the user for `name` and `description`.
           If the `name` already exists in the users list, then the app
           will ask for another input until there's no conflict.
           If the user choose to leave `description` blank, there will be
           a default `description` "I am in charge!".
           All users after signing up will be assigned
           an **id** automatically.
           This command will create a adminUser by default.

signin `id`: Sign in to the user with `id`. The operator can then use the
             account to access the features for recipes.

signout: Sign out current user account. No more commands for recipes will
         be accepted.

favourite: Display the list of all favourite recipes of the current user. 
    There will be 5 recipes on one page by default and the users will 
    be able to navigate through pages using commands p and n.
    The list will be in simplified display by default, showing only 
    **name** and **id** of a recipe.

favourite -d: Display the list of all favourite recipes of the current user.
       There will be 5 recipes on one page by default and the users will
       be able to navigate through pages using commands p and n.
       The list will be in detailed display, showing
       **name**, **description**, and **id** of a recipe.

delete `id`: Delete a user with `id` from the signed-up users list. 
             Only executable by adminUser.

current: Display the information of the current logged-in user.
         The information will include the **name**, **description** and
         **id** of the current user.

ls: Display the list of all the sign-up users. The list will show the
    name, description, type, and id of a user.
    The types of the users are viewingUser and adminUser.

### Recipe

add:

modify `id`:

delete `id`: Delete the recipe with `id` from the data. The recipe will
             no longer be able to be viewed, searched or modified.

favourite `id`: Mark the recipe with `id` as favourite.
                The user can view the list of the favourite recipes
                using the user ls command.

view `id`: Display the recipe with `id` in a simplified display by default.
           The simplified display of the recipe will only contain 
           **name**, **ingredients**, and **procedures**.

view `id` -d: Display the recipe with `id` in a detailed display.
              The detailed display of the recipe will contain **name**,
              **description**, **ingredients**, **procedures**,
              and **estimated cooking time** in the display.

search -k `key words`： Display a list of recipes which contain the
                        `key words` in their names.
                        There will be 5 recipes on one page by default 
                        and the users will be able to navigate through 
                        pages using commands p and n.
                        The list will be in a simplified display showing
                        only **name** and **id**.

search -c `category`: Display a list of recipes which are under a certain
                      `category`.
                      There will be 5 recipes on one page by default
                      and the users will be able to navigate through
                      pages using commands p and n.
                      The list will be in a simplified display showing
                      only **name** and **id**.       

ls: Display a list of all the recipes in a simplified display by default.
    There will be 5 recipes on one page by default and the users will
    be able to navigate through pages using commands p and n.
    The simplified display will only show the **name** and **id** 
    of a recipe.

ls -d: Display a list of all the recipes in a detailed display.
       There will be 5 recipes on one page by default and the users will
       be able to navigate through pages using commands p and n.
       The detailed display will show the **name**, **description**, 
       and **id** of a recipe.

### Config*


The sections and commands marked with * will be designed later.