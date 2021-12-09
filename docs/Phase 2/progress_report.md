# Phase 2 Progress Report
## Changes from phase 1:
- Completed the functions need for the program.
- Save and read are realized using serialization.
- More tests are added to the program
- Constructed a complete CLI interface where the user can use command interact with the program.
- User and Recipe command are added and ready to use.
- Improve the structure of the program

## Group member tasks:
Phase 2 tasks
- Chengyuan Xue: design document, progress report, project accessibility report, attempted the IO adapter, add tests to the program.
- Wanting Hu: CRC cards, add gradle, finish the build of the program, implement the accepted version of serializable and make sure the read/write feature is working, add tests to the program.
- Jiantong Lyu: design, code review, most of the program code including user, recipe, managers and commands, implement most of the features, implement simple shell, work coordinating, specification and help guide for users.

## Major Contributions
- Chengyuan Xue:[IOadapter](https://github.com/CSC207-UofT/course-project-hello-kitchen/pull/48) By implemented the IO adapter, the program can save and read.
- Wanting Hu: [Serializable](https://github.com/CSC207-UofT/course-project-hello-kitchen/pull/51) DiskOperator and Serializable can collaborate to change objects from classes into strings and save in json files, as well as reading from existing json files and output as classes. 
[Gradle](https://github.com/CSC207-UofT/course-project-hello-kitchen/pull/46) By adding the build.gradle and settings.gradle, where the plugins and paths are defined, we can build the program more flexible.
- Jiantong Lyu: [Instance Registry](https://github.com/CSC207-UofT/course-project-hello-kitchen/pull/63) By adding Instance Registry, where all the instance of the classes

## What has worked well so far:
- Use adapter pattern to implement serialization so that repeated code are avoided and make the program best follow clean architecture.
- The functions of our program works well and all tests are passing and no obvious bugs.
- Different members handle higher levels of skill in different area.
- Factory design pattern using hashmap makes the command code easier to construct.
