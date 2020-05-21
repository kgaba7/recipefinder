package main;

import controller.RecipeFinderController;

import java.io.IOException;

/**
 * @author kissg on 2020. 05. 21.
 */
public class TestMain {
    public static void main(String[] args) {
        RecipeFinderController controller = new RecipeFinderController();
        try {
            controller.scrapeNosalty("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
