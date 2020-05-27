package constants;

public class Constant {

    public enum ingredientType {
        MEAT, VEGETABLE, SPICE, FRUIT, DAIRYPPRODUCT, PASTA, LIQUID, MUSHROOM
    }

    public enum ingredientQuantityType {
        GRAM, KILO, LITER, TABLESPOON, PINCH, TEASPOON, WHOLE, HALF, QUARTER, THIRD
    }

    public enum recipeCategory {
        PASTA, BACKERY, SOUP, SALAD, DESSERT, SAUCE, VEGAN, DRINK, JUNK

    }

    public static String[] basePages = {"https://www.nosalty.hu/receptek/kategoria/*/osszes?page=0%2C0&%3Flimit=100&view=small&order=abc"};
    public static String[] mainCategories = {"https://www.nosalty.hu/receptek/kategoria?order=abc&dir=0"};


}
