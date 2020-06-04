package model.base;

import java.util.List;

/**
 * @author kissg on 2020. 06. 04.
 */
public class BaseRecipe {
    private String name;
    private List<BaseIngredient> ingredients;
    private boolean isFavorite;
    private boolean isUserMade;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BaseIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<BaseIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isUserMade() {
        return isUserMade;
    }

    public void setUserMade(boolean userMade) {
        isUserMade = userMade;
    }
}
