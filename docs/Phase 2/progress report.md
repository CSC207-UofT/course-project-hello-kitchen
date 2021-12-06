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
- Xue Chengyuan: design document, progress report, project accessibility report, attempted the IO adapter which make program can save and read, add tests to the program.
- Hu Wanting: add gradle, finish the build of the program, implement the accepted version of serializable and make sure the read/write feature is working.
- Jiantong Lyu: design, code review, most of the program code including user, recipe, managers and commands, implement most of the features, implement simple shell, work coordinating, specification and help guide for users.
## What has worked well so far:
- Use adapter pattern to implement serialization so that repeated code are avoided and make the program best follow clean architecture.
- The functions of our program works well and all tests are passing and no obvious bugs.
- Different members handle higher levels of skill in different area.
- Factory design pattern using hashmap makes the command code easier to construct.