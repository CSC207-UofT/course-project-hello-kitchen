package controller.usercontrollers;


import manager.UserManager;
import module.Recipe;
import module.User;

import java.util.ArrayList;

public class FavouriteUserController {

    private FavouriteUserController() {}

    public static void constructFavouriteList (UserManager userManager, StringBuilder outPut) {
        User curr = userManager.getCurrentUser();
        ArrayList<Recipe> favouriteList = curr.favouriteList;
        if(favouriteList.isEmpty()) {
            outPut = new StringBuilder("No favourite recipes.");
        }
        else {
            for (Recipe recipe : favouriteList) {
                outPut.append("name: ").append(recipe.name).append(", id: ").append(recipe.id).append("\n")
                        .append("description: ").append(recipe.description).append("\n");
            }
        }
    }
}
