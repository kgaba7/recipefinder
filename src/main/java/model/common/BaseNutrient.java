package model.common;

/**
 * @author kissg on 2020. 06. 04.
 */
public class BaseNutrient {
    //alapétrelmezetten minden adat 100 grammra értenő - ezt magunknak lehet jelezni valahol, ha akarjuk
// mivel nem minden recept oldal van egyben (nincs ingredient infó csak nosalty-n).
// De elérhetők külön kalória táblázatok pl: https://www.xn--kalriaguru-ibb.hu/kaloriatablazat/kaloriatablazat.php
    // az innen létre hozott Ingredient objectek (plusz a nosaltyn létrehozott objectek) hozzá rendelhetőek más recept oldalak hozzávalóihoz
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
