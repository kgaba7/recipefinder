package constants;

public class Constant {

    //todo identifier ftom ingredient name  (to other recipe sites)
    public enum ingredientType {
        MEAT, VEGETABLE, SPICE, GRAINPRODUCT, FRUIT, DAIRYPPRODUCT, PASTA, LIQUID, MUSHROOM
    }

    public enum ingredientQuantityType {
        GRAM, KILO, LITER, TABLESPOON, PINCH, TEASPOON, WHOLE, HALF, QUARTER, THIRD
    }

    public enum recipeCategory {
        PASTA, BACKERY, SOUP, SALAD, DESSERT, SAUCE, VEGAN, DRINK, JUNK

    }


    public static final String[] basePages = {"https://www.nosalty.hu/receptek/kategoria/*/osszes?page=0%2C0&limit=100&view=small&order=abc"};
    public static final String[] mainCategoriesURL = {"https://www.nosalty.hu/receptek/kategoria?order=abc&dir=0"};
    public static final String[] trueBase = {"https://www.nosalty.hu/"};
    public static final String[] ingredientBase = {"https://www.nosalty.hu/alapanyagok"};


}
