package main;

import controller.RecipeFinderController;
import logger.RecipeFinderLogger;

/**
 * @author kissg on 2020. 05. 21.
 */
public class TestMain {
    public static void main(String[] args) {
        RecipeFinderLogger logger = new RecipeFinderLogger();
        RecipeFinderController controller = new RecipeFinderController(logger);
       // controller.scrapeNosaltyKG("");
    }
}
