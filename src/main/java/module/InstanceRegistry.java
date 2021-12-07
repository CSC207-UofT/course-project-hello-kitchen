package module;

import manager.RecipeManager;
import manager.UserManager;

public class InstanceRegistry {

    private static UserManager userManager;
    private static RecipeManager recipeManager;
    private static Shell shell;

    public InstanceRegistry () {}

    public static UserManager getUserManager() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    public static void setUserManager(UserManager userManager) {
        InstanceRegistry.userManager = userManager;
    }

    public static RecipeManager getRecipeManager() {
        if (recipeManager == null) {
            recipeManager = new RecipeManager();
        }
        return recipeManager;
    }

    public static void setRecipeManager(RecipeManager recipeManager) {
        InstanceRegistry.recipeManager = recipeManager;
    }

    public static Shell getShell() {
        if (shell == null) {
            shell = new Shell();
        }
        return shell;
    }

    public static void setShell(Shell shell) {
        InstanceRegistry.shell = shell;
    }
}
