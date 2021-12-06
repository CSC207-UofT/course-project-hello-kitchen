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
and children classes in case we need to differ them for future usage. But, currently, we find out that the children 
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
- Dependency Inversion Principle:s
## Design patterns
We utilize two adapters and multiples factories for design pattern. 
There is an adapter in charge of write and read. Another one is the search adapter.
For each command that was input in, we have command factories to sort the class that this command belongs to, 
the method it will be calling, the action it will take. 

## WalkThrough
After opening the program, we can sign up a user. In this case, we sign up four users with usernames "test", "Hello World", "Fish lover"`, 
"wrong". Each user need to have username, password and description. 
Then we can sign in with the username and the password. List command can be used to list all the stored users. 

Considering users have the need to delete the user, we have command called 
delete user. After deleting the user "wrong", let us use list command to check the users.

Current command help users check their usernames and description. Users can sign out the account and sign in another.

We sign in the user "Fish Lover" and use command favourite to check the favourite recipe list.

Recipe command make users can add and modify recipes.

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