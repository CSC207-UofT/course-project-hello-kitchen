# Phase 0 Progress Report
## Specification:
Our project is a recipe manager app. We have a general introduction to our program in the specification. The basic features
and statement of scope for our program is introduced. Despite the introduction, we have two major parts in our specification.
- In the Architectural design part, we introduce the two Main entities of our project which are User and Recipe. The attributes 
of these two entities are listed as well as how they interact with different commands and other entities.
- The second part is Commands used in our project. We divide this part into User and Recipe. All the commands User and Recipe 
will use are listed as well as their detailed description.

## CRC model:
The CRC model for our program follows the clean architecture structure rules.
- Entity: We have 8 entity classes: User, Recipe, AppetizerRecipe, DessertRecipe, MainCourseRecipe, SoupRecipe, CommonUser, 
AdminUser. User and Recipe store data of all users and different recipes. User is the parent class of AdminUser and CommonUser. 
Recipe is the parent class of AppetizerRecipe, DessertRecipe, MainCourseRecipe, SoupRecipe.
- Use case: Use case classes manage use cases for entities. For example, RecipeManager will add new recipe and then modify and store it.
- Controllers: CommandLine, which receives user inputs and then execute.
- Driver: HelloKitchen is our Main driver where the program is run.

## Scenario walk-through:
Our scenario walk-through describes a typical scenario how a user will use our app. 
A new user first sign up and sign in our program. Then the user add a new recipe and modify it. This user view and mark 
the recipe as favorite afterwards. A new user account and a new recipe are created, they get added into User and Recipe. 
Everything are saved before the program terminated.


## Skeleton program:
Our skeleton program is entirely based on our CRC models.
- We classified the classes according to the Clean Architecture.
- Commands listed in the specification are implemented to deal with the scenario walk-through. More commands are waiting 
to create in order to deal with more complicate scenario.
- Some sample data are created.
- The unit test are written for the use case.

## Group member tasks (working on and plan to work on):
Everyone takes participation in CRC model and share idea.\
Kurt Xue: CRC model, scenario walk-through, progress report.\
Jiantong Lyu: Specification, CRC model, user part code, code review and merge pr, coordinate group tasks.\
Tianle Wang: All basic stuffs (README.md, old Specification, old CRC cards), unit test code, and review all code & adds some description.\
Xi Chen: recipe part code, specification(plan).\
Xiaodong Wei: CRC model, Manager, Bookmark Code.\
Yucen Liu: CRC Model, Recipe, User Code.\
Botao Su: CRC model, specification, user code.  \
Wanting Hu: CRC model, specification(plan).

## Open questions struggling with:
- We encountered big problems in group cooperation. Because of the large number of members, we can't negotiate a common 
free time for the project. As a result, only some people attended each meeting, the progress of the members was different. 
There are even some members do the tasks that are overlapped.
- In addition, we found that it is difficult to communicate and work efficiently through online meetings. We cannot know 
what other members are doing in real time. We believe that the project can be better completed through in person collaboration

## What has worked well so far:
- All our use cases run successfully.
- The well written specification help us a lot during coding and building crc models.
