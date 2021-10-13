[comment]: <> (ToDo)
# Specification

- (Currently, share idea about specification and how to create class on a shared google doc, and then edit it on github.)
  - [Line here](https://docs.google.com/presentation/d/1mKh7QhHtk6U7BnTu51ubNPktbq6YOZUt/edit?usp=sharing&ouid=106731698362173902825&rtpof=true&sd=true)
  
- Running the project starts with the main menu of this recipe, a graphical interface.
- The user can loop up the information of existing dishes, add new dishes, write comments on dishes, upload videos about how to cook, get a recommendation, and find the browsing history of this recipe. These six functions are available on the main menu.
- For each dish, there should be the cuisine that this dish belongs to, the standard ingredients of this dish, the necessary tools for cooking this dish, and the cooking method of this dish. They are called the crucial points of the dish. If any of the crucial points is missing, the dish will be tagged "incomplete" and the user will be alerted to add information every time he opens the main menu. Two dishes are similar, if at least two of the crucial points are the same. Given an existing dish, the user can get a list of all existing similar dishes.
- For each dish, there can be the average time it takes to cook, the number of times it has been cooked, and comments on it. They are called the optional points of the dish.
- The user should record how long it takes to cook a certain existing dish every time the user cooks it. The recipe can calculate and record the average time for cooking the dish. The average time gets updated every time the user inputs a new time. 
- Existing dishes can be classified by similarity, the time it takes to cook, and the number of times it has been cooked. The user can get recommendations according to the result of the classification. The user can also manually label a dish as "favorite". Dishes labeled as "favorite" are always recommended first regardless of the classification way.