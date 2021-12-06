package commands;

public class HelpRecipeCommand extends RecipeCommand{

    public HelpRecipeCommand() {}

    /**
     * Execute the command since there's no args to be taken in.
     * @param commandLine Keep the same structure.
     */
    @Override
    public void run(String commandLine) {
        this.execute();
    }

    public void execute() {
        String help = "Recipe commands help guide:\n" +
                "add: Add a new recipe with prompt questions, required arguments: none\n" +
                "delete: Delete a recipe with id, required arguments \"id\"\n" +
                "show: Show all information of the recipe with id," +
                "required arguments: \"id\"\n" +
                "list: Show the names, descriptions and ids of all stored recipes, required arguments: none\n" +
                "modify: Modify a specified field of the recipe with id using prompt questions, " +
                "required arguments: \"id\", \"field\" " +
                "(field only accepts values \"name\", \"description\", \"ingredients\", \"procedures\", \"time\")\n" +
                "favourite: Put the recipe with id into current user's favourite list, required arguments: \"id\"\n" +
                "unfavourite: Remove a recipe with id from current user's favourite list, required arguments: \"id\"\n" +
                "search: Search for recipes with keyword, required arguments: \"keyword\"\n" +
                "help: Display help guide for recipe commands, required arguments: none";
        System.out.println(help);
    }

}
