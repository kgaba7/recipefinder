package model.base;

import constants.Constant;
import model.common.Nutrient;

/**
 * @author kissg on 2020. 06. 04.
 */
public class BaseIngredient {
    private String name;
    private double quantity;
    private Nutrient nutrient;
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

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    public Constant.ingredientType getType() {
        return type;
    }

    public void setType(Constant.ingredientType type) {
        this.type = type;
    }

    public Constant.ingredientQuantityType getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(Constant.ingredientQuantityType quantityType) {
        this.quantityType = quantityType;
    }
}
