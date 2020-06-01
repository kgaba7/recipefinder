package temp;

import constants.Constant;
import controller.RecipeFinderController;
import logger.RecipeFinderLogger;
import model.Ingredient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Index;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        test myTest = new test();
        RecipeFinderLogger logger = new RecipeFinderLogger();
        RecipeFinderController controller = new RecipeFinderController(logger);


//        controller.scrapeNosalty("https://www.nosalty.hu/recept/cecei-lecsos-csirke-kapros-turos-galuskaval");
//        controller.getFirstPageNOSALTY(Constant.mainCategoriesURL[Index.NOSALTY_BASE]);
//        controller.getRecipeUrlNOSALTY("https://www.nosalty.hu/receptek/kategoria/teszta/osszes?page=0%2C0&limit=100&view=small&order=abc");
//        controller.loopPagesNOSALTY("https://www.nosalty.hu/receptek/kategoria/teszta/osszes?page=0%2C0&limit=100&view=small&order=abc");


    }
}
