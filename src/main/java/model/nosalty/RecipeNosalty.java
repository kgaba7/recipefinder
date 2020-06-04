package model.nosalty;

import model.base.BaseRecipe;

import java.io.File;

/**
 * @author kissg on 2020. 05. 15.
 */
public class RecipeNosalty extends BaseRecipe {
    private String description;
    private double cookTime;
    private int recipeID;
    private double difficulty;
    private String URL;
    private int portions;
    private File picture;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCookTime() {
        return cookTime;
    }

    public void setCookTime(double cookTime) {
        this.cookTime = cookTime;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }
}
