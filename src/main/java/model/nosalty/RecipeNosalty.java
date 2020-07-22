package model.nosalty;

import model.base.BaseRecipe;
import model.common.BaseNutrient;
import model.common.Category;

import java.util.List;

/**
 * @author kissg on 2020. 05. 15.
 */
public class RecipeNosalty extends BaseRecipe {
    private List<IngredientNosalty> ingredientNosalty;
    private StringBuilder description;
    private double cookTimeInMinutes;
    private int recipeID;
    private double difficulty;
    private String URL;
    private int portions;
    private String picture;
    private BaseNutrient baseNutrient;
    private Category category;
    private int views;


    public double getCookTimeInMinutes() {
        return cookTimeInMinutes;
    }

    public void setCookTimeInMinutes(double cookTimeInMinutes) {
        this.cookTimeInMinutes = cookTimeInMinutes;
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


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BaseNutrient getBaseNutrient() {
        return baseNutrient;
    }

    public void setBaseNutrient(BaseNutrient baseNutrient) {
        this.baseNutrient = baseNutrient;
    }

    public StringBuilder getDescription() {
        return description;
    }

    public void setDescription(StringBuilder description) {
        this.description = description;
    }


    public List<IngredientNosalty> getIngredientNosalty() {
        return ingredientNosalty;
    }

    public void setIngredientNosalty(List<IngredientNosalty> ingredientNosalty) {
        this.ingredientNosalty = ingredientNosalty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
