package utils;

/**
 * @author kissg on 2020. 05. 27.
 */
public class Messages {
    private static final String INFO_DOWNLOAD_FACTORY = "Download method successfully selected from URL \"";
    private static final String ERROR_DOWNLOAD_FACTORY = "Cannot select download method from given URL! URL: ";
    //todo
    private static final String INFO_SCRAPE_NOSALTY = "Download method successfully selected from URL \"";
    private static final String ERROR_SCRAPE_NOSALTY = "Cannot select download method from given URL! URL: ";
    private static final String INFO_GET_INGREDIENT = "Download method successfully selected from URL \"";
    private static final String ERROR_GET_INGREDIENT = "Cannot select download method from given URL! URL: ";
    private static final String INFO_SCRAPE_INGREDIENT = "Download method successfully selected from URL \"";
    private static final String ERROR_SCRAPE_INGREDIENT = "Cannot select download method from given URL! URL: ";

    /**
     * info and error
     * scrape nosalty
     * get ingredient
     *
     * @param url
     * @return
     */

    public static String getInfoDownloadFactory(String url) {
        return INFO_DOWNLOAD_FACTORY + url + "\"!";
    }

    public static String getErrorDownloadFactory(String url) {
        return ERROR_DOWNLOAD_FACTORY + url;
    }

    public static String getInfoScrapeNOSALTY(String url) {
        return INFO_SCRAPE_NOSALTY + url + "\"!";
    }

    public static String getErrorScrapeNOSALTY(String url) {
        return ERROR_SCRAPE_NOSALTY + url;
    }

    public static String getInfoGetIngredientNOSALTY(String url) {
        return INFO_GET_INGREDIENT + url + "\"!";
    }

    public static String getErrorGetIngredientNOSALTY(String url) {
        return ERROR_GET_INGREDIENT + url;
    }

    public static String getInfoScrapeIngredient(String url) {
        return INFO_SCRAPE_INGREDIENT + url + "\"!";
    }

    public static String getErrorScrapeIngredient(String url) {
        return ERROR_SCRAPE_INGREDIENT + url;
    }
}
