package model;

import Enums.Constants;

/**
 * @author kissg on 2020. 05. 15.
 */
public class Ingredient {

    private String name;
    private double quantity;
    private boolean isAvalible;

    private Constants.ingredientType type;
    private Constants.ingredientQuantityType quantityType;


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

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }

    public Constants.ingredientType getType() {
        return type;
    }

    public void setType(Constants.ingredientType type) {
        this.type = type;
    }

    public Constants.ingredientQuantityType getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(Constants.ingredientQuantityType quantityType) {
        this.quantityType = quantityType;
    }
}
