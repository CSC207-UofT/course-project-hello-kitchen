##The User tries to sign up and sign in:
The user will login through the command line interface, passing their id as an argument.

This request will be sent to the CommandLine, that will log the user in.

Command line initialized a new LoginManager class to sign up a new user
Commandline communicates with UserDatabase, which will give up data if it has an entry for a user with the inputted id.
CommandLine will initialize a new UserManager class to manage the data it received, and stores it inside itself.
The CommandLine will output that it successfully logged in.

##The User tries to add a new recipe and modify it:
The user will add and modify the recipe through commandline interface.
The request will pass to CommandLine.
Command line initialized a new RecipeManager class to add the recipe.
Commandline communicates with RecipeDatabase, which will give up data if it has an entry for a user with the inputted recipe.

##The User tries to view the recipe and mark it as favorite:
The student will request to view the recipe and mark it as favorite.
The request will passed to CommandLine, and CommandLine will look into the RecipeDatabase, which gives back data.
CommandLine will
