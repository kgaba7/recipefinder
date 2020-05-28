package utils;

/**
 * @author kissg on 2020. 05. 27.
 */
public class Messages {
    private static final String INFO_DOWNLOAD_FACTORY = "Download method successfully selected from URL \"";
    private static final String ERROR_DOWNLOAD_FACTORY = "Cannot select download method from given URL! URL: ";

    public static String getInfoDownloadFactory(String url) {
        return INFO_DOWNLOAD_FACTORY + url + "\"!";
    }

    public static String getErrorDownloadFactory(String url) {
        return ERROR_DOWNLOAD_FACTORY + url;
    }
}
