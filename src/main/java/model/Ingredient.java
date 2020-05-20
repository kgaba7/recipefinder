package model;

import Constants.Constant;

/**
 * @author kissg on 2020. 05. 15.
 */
public class Ingredient {

    private String name;
    private double quantity;
    private boolean isAvalible;

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

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
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
