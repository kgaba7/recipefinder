package temp;

import constants.Constant;
import controller.RecipeFinderController;
import logger.RecipeFinderLogger;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        RecipeFinderLogger logger = new RecipeFinderLogger();
        RecipeFinderController controller = new RecipeFinderController(logger);

        //  controller.loopPagesNOSALTY("https://www.nosalty.hu/receptek/kategoria/aprosutemeny/osszes?page=0%2C0&limit=100&view=small&order=abc");
       // controller.getFirstPageNOSALTY("https://www.nosalty.hu/receptek/kategoria?order=abc&dir=0");
        //controller.getRecipeUrlNOSALTY("https://www.nosalty.hu/receptek/kategoria/torta/osszes?page=0%2C3&limit=100&view=small&order=abc");


        //controller.scrapeNosalty("https://www.nosalty.hu/recept/shortbread-keksz-ujragondolva-reform-valtozat");
          controller.scrapeNosalty("https://www.nosalty.hu/recept/mexikoi-grilltal");

        // controller.elapsedTimeTest();
        //    controller.getAllIngredientUrl("https://www.nosalty.hu/alapanyagok");
        //   controller.createAllIngredientsNosalty();

//        controller.getFirstPageNOSALTY(Constant.mainCategoriesURL[Index.NOSALTY_BASE]);
//        controller.getRecipeUrlNOSALTY("https://www.nosalty.hu/receptek/kategoria/teszta/osszes?page=0%2C0&limit=100&view=small&order=abc");
        // controller.loopPagesNOSALTY("https://www.nosalty.hu/recept/pudingos-turotorta-nylah-konyhajabol");
        //  controller.scrapeNosalty("https://www.nosalty.hu/recept/pudingos-turotorta-nylah-konyhajabol");
        //  controller.scrapeIngredient("https://www.nosalty.hu/alapanyag/alma");
        //   controller.scrapeNosaltyKG("https://www.nosalty.hu/recept/pudingos-turotorta-nylah-konyhajabol");
        //controller.scrapeCookpad("https://cookpad.com/hu/receptek/12102307-gyrosos-pulykaszarny")
        // controller.getAllIngredientUrl(Constant.ingredientBase[Index.NOSALTY_BASE]);
    }
}
