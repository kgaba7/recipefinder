package model.nosalty;

import model.base.BaseIngredient;

/**
 * @author kissg on 2020. 05. 15.
 */
public class IngredientNosalty extends BaseIngredient {
    private String desc;
    private boolean isAvalible;

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
