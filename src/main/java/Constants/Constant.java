package Constants;

public class Constant {

    public enum ingredientType {
        MEAT, VEGETABLE, SPICE, FRUIT, DAIRYPPRODUCT, PASTA, LIQUID, MUSHROOM
    }

    public enum ingredientQuantityType {
        GRAM, KILO, LITER, TABLESPOON, PINCH, TEASPOON, WHOLE, HALF, QUARTER, THIRD
    }


    public static String nosaltyBaseURL = "https://www.nosalty.hu/receptek/kategoria/  [ x ]  /osszes?limit=100&view=small&order=abc";
    public static String[] nosaltyMainCategories = {"aprosutemeny", "befottek", "bonbonok"}; // TODO if this is the chosen method


}
