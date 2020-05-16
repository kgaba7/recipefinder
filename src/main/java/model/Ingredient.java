package model;

import Enums.Enum;

/**
 * @author kissg on 2020. 05. 15.
 */
public class Ingredient {

    private String name;
    private double quantity;
    private boolean isAvalible;

    private Enum.ingredientType type;
    private Enum.ingredientQuantityType quantityType;


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

    public Enum.ingredientType getType() {
        return type;
    }

    public void setType(Enum.ingredientType type) {
        this.type = type;
    }

    public Enum.ingredientQuantityType getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(Enum.ingredientQuantityType quantityType) {
        this.quantityType = quantityType;
    }
}
