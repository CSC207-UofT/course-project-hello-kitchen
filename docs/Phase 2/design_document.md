# Design Document
## Major design decisions
- We have changed the input style of the commands to be more aligned.
- We delete some classes we don't really need in the project to make it cleaner.
- We cut off some features and modifying some commands so that the workload will fit a three-person group.
- We add controllers to collaborate with commands functions.
- We use serializable and disk operator to write and read objects in files.
- We reformat the files and their categories into better organization.
- We add password as a protected attribute in the user class to protect our users' privacy.
- We remove unnecessary complexity and give clear user help guide to help users familiarize faster.
## Clean Architecture
- We organize the classes and files according to features. For example, the user packages will only store the base 
user class, the manager package will only contain manager classes. The command package will only contain files which 
contributes to command.
- However, we are still a little confused about use cases and controllers. We are still keeping abstract entity classes
and child classes in case we need to differ them for future usage. But, currently, we find out that the children 
classes for user and recipes are not required, and we are planning to delete them to make the architecture cleaner.
- We also introduced some interface to meet the requirements of our feature. For example the searchable interface
for future implementation of search feature. However, I am still thinking that whether I can change some classes
in command package into interfaces for clean architecture.
- We separated our controller class and presenter class so the user input will only be taken by the controller class 
the displaying is not affected from it and is responsible by the presenter class.
## SOLID
- Single Responsibility Principle: The majority of our classes follow the single responsibility principle since
they only have few methods that are clearly inseparable.
- Open/Closed Principle: All of our classes can be extended and be modified freely. For example, we can freely add new 
methods.
- Liskov Substitution Principle: There's no hierarchies in our program.
- Interface Segregation Principle: Public interfaces of our classes are all reasonable. No single irrelevant part that 
the program has to implement.
- Dependency Inversion Principle: We decouples the high-level and low-level modules from each other so the high-level 
will not be affected by the low-level modules.
## Design patterns
We utilize adapter and factory design for design pattern. 
There is an IO adapter in charge of write and read values. There is also a commandFactory in charge of all the commands.
For each command that was input in, we have command factories to sort the class that this command belongs to, 
the method it will be calling, the action it will take. 

## WalkThrough
After executing the main, the user can look up the help guide to be familiar with the command style and the functionalities
our program provides. The user can register a new account with username, password, and description. After successfully 
created, the user can then signIn to explore more features of Hello Kitchen. The user can create new recipes with name, 
ingredients, procedure etc. The user can also add recipes to favorite list and view them later.
The user can make modification to both the user account and the recipes.
The user can also create one or more account at the same time and view the user lists. However, the user can only sign in 
one user at a time. To sign in to another account, please sign out first. 
There will be print instruction to help the user to follow next step and give hints when they are not using Hello Kitchen
properly.



## Use of GitHub Features
During phase 2, we made good use of the branch function of GitHub. We opened a separate branch for each 
function in order to facilitate our team members to review and merge branches to the main branch. We also added our names 
before the branches. Through these behaviors, when the member in charge of reviewing merges the code, it is easy to find which 
member is responsible for the part. Opening different branches for different functions also allows us to clearly find the cause 
of the problem. 

We flexibly use the pull request function instead of directly merging to main. We open different branches and 
push the updated code from the local to different branches, and then use pull request to merge. We also make clearer 
message and notes for other team members to get the idea of that pull request quickly. The pull request allows us 
to clearly see the part of the code modification. We will delete the corresponding branch after the merge code to avoid 
branch redundancy.

We tried the actions function but failed to implement it. We couldn't solve the error from Github.

## Testing
We have already tested the main functions of our program such as user and recipe command. The serialization unit test is 
hard to write due to the design of the IO adapter. However, the read and write function is worked well during using the
program.

## Code Organization
We used package-by-component to organize the code files. We put all the closely related file into the same package.

## Refactoring
We named all the functions and classes in a clear and easy to understand way.
We refactor some method out from the origin class to make more low-level helper functions to keep them separate from 
each other to follow the clean architecture.

