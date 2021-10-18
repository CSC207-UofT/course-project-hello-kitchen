package entity;

public class Bookmark {
    private String remark;
    private Recipe recipe;

    public Bookmark(String remark, Recipe recipe) {
        this.remark = remark;
        this.recipe = recipe;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
