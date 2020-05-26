package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import view.RecipeFinderMainWindow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public void scrapeNosalty(String url) throws IOException {


        List<String> ingredients = new ArrayList<>();
        List<String> nutrientValues = new ArrayList<>();
        List<String> nutrientCaterories = new ArrayList<>();
        StringBuilder nutrientsSB = new StringBuilder();
        HashMap<String, String> nutritionalValue = new HashMap<>();
        int count = 0;

        Elements container;
        Elements outerDiv;
        Elements innerDiv;
        Elements list;
        Elements listElements;

        String classContent = "article-content";
        String classIngredients = "recept-hozzavalok";
        String classKcal = "recept-kaloriatartalom";
        String descriptionClass = "column-block recept-elkeszites dont-print";
        String recipeProperties = "column-block recept-receptjellemzok dont-print";
        String timeClass = "right-text dont-print";
        String diffClass = "floatright";
        String nutrientTableClass = "tapanyagtartalom-tablazat";
        String nutrientValueClass = "column-block-title";

        page = Jsoup.connect(url).get();

        //INGREDIENNTS
        container = this.page.getElementsByClass(classIngredients);

        list = container.get(0).getElementsByTag("ul");
        listElements = list.get(0).getElementsByTag("li");

        System.out.println("Hozzávalók:");
        for (Element act : listElements) {
            ingredients.add(act.text());

        }
        System.out.println(ingredients.toString());

        //DESCRIPTION + (HYSTORTY OF RECIPE)
        outerDiv = page.getElementsByClass(classContent);
        Elements history = outerDiv.get(0).getElementsByTag("p");


        outerDiv = page.getElementsByClass(descriptionClass);
        list = outerDiv.get(0).getElementsByTag("ol");

        System.out.println("DESCRIPTION: \n");
        System.out.println(history.text() + "\n" + list.text() + "\n");

// DIFFICULTY

        innerDiv = page.getElementsByClass(diffClass);
        listElements = innerDiv.select("span > a");

        System.out.println("DIFFICULTY: \n");
        System.out.println(listElements.text());

//TIME
        innerDiv = page.getElementsByClass(timeClass);
        listElements = innerDiv.get(0).getElementsByTag("span");

        System.out.println("Time: \n");
        System.out.println(listElements.text());

        // NUTRIENTS
        page = Jsoup.connect(nosaltyNutrientPage(url)).get();


        container = page.getElementsByClass(nutrientTableClass);

        outerDiv = container.get(0).getElementsByClass(nutrientValueClass); // main nutrient type
        innerDiv = container.get(0).getElementsByTag("dl"); // sub
        list = innerDiv.get(0).getElementsByTag("dt");
        listElements = innerDiv.get(0).getElementsByTag("dd");

        // todo add dt and dd to pairs dor easier use !

        for (Element main : outerDiv) {
            for (int i = count; count < innerDiv.size(); count++) {
                nutritionalValue.put(main.text(), innerDiv.get(i).text());
                count++;
                break;
            }
        }

        /**
         * todo match the sub with the main
         *fehérje: Összesen: 38.2 g
         *zsír : Összesen: 14.4 g Telített zsírsav: 4 g Egyszeresen telítetlen zsírsav: 7 g Többszörösen telítetlen zsírsav: 3 g Koleszterin: 107 mg
         * ásványi anyagok: Összesen: 1.6 g Kalcium: 59 mg Vas: 4 mg Magnézium: 54 mg Foszfor: 407 mg Kálium: 941 mg Nátrium: 141 mg Cink: 9 mg Réz: 0 mg Mangán: 0 mg Szelén: 41 µg
         */

        System.out.println("Main and Sub Nutrient values( in order so nth Main matches  nth Sub row ): \n");

       // nutritionalValue.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println(list.text() + " "+ listElements.text());
    }


    /**
     * Can be done by pointing to the article-tabs tabs content-tabs class, and to the first li element a href element.text()
     *
     * @param url base url
     * @return the cal page of given recipe
     */
    private String nosaltyCalPage(String url) {
        final String addCal = "kaloria/";
        int pos = url.indexOf("recept/") + 7;
        return url.substring(0, pos) + addCal + url.substring(pos, url.length());

    }

    /**
     * @param url base url
     * @return the nutrient page of given recipe
     */
    private String nosaltyNutrientPage(String url) {
        final String addCal = "tapanyag/";
        int pos = url.indexOf("recept/") + 7;
        return url.substring(0, pos) + addCal + url.substring(pos, url.length());
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


    /**
     * First i need to get access to main categories containing  all the links to the specific recipes
     *
     * @param categories NOTE: can be scraped too, than put in a collection, will not affect the method
     * @param baseURL    NOTE: maybe more elegant with regex?
     */
    public String[] insertMainFoodCategoryToURL(String[] categories, String baseURL) {
        String[] mainCategoryURL = new String[40];

        for (int i = 0; i < categories.length; i++) {
            mainCategoryURL[i] = baseURL.replace("*", categories[i]);
        }
        for (String i : mainCategoryURL) {
            System.out.println(i);

        }
        return mainCategoryURL;
    }


    /**
     * to iterate trough all pages in main food categories, given by the site itself, I need these methods:
     * 1 inserts String between two specified chars
     * 2 replaces String between two specified chars
     * 3 add a String to specific index to base String
     * <p>
     * Basically modify a BASE URL in every website, to get access to all pages containing the links of all recipes
     */

//    /**
//     * @param base      URL to modify
//     * @param additions String array to be inserted
//     * @param leftBound &  @param rightBound  between these characters the additios will be inserted
//     */
//    public void modifyURL(String base, String[] additions, char leftBound, char rightBound) {
//
//    }
//
//    /**
//     * @param base      URL to modify
//     * @param addition  String to be inserted
//     * @param leftBound &  @param rightBound  between these characters the additios will be inserted
//     */
//    public void modifyURL(String base, String addition, char leftBound, char rightBound) {
//
//    }


//    /**
//     * I need to insert addition String between "?" AND "l"
//     * maybe more elegant with regex
//     * maybe with insertAfter ?
//     * STRINGBUFFER ?
//     * another method?
//     */
//    public String iteratePagesIFBaseURLIsDifferentInFirstPage(String baseURL, String addition, char leftBound, char rightBound) {
//        StringBuilder result = new StringBuilder(baseURL);
//        int page = 1;
//        result.insert(baseURL.indexOf(leftBound), leftBound + addition);
//
//        System.out.println(result);
//        return result.toString();
//    }
    public void iteratePages(String baseURL) {

    }

    public void iteratePages(String baseURL, int pages) {

    }


    /** NOSALTY:
     * "base URL" is:  https://www.nosalty.hu/receptek/kategoria/  [ x ]  /osszes?limit=100&view=small&order=abc
     *  x will change according to the sites main food categories eg: "aprosutemeny", "husetelek"... need a Collection to store them and loop trough
     *  (
     *
     *  OR not in collection, but scrape the main categories themselves from: https://www.nosalty.hu/receptek
     *  ul class="article-list-items clearfix" -> li class="kategoria kategoria-118" -> div class="article-content"
     *  then like this: <a href="/receptek/kategoria/befottek" class="img-box-subtitle bold">befőttek</a>
     *
     *  )
     *
     *  SCRATCH THE ABOVE!!! this way BASE URL can be constant: this is first page!!! (method already exists to the complicated solution, maybe is will come in handy somewhere else)
     *  https://www.nosalty.hu/receptek/kategoria/aprosutemeny/osszes?page=0%2C0&%3Flimit=100&view=small&order=abc
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
     *
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

    /** STREETKITCHEN todo figure it out.. PLEASE MY NIGGA
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

    /**
     * MINDMEGETTE
     * main food categories : http://www.mindmegette.hu/kategoria/desszertek/ hard codeing
     * sub categories: are in h2 tags  in each main page: make a collection
     * main categories + sub categories + in abc = http://www.mindmegette.hu/kategoria/desszertek/palacsintak-es-gofrik/osszes/A/
     * in each letter (/A/, /G/ etc.) there are multiple pages, the above url is the firs of them!
     * nth page can be accessed like this: http://www.mindmegette.hu/kategoria/desszertek/palacsintak-es-gofrik/osszes/A/?=n
     * so like.. in F letter the 4th page is:
     * http://www.mindmegette.hu/kategoria/desszertek/palacsintak-es-gofrik/osszes/X?p=4
     * <p>
     * access specific recipe url
     * its all in class="recipe-item end column"
     * in aa href
     * todo access recipe details
     */


    public void elapsedTimeTest() {
        try {
            long start = System.currentTimeMillis();
            /*
            kód kód
            kód stb stb
             */
            Thread.sleep(2000);//ez csak azért van itt, hogy "elteljen" 2 sec
            System.out.println(getElapsedTime(System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
