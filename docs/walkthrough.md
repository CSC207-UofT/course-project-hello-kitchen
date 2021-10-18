## The User tries to sign up and sign in:
The user will log in through the command line interface, passing their username as an argument.

This request will be sent to the CommandLine, that will log the user in.\
CommandLine initialized a new LoginManager class to sign up a new user.\
CommandLine will initialize a new UserManager class to manage the data it received, and stores it.\
The CommandLine will output that it successfully logged in.

## The User tries to add a new recipe and modify it:
The user will add the recipe through commandline interface.

The request will pass to CommandLine.\
CommandLine initialized a new RecipeManager class to add the recipe.


## The User tries to view the recipe and mark it as favorite:
The student will request to view the recipe.

The request will be passed to CommandLine, and CommandLine will look into the memory, search for the recipe,
which gives back data.
