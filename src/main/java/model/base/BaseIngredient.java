package model.base;

import constants.Constant;
import model.common.BaseNutrient;
import model.common.Category;

/**
 * @author kissg on 2020. 06. 04.
 */
public class BaseIngredient {
    private String name;
    private double quantity;
    private BaseNutrient baseNutrient;
    private Constant.ingredientType type;
    private Constant.ingredientQuantityType quantityType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BaseNutrient getBaseNutrient() {
        return baseNutrient;
    }

    public void setBaseNutrient(BaseNutrient baseNutrient) {
        this.baseNutrient = baseNutrient;
    }

    public Constant.ingredientQuantityType getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(Constant.ingredientQuantityType quantityType) {
        this.quantityType = quantityType;
    }



    public String toString(){
        StringBuilder result = new StringBuilder();



        return result.toString();
    }


    public Constant.ingredientType getType() {
        return type;
    }

    public void setType(Constant.ingredientType type) {
        this.type = type;
    }
}
