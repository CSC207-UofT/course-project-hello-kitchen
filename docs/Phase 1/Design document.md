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
- Dependency Inversion Principle:s
## Design patterns
We utilize two adapters and multiples factories for design pattern. 
There is an adapter in charge of write and read. Another one is the search adapter.
For each command that was input in, we have command factories to sort the class that this command belongs to, 
the method it will be calling, the action it will take. 