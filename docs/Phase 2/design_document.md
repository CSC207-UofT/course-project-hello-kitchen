# Design Document
## Major design decisions
- We have changed the input style of the commands.
- We are also deciding on deleting some classes we don't really need in the project to make it cleaner.
- We are cutting down some features and modifying some commands so that the workload will fit a three-person group.
## Clean Architecture
- We organize the classes and files according to features. For example, the user packages will only store the base 
user class, the manager package will only contain manager classes. The command package will only contain files which 
contributes to commands.
- However, we are still a little confused about use cases and controllers. We are still keeping abstract entity classes
and child classes in case we need to differ them for future usage. But, currently, we find out that the children 
classes for user and recipes are not required, and we are planning to delete them to make the architecture cleaner.
- We also introduced some interface to meet the requirements of our feature. For example the searchable interface
for future implementation of search feature. However, I am still thinking that whether I can change some classes
in command package into interfaces for clean architecture.
## SOLID
- Single Responsibility Principle: The majority of our classes follow the single responsibility principle since
they only have few methods that are clearly inseparable.
- Open/Closed Principle: All of our classes can be extended and be modified freely. For example, we can freely add new 
methods.
- Liskov Substitution Principle: There's no hierarchies in our program.
- Interface Segregation Principle: Public interfaces of our classes are all reasonable. 
No single irrelevant part that the program has to implement.
- Dependency Inversion Principle:
## Design patterns
We utilize two adapters and multiples factories for design pattern. 
There is an adapter in charge of write and read. Another one is the search adapter.
For each command that was input in, we have command factories to sort the class that this command belongs to, 
the method it will be calling, the action it will take. 

## WalkThrough
Four users have already signed up in the program with usernames "test", "Hello World", "Fish lover"`,
"wrong". Each user has different username, password and description.

User "test" sign in the program and use list command to see all the users store in the program. User "test" wants to delete 
user "wrong" because he signed up this user with wrong username. After deleting the user "wrong", he uses list to check if the user "wrong" exist.

User "test" want to see his username and description, so he uses current command and sign out.

Now user "Fish Lover" signs in and use command favourite to check the favourite recipe list. He then adds a new recipe called fish and chips to the program.
After adding the recipe, he uses list to see all the recipe stored in the program and he finds some problems about the recipe ingredients and procedure. So he 
tries to modify the recipe. User "Fish lover" keeps adding new recipe to the program, this time he adds magic soup and something wrong to the program. He deletes something wrong
from the recipe list. The user searches something is fish from the recipe lsit, and he marks two fish recipe as his favourite and sign out.

Next user "Hello World" signs in the program and he searched something is soup from the recipe list. He marks one soup as favourite and then check the whole recipe list
to find something he likes. He then marks one recipe as favourite and check all the recipe he marked as favourite. "Hello World" finds a recipe he doesn't like and unfavoured the recipe.
Then he signs out.


## Use of GitHub Features
During phase 2, we made good use of the branch function of GitHub. We opened a separate branch for each 
function in order to facilitate our team members to review and merge branches to the main branch. We also added our names 
before the branches. Through these behaviors, when the member in charge of reviewing merges the code, it is easy to find which 
member is responsible for the part. Opening different branches for different functions also allows us to clearly find the cause 
of the problem. 

We flexibly use the pull request function instead of directly merging to main. We open different branches and 
push the updated code from the local to different branches, and then use pull request to merge. The pull request allows us 
to clearly see the part of the code modification. We will delete the corresponding branch after the merge code to avoid 
branch redundancy.

## Testing
We have already tested the main functions of our program such as user and recipe command. The serialization uni test is 
hard to write due to the design of the IO adapter. However, the read and write function is worked well during using the program.