package controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import view.RecipeFinderMainWindow;

import javax.swing.text.Document;
import java.io.IOException;

/**
 * @author kissg on 2020. 05. 15.
 */
public class RecipeFinderController extends BaseController {
    private RecipeFinderMainWindow recipeFinderMainWindow;
    private org.jsoup.nodes.Document page;

    /**
     * Exits current program
     */
    public void exit() {
        System.exit(0);
        // throw new NotImplementedException();
    }

    /**
     * Decides which scaping method will be used, depending on the given URL
     *
     * @param url URL
     */
    public int downloadFactory(String url) throws IOException {
        if (url.toLowerCase().contains("nosalty")) {
            scrapeNosalty(url);
            return 1;
        }
        if (url.toLowerCase().contains("streetkitchen")) {
            scrapeStreetkitchen(url);
            return 2;
        }
        return -1;
    }

    /**
     * Downloads a single recipe from the given "Nosalty" URL
     *
     * @param url URL
     */
    private void scrapeNosalty(String url) throws IOException {
        page = Jsoup.connect(url).get();
        System.out.println(page.text());
        //throw new NotImplementedException();
    }

    /**
     * Downloads a single recipe from the given "Streetkitchen" URL
     *
     * @param url URL
     */
    private void scrapeStreetkitchen(String url) throws IOException {
        page = Jsoup.connect(url).get();
        System.out.println(page.text());
        //throw new NotImplementedException();
    }

    private void generateRecipeURL() {
        /** NOSALTY:
         * "base URL" is:  https://www.nosalty.hu/receptek/kategoria/  [ x ]  /osszes?limit=100&view=small&order=abc
         *  x will change according to the sites main food categories eg: "aprosutemeny", "husetelek"... need a Collection to store them and loop trough
         *  this will generate the URL of the FIRST page of x main food category eg: https://www.nosalty.hu/receptek/kategoria/husetelek/osszes?limit=100&view=small&order=abc
         * this URL contains 100 food names/page in x main food category
         *  to access the SECOND page the URL must change eg: https://www.nosalty.hu/receptek/kategoria/husetelek/osszes?page=0%2C1&limit=100&view=small&order=abc
         *  this URL is the SECOND page of the food names in a given main feed category
         *  to access ALL pages this bit of the URL must me changed:  "page=0%2C1" = second page, "page=0%2C2" = third page, "page=0%2Cn" = n + 1 th page ...
         *  NOTE: if the given main category (with 100 food names/page) has n number of pages and the generated URL points to a bigger number than n (eg: 10 pages and you point to 84th page) the url will point to the n th (the last) page still.
         *
         *  to access the specific recipe URL in a a given page food names msut be scraped (100/page)
         *  in each page there is a ul element with an attribute:   class="article-list-items clearfix"
         *  this ul list contains every recipe in each page, in the following way it can be accessed
         *  the ul list contains a li element with an attribute:  class="recept-118" (constant in all of the categories and in all pages)
         *  this li contains a div: class="article-img-wrapper"
         *  this contains an attribute href with a href attribute value that  contains the information we want in the fallowing way:  href="/recept/chilis-hal"
         *  now we have access to the food names
         *  now we need the new base url "base URL2" : https://www.nosalty.hu/
         *  new base URL2 + this href attrigute value will point to the specific recipe URL in every case eg: https://www.nosalty.hu/recept/chilis-hal
         *SUMMARY:
         * todo summary
         * todo how to scrape secific recipe information for the Object: Recipe
         *
         *
         *
         */

        /** STREETKITCHEN
         *in theory the base URL: https://streetkitchen.hu/category/receptek/ contains ALL recipes in the site
         * this site has edvenced design ( at least in compared to nosallty:) )
         * the base URL contains  a div with attribute: class="article-list-container"
         * this basically contains a grid in the following way
         * this contains a div with: class="row"
         * this contains a div with:  class= "col-content-item-small archive-col-0" and also class= "col-content-item-small archive-col-1" ... each row contains different number of columns
         * these elements contain  an article attribute with a complex class name... eg: sk-item sk-small sk-item-type-normal post-12517574 post type-post status-publish format-standard has-post-thumbnail hentry category-brutalis-fogasok category-friss category-receptek category-street-kitchen category-videokosar tag-burgonya tag-dodolle tag-krumpli tag-lecso tag-magyaros tag-szalonna
         *the article contains furthermore a href pointing to the specific recipe URL eg: <a href="https://streetkitchen.hu/brutalis-fogasok/dodolle-hazi-lecsoval-ahogy-ze-kesziti/" class="article-link"></a>
         *
         * there are special cases...
         * sometimes the row class will only contain 1 col eg: class="col archive-col-7"  OR class= "col-content-item-horizontal horizontal_left archive-col-16"(the rest of the scrape is the same)
         * sometimes the row contains only one col eg:         class="col-content-item-horizontal archive-col-8 horizontal_right"
         *
         *
         *
         * SUMMARY:
         * todo summary
         * todo scrape specific recipe for Object creation
         *
         *
         */
    }
}
