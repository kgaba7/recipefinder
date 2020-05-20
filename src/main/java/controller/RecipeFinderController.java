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
    public void downloadFactory(String url) throws IOException {
        if (url.toLowerCase().contains("nosalty")) {
            scrapeNosalty(url);
            return;
        }
        if (url.toLowerCase().contains("streetkitchen")) {
            scrapeStreetkitchen(url);
            return;
        }
        if (url.toLowerCase().contains("receptneked")) {
            scrapeReceptneked(url);
            return;
        }
        if (url.toLowerCase().contains("recepttar")) {
            scrapeRecepttar(url);
            return;
        }
        if (url.toLowerCase().contains("mindmegette")) {
            scrapeMindmegette(url);
            return;
        }
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
    /**
     * Downloads a single recipe from the given "Receptneked" URL
     *
     * @param url URL
     */
    private void scrapeReceptneked(String url) throws IOException {
        page = Jsoup.connect(url).get();
        System.out.println(page.text());
        //throw new NotImplementedException();
    }
    /**
     * Downloads a single recipe from the given "Recepttar" URL
     *
     * @param url URL
     */
    private void scrapeRecepttar(String url) throws IOException {
        page = Jsoup.connect(url).get();
        System.out.println(page.text());
        //throw new NotImplementedException();
    }
    /**
     * Downloads a single recipe from the given "Mindmegette" URL
     *
     * @param url URL
     */
    private void scrapeMindmegette(String url) throws IOException {
        page = Jsoup.connect(url).get();
        System.out.println(page.text());
        //throw new NotImplementedException();
    }

    /**
     * Generates URL of specific recipes
      */
    private void generateRecipeURL() {

    }

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
         *  to access the specific recipe URL in a a given page food names must be scraped (100/page)
         *  in each page there is a ul element with an attribute:   class="article-list-items clearfix"
         *  this ul list contains every recipe in each page, in the following way it can be accessed
         *  the ul list contains a li element with an attribute:  class="recept-118" (constant in all of the categories and in all pages)
         *  this li contains a div: class="article-img-wrapper"
         *  this contains an attribute href with a href attribute value that  contains the information we want in the fallowing way:  href="/recept/chilis-hal"
         *  now we have access to the food names
         *  now we need the new base url "base URL2" : https://www.nosalty.hu/
         *  new base URL2 + this href attribute value will point to the specific recipe URL in every case eg: https://www.nosalty.hu/recept/chilis-hal
         *SUMMARY:
         * loop main food categories and manipulate base url
         * get food names of first page
         * add name to https://www.nosalty.hu/ base URL
         * get food details
         * todo how to scrape secific recipe information for the Object: Recipe
         *
         *
         *
         */

        /** STREETKITCHEN todo figure it out..
         *in theory the base URL: https://streetkitchen.hu/category/receptek/ contains ALL recipes in the site... i scrolled down for ages it never ends..
         * OR https://streetkitchen.hu/?s=&cat=274%2C54%2C71%2C43%2C95%2C251%2C47%2C87%2C697%2C77%2C303%2C66%2C159%2C125%2C838%2C60%2C286%2C&cat_array%5B%5D=125&cat_array%5B%5D=251&cat_array%5B%5D=77&cat_array%5B%5D=159&cat_array%5B%5D=838&cat_array%5B%5D=95&cat_array%5B%5D=697&cat_array%5B%5D=274&cat_array%5B%5D=60&cat_array%5B%5D=43&cat_array%5B%5D=87&cat_array%5B%5D=303&cat_array%5B%5D=286&cat_array%5B%5D=71&cat_array%5B%5D=47&cat_array%5B%5D=66&cat_array%5B%5D=54
         * this site has advanced design ( at least in compared to nosallty:) )
         * if u reach the bottom of the page, it will load more content..
         * the base URL contains  a div with attribute: class="article-list-container" contains all recipes!
         * this basically contains a grid in the following way
         * this contains many div -s  with: class="row"
         * this contains a div with:  class= "col-content-item-small archive-col-0" and also class= "col-content-item-small archive-col-1" ... each row contains different number of columns
         * these elements contain  an article attribute with a complex class name... eg: sk-item sk-small sk-item-type-normal post-12517574 post type-post status-publish format-standard has-post-thumbnail hentry category-brutalis-fogasok category-friss category-receptek category-street-kitchen category-videokosar tag-burgonya tag-dodolle tag-krumpli tag-lecso tag-magyaros tag-szalonna
         *the article contains furthermore a href pointing to the specific recipe URL eg: <a href="https://streetkitchen.hu/brutalis-fogasok/dodolle-hazi-lecsoval-ahogy-ze-kesziti/" class="article-link"></a>
         *
         * there are special cases...
         * sometimes the row class will only contain 1 col eg: class="col archive-col-7"  OR class= "col-content-item-horizontal horizontal_left archive-col-16"(the rest of the scrape is the same)
         * sometimes the row contains only one col eg:         class="col-content-item-horizontal archive-col-8 horizontal_right"
         *
         * i dont think its scrapable with jsoup  or it will be hard.. i have a few ideas
         *
         * SUMMARY:
         */

        /** RECEPTNEKED ( + 25k recipes)
         * base URL: https://receptneked.hu/?s=&category_name= contains all recipes Includeing non recipe articles, can be filtered based on non ingrediant list etc.
         * first page: https://receptneked.hu/?s=&category_name=
         * second page: https://receptneked.hu/page/2/?s&category_name
         * n th page : https://receptneked.hu/page/n/?s&category_name
         *
         *to access specific food URL
         * a div with: id="recipe-list" contains all food names in given page
         * contains a div with: class="grid-recipe-img-container"
         * with href attribute to the specific link <a href="https://receptneked.hu/edes-sutemenyek/gyumolcsos-szelet-citromos-kremmel/">
         *
         *
         * todo access recipe details
         */

        /**RECEPTTAR (+ 14k rec)
         * main categories to hard code, like: https://www.recepttar.hu/kategoria/levesek-93, https://www.recepttar.hu/kategoria/tavaszi-etelek-71
         * in each page there is an element with: class="oldalak"
         * this contains the number of pages in the given main food category
         * loop is simple between pages. nth page:  https://www.recepttar.hu/kategoria/tavaszi-etelek-71/n
         *ul -> li -> href contains the specific recipe URL
         *todo access recipe details
         */

        /**MINDMEGETTE
         * main food categories : http://www.mindmegette.hu/kategoria/desszertek/ hard codeing
         * sub categories: are in h2 tags  in each main page: make a collection
         * main categories + sub categories + in abc = http://www.mindmegette.hu/kategoria/desszertek/palacsintak-es-gofrik/osszes/A/
         * in each letter (/A/, /G/ etc.) there are multiple pages, the above url is the firs of them!
         * nth page can be accessed like this: http://www.mindmegette.hu/kategoria/desszertek/palacsintak-es-gofrik/osszes/A/?=n
         * so like.. in F letter the 4th page is:
         * http://www.mindmegette.hu/kategoria/desszertek/palacsintak-es-gofrik/osszes/X?p=4
         *
         * access specific recipe url
         * its all in class="recipe-item end column"
         * in aa href
         * todo access recipe details
         */

}
