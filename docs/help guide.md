# Help Guide
This help guide will contain specific use of all commands related to the app's
CLI. Please consult this guide or the in-app help message when using the features.

## Template
For parsing purpose, the commands inputted by the user will have a specific structure:

`root type:key=value&key=value ...`

Note that the `key=value&key=value ...` part is called the `body` of the
command, and it may not be present in all commands.
However, do notice that the `root` and `type` parts are always necessary 
for all the command to be executed.

The `root` and `type` of the command will be separated with a space.

Then immediately after `type` a colon ":" should be provided if the command
requires a `body` to be executed and the `body` of the command should follow
the colon ":" with no space in between.

In the `body` of the command, key-value pairs will be separated by "&" with
no space in between.

In each key-value pairs in the `body`, the `key` will be mapped to the `value`
using "=", note that all `key`s are single word without space inside, however,
the `value` can contain as many spaces as the user would like.
Sometimes, there will be `key`s which only accepts specific `values`, such
keys will be specified in the help guide.

The commands in the help guide will be categorized by the `root` of the
command and there will be example input for all different `type` of the
commands.

## Commands

### user (root)
All user commands will start with the `root` as `user`.

The required arguments must always be present in the command `body` and be
provided a `value` to it with themselves as the `key` to the `value`. If the
`value` is specified, only the specified `value` will be accepted.

- add: Add a new user, 
       required arguments `username`, `password`, `description`.
       
    Example input: `user add:username=test&password=test&description=test`


- delete: Delete a user with username, 
          required arguments `username`.

    Example input: `user delete:username=test`


- signin: Sign in user with username, 
          required arguments `username`, `password`.

    Example input: `user signin:username=test&password=test`


- signout: Sign out current user, 
           required arguments: none.

    Example input: `user signout`


- current: Show the username and description of the current active user,
           required arguments: none.

    Example input: `user current`


- list: Show the usernames and descriptions of all stored users, 
        required arguments: none.

    Example input: `user list`


- modify: Modify a specified field of the user with username,
          required arguments: `username`, `field`,
          `field` only accepts `value`s `password` or `description`.

    Example input: `user modify:username=test&field=password`


- favourite: Show the favourite list of the current active user, 
             required arguments: none.

    Example input: `user favourite`


- help: Display help guide for user commands, 
        required arguments: none.

    Example input: `user help`

### recipe (root)
All recipe commands will start with the `root` as `recipe`.

The required arguments must always be present in the command `body` and be
provided a `value` to it with themselves as the `key` to the `value`. If the
`value` is specified, only the specified `value` will be accepted.

- add: Add a new recipe with prompt questions, 
       required arguments: none.

    Example input: `recipe add`


- delete: Delete a recipe with id, 
          required arguments `id`.

    Example input: `recipe delete:id=0`


- show: Show all information of the recipe with id,
        required arguments `id`.

    Example input: `recipe show:id=1`


- list: Show the names, descriptions and ids of all stored recipes, 
        required arguments: none.

    Example input: `recipe list`


- modify: Modify a specified field of the recipe with id using prompt questions,
          required arguments: `id`, `field`,
          `field` only accepts `value`s `name`, `description`, 
          `ingredients`, `procedures`, `time`

    Example input: `recipe modify:id=2&field=ingredients`


- favourite: Put the recipe with id into current user's favourite list,
             required arguments: `id`.

    Example input: `recipe favourite:id=0`


- unfavourite: Remove a recipe with id from current user's favourite list, 
               required arguments: `id`

    Example input: `recipe unfavourite:id=0`


- search: search: Search for recipes with `keyword`, 
                  required arguments: `keyword`

    Example input: `recipe search:keyword=fish`


- help: Display help guide for recipe commands, 
        required arguments: none.

    Example input: `recipe help`


### exit (root)

- exit: Exit the app and auto-save data to disk.

    Example input: `exit`