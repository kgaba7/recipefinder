package controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author kissg on 2020. 05. 15.
 */
public class RecipeFinderController extends BaseController {

    /**
     * Exits current program
     */
    public void exit() {
        throw new NotImplementedException();
    }

    /**
     * Decides which scaping method will be used, depending on the given URL
     *
     * @param url URL
     */
    public void downloadFactory(String url) {
        if (url.toLowerCase().contains("nosalty")) {
            scrapeNosalty(url);
            return;
        }
        if (url.toLowerCase().contains("streetkitchen")) {
            scrapeStreetkitchen(url);
            return;
        }
    }

    /**
     * Downloads a single recipe from the given "Nosalty" URL
     *
     * @param url URL
     */
    private void scrapeNosalty(String url) {
        throw new NotImplementedException();
    }

    /**
     * Downloads a single recipe from the given "Streetkitchen" URL
     *
     * @param url URL
     */
    private void scrapeStreetkitchen(String url) {
        throw new NotImplementedException();
    }
}
