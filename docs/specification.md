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
         **id** and **type** of the current user.

ls: Display the list of all the sign-up users. The list will show the
    name, description, type, and id of a user.
    The types of the users are viewingUser and adminUser.

guest*

### Recipe

add: Start the process to create a new recipe. The prompt will
     ask for user input of the following parts in order.
     `name`, `description`, `ingredients`, `procedure` and
     `estimated cooking time`.
     Note that when taking in inputs for `procedure` and
     `ingredients`, after one step or ingredient is typed in,
     the prompt will ask the user whether the user want to 
     add another ingredient or step.
     The prompt will then take `Y` for yes and `N` for no.
     After a new recipe is created, it will be assigned an
     **id** automatically.

modify `id` -n: Modify the **name** of a recipe with `id`.
                The prompt will first display the old **name**
                of the recipe and then ask the user for an input
                to give the recipe a new **name**.

modify `id` -d: Modify the **description** of a recipe with `id`.
                The prompt will first display the old **description**
                of the recipe and then ask the user for an input
                to give the recipe a new **description**.

modify `id` -t: Modify the **estimated cooking time** of a recipe
                with `id`. The prompt will first display the old
                **estimated cooking time** of the recipe and then
                ask the user for an input to give the recipe a
                new **estimated cooking time**.

modify `id` -i: Modify the **ingredients** of a recipe with `id`.
                The prompt will first display the full representation
                of all the ingredients.
                Then the prompt will ask the user for an input
                indicating the `name` of the ingredient they want
                to modify.
                Then the user will be asked for input for `name`
                and `quantity` in order.

modify `id` -i -d: Delete one **ingredient** of the recipe.
                   The prompt will first display the full representation
                   of all the ingredients.
                   Then the prompt will ask the user for an input
                   indicating the `name` of the ingredient they want
                   to delete.
                   If the ingredient is deleted, it will print message
                   successful, unsuccessful otherwise.

modify `id` -i -a: Add one **ingredient** to the recipe.
                   The prompt will first display the full representation
                   of all the ingredients.
                   Then the prompt will ask the user for inputs
                   indicating the `name` and `value` in order 
                   of the ingredient they want to add.
                   If the ingredient is added, it will print message
                   successful, unsuccessful otherwise.

modify `id` -p: Modify the **procedures** of a recipe with `id`.
                The prompt will first display the full representation
                of all the procedures.
                Then the prompt will ask the user for an input
                indicating the `number` of the procedure they want
                to modify.
                Then the user will be asked for input for the new procedure.

modify `id` -p -d: Delete one **procedures** of the recipe.
                   The prompt will first display the full representation
                   of all the procedures.
                   Then the prompt will ask the user for an input
                   indicating the `number` of the procedure they want
                   to delete.
                   If the procedure is deleted, it will print message
                   successful, unsuccessful otherwise.

modify `id`-p -a: Add one **procedure** to the recipe.
                  The prompt will first display the full representation
                  of all the procedures.
                  Then the prompt will ask the user for inputs
                  indicating the `numbe of step` and `description` in order
                  of the procedure they want to add.
                  If the procedure is added, it will print message
                  successful, unsuccessful otherwise.

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