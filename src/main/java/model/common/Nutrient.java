package model.common;

/**
 * @author kissg on 2020. 06. 04.
 */
public class Nutrient {
    //alapétrelmezetten minden adat 100 grammra értenő - ezt magunknak lehet jelezni valahol, ha akarjuk

    private Float kcal;
    private Float fat;
    private Float carbohydrate;
    private Float protein;



    public Float getKcal() {
        return kcal;
    }

    public void setKcal(Float kcal) {
        this.kcal = kcal;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Float getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }
}
