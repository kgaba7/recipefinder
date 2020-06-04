package controller;

import constants.Constant;
import logger.RecipeFinderLogger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Index;
import utils.Messages;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author kissg on 2020. 05. 15.
 */
public class RecipeFinderController extends BaseController {

    public RecipeFinderController(RecipeFinderLogger logger) {
        super(logger);
    }

    /**
     * Exits current program
     */
    public void exit() {
        System.exit(0);
        // throw new NotImplementedException();
    }
//todo try catch, logger, 2 methods

    /**
     * Decides which scaping method will be used, depending on the given URL
     *
     * @param url URL
     */
    public void downloadFactory(String url) throws IOException {
        //TODO lehetne szebben is logolni, ez most csak hirtelen a példa kedvéért van így. Később refactor
        if (url.toLowerCase().contains("nosalty")) {
            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoDownloadFactory(url));
            scrapeNosalty(url);
            return;
        }
        if (url.toLowerCase().contains("streetkitchen")) {
            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoDownloadFactory(url));
            scrapeStreetkitchen(url);
            return;
        }
        if (url.toLowerCase().contains("receptneked")) {
            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoDownloadFactory(url));
            scrapeReceptneked(url);
            return;
        }
        if (url.toLowerCase().contains("recepttar")) {
            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoDownloadFactory(url));
            scrapeRecepttar(url);
            return;
        }
        if (url.toLowerCase().contains("mindmegette")) {
            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoDownloadFactory(url));
            scrapeMindmegette(url);
            return;
        }
        if (url.toLowerCase().contains("cookpad")) {
            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoDownloadFactory(url));
            scrapeCookpad(url);
            return;
        }
        getLogger().error(RecipeFinderController.class.getName(), Messages.getErrorDownloadFactory(url));
    }

    /**
     * Downloads a single recipe from the given "Nosalty" URL
     *
     * @param url URL
     */
    public void scrapeNosalty(String url) throws IOException {
        List<String> ingredients = new ArrayList<>();
        HashMap<String, String> nutritionalValue = new HashMap<>();
        int count = 0;
        String classPic = ".ns-recept-img-layer img";
        String classContent = ".article-content";
        String classIngredients = "column-block-content";
        String classPortion = "column grid-one, .dont-print .recept-hozzavalok .column-block-title";
        String classDescription = "column-block recept-elkeszites dont-print";
        String classTime = ".right-text, .dont-print";
        String classDiff = ".floatright";
        String classNutrientTable = ".tapanyagtartalom-tablazat";
        String classNutrientType = ".column-block-title";
        String classNutrientValue = ".column-block-content, .clearfix";
        try {
            Document page = Jsoup.connect(url).get();
            //PICTURE
            System.out.println("Picture Link: \n");
            String pic = page.select(classPic).attr("src");
            System.out.println(pic);
            //INGREDIENTS

            Elements content = page.getElementsByClass(classIngredients).get(1).getElementsByTag("ul");
            for (Element act : content) {
                ingredients.add(act.text());
            }

            System.out.println("Hozzávalók:");
            System.out.println(ingredients.toString());
            //PORTIONS
            Elements portion = page.select(classPortion + " span[itemprop=yield]");
            System.out.println("Adag: \n");
            System.out.println(portion.text());
        //DESCRIPTION + (HYSTORTY OF RECIPE)
            Elements story = page.select(classContent + " p");
            System.out.println("Story: \n");
            System.out.println(story.text());
            System.out.println("Description: \n");
            Elements description = page.getElementsByClass(classDescription).get(0).getElementsByTag("li");
            int step = 1;
            for (Element act : description) {
                System.out.println(step + " " + act.text() + "\n");
                step++;
            }
             // DIFFICULTY
            Elements difficulty = page.select(classDiff + " a[href]");
            System.out.println("Difficulty: \n");
            System.out.println(difficulty.text());
             //TIME
            Element time = page.select(classTime + " span.bold").get(0);
            System.out.println("Cook Time: \n");
            System.out.println(time.text());

            // NUTRIENTS
            page = Jsoup.connect(getNutrientPageNOSALTY(url)).get();
            Elements nutrientType = page.select(classNutrientTable).get(0).select(classNutrientType);
            Elements nutrientValueList = page.select(classNutrientValue).select(" dl");
            System.out.println("Nutrients: \n");
            for (Element main : nutrientType) {
                for (int i = count; count < nutrientValueList.size(); count++) {
                    nutritionalValue.put(main.text(), nutrientValueList.get(i).text());
                    count++;
                    break;
                }
            }
            nutritionalValue.forEach((key, value) -> System.out.println(key + " : " + value));
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().error(RecipeFinderController.class.getName(), Messages.getErrorScrapeNOSALTY(url));
        }
    }

    public void scrapeNosaltyKG(String url) {
        String classIngredients = "recept-hozzavalok";
        String classRecipe = "recept-elkeszites";
        String classIngredientsList = "item-list";
        String classDifficulty = ".floatright a[href]";
        String classTime = ".right-text, .dont-print span.bold";
        boolean isBaseUrlOk = false;
        try {
            Document page = Jsoup.connect(url).get();

            //Hozzávalók
            System.out.println("Hozzávalók: ");
            printChildElementsByTag(page.getElementsByClass(classIngredients).get(0).getElementsByClass(classIngredientsList), "li");
            System.out.println("-----------");

            //Elkészítés
            System.out.println("Elkészítés: ");
            printChildElementsByTag(page.getElementsByClass(classRecipe), "li");
            System.out.println("-----------");

            //Nehézség
            System.out.println("Nehézség: ");
            printChildElementsByTag(page.select(classDifficulty), "a");
            System.out.println("-----------");

            //Idő
            System.out.println("Idő: ");
            printChildElementsByTag(page.select(classTime), "span");
            System.out.println("-----------");
            isBaseUrlOk = true;

            //Tápanyagok
            System.out.println("Tápanyagok: ");
            getNosaltyRecipeNutrients(getNutrientPageNOSALTY(url));
            System.out.println("-----------");

            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoScrapeNOSALTY(url));
            //todo log OK    ?

        } catch (IOException e) {
            e.printStackTrace();
            if (isBaseUrlOk) {
                //todo log Jsoup.connect error nutrients
            } else {
                //todo log Jsoup.connect error base
            }
        } catch (Exception e) {
            if (isBaseUrlOk) {
                //todo log error nutrients
            } else {
                //todo log error base
            }
        }
    }

    private void printChildElementsByTag(Elements elements, String tag) throws Exception {
        for (Element e1 : elements) {
            Elements list = e1.getElementsByTag(tag);
            for (Element e2 : list) {
                System.out.println(e2.text());
            }
        }
    }


    private void printTagValue(Elements elements, String tag, String tagValue) throws Exception {
        for (Element e1 : elements) {
            Elements list = e1.getElementsByTag(tag);
            for (Element e2 : list) {
                System.out.println(e2.attr(tagValue));
            }
        }
    }

    private void getNosaltyRecipeNutrients(String url) throws IOException, Exception {
        String classNutrients = "tapanyagtartalom-tablazat";
        String classNutrientsList = "column-block";
        Document page = Jsoup.connect(url).get();
        Elements elements = page.getElementsByClass(classNutrients);
        printChildElementsByTag(elements.get(0).getElementsByClass(classNutrientsList), "dl");
    }

    /**
     * Returns list of first pages, in every main food category in the site: nosalty.hu
     *
     * @param url Base url
     * @return in URL compatible format
     * @throws IOException
     */
    public List getFirstPageNOSALTY(String url) throws IOException {
        Document page = Jsoup.connect(url).get();
        List result = new ArrayList();
        String add = "/osszes?page=0%2C0&limit=100&view=small&order=abc"; // makes list to: abc order, 100 recipe/page

        Elements main = page.select(".article-link");

        for (Element element : main) {
            result.add(Constant.trueBase[Index.NOSALTY_BASE] + element.attr("href") + add);
        }
        System.out.println(result.toString() + result.size());
        return result;
    }

    /**
     * Returns the nutrient page of any given recipe
     *
     * @param url base url
     * @return the nutrient page of given recipe
     */
    private String getNutrientPageNOSALTY(String url) {
        final String addCal = "tapanyag/";

        if (url.contains("recept")) {
            final String recipe = "recept/";
            int pos = url.indexOf(recipe) + recipe.length();

            System.out.println(url.substring(0, pos) + addCal + url.substring(pos));
            return url.substring(0, pos) + addCal + url.substring(pos);
        }
        if (url.contains("alapanyag")) {
            final String ingredient = "alapanyag/";
            int pos = url.indexOf(ingredient) + ingredient.length();

            System.out.println(url.substring(0, pos) + addCal + url.substring(pos));
            return url.substring(0, pos) + addCal + url.substring(pos);
        }
        return "error";
    }

    /**
     * Returns list of all recipe URLs from given page
     */
    public List getRecipeUrlNOSALTY(String page) throws IOException {
        Document act = Jsoup.connect(page).get();
        List<String> recipes = new ArrayList<>();
        //todo
        String lastPage = act.select("a.icon-pager-last").attr("href");
        Elements recipe = act.select("div.kategoria-oldal, .kategoria-oldal-recept, .level-1, .nosalty-node-lista, .filters-enabled li.recept-118 .article-img-wrapper a[href].article-img-link");

        //first element is empty, so count starts from 1
        for (int i = 1; i < recipe.size(); i++) {
            recipes.add(Constant.trueBase[Index.NOSALTY_BASE] + recipe.get(i).attr("href"));
        }
        System.out.println("Last: " + lastPage);
        System.out.println(recipes.toString());
        return recipes;
    }

    /**
     * Loops all pages in given food category, stops at the last one
     *
     * @param page
     * @return
     * @throws IOException
     */
    public String loopPagesNOSALTY(String page) throws IOException {
        Document document = Jsoup.connect(page).get();
        final String index = "=0%2C";
        List<String> result = new ArrayList<>();
        int pageNum = page.indexOf(index) + index.length();
        String lastPage = document.select("a.icon-pager-last").attr("href");

        String subEnd = page.substring(pageNum + 1, page.length());
        String subBegin = page.substring(0, page.indexOf(subEnd) - 1);

        int count = 0;
        String ch;
        String currentPage;
        do {
            ch = String.valueOf(count);
            currentPage = subBegin + ch + subEnd;
            result.add(currentPage);
            count++;

        } while (!currentPage.contains(lastPage));

        System.out.println(result.toString());
        return page;
    }

    /**
     * Scrapes nosalty Ingredient
     * @param url
     * @throws IOException
     */
    public void scrapeIngredient(String url) throws IOException {
        Document page = Jsoup.connect(url).get();
        String className = "article-meta border-bottom-dotted clearfix";
        String classPicture = "article-img-wrapper floatleft";
        String classDescription = "block-content";

        try {
            //Name
            printChildElementsByTag(page.getElementsByClass(className), "h1");

             //PICTURE
            printTagValue(page.getElementsByClass(classPicture), "img", "src");

            //Description
            printChildElementsByTag(page.getElementsByClass(classDescription), "p");


            //IngredNutrients
            getNosaltyRecipeNutrients(getNutrientPageNOSALTY(url));
            System.out.println("-----------");

            getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoScrapeIngredient(url));

        } catch (Exception e) {
            e.printStackTrace();
            getLogger().error(RecipeFinderController.class.getName(), Messages.getErrorScrapeIngredient(url));
        }
    }

    private void addUrlToList(List list, Elements elements, String tag, String tagValue, int start) {
        for (int i = start; i < elements.size(); i++) {
            list.add(Constant.trueBase[Index.NOSALTY_BASE] + elements.get(i).getElementsByTag(tag).attr(tagValue));
        }
    }

    /**
     * returns all ingredient url on nosalty
     *
     * @param page
     * @return
     * @throws IOException
     */
    public List getIngredientUrl(String page) throws IOException {
        Document document = Jsoup.connect(page).get();
        List<String> mainCategory = new ArrayList<>();
        List<String> subCategory = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String classMain = ".article-list-items .clearfix .kategoria, .kategoria-118 a.article-link";

        try {
            printTagValue(document.select(classMain), "a", "href");
            addUrlToList(mainCategory, document.select(classMain), "a", "href", 0);
            for (String url : mainCategory) {
                document = Jsoup.connect(url).get();
                addUrlToList(subCategory, document.select(classMain), "a", "href", 1); // start index excludes first item of the list
            }
            for (String url : subCategory) {
                document = Jsoup.connect(url).get();
                addUrlToList(result, document.select(classMain), "a", "href", 1);

                getLogger().info(RecipeFinderController.class.getName(), Messages.getInfoGetIngredientNOSALTY(url));
            }
        } catch (Exception e2) {
            e2.printStackTrace();

            getLogger().error(RecipeFinderController.class.getName(), Messages.getErrorGetIngredientNOSALTY(page));
        }
        System.out.println(result.toString() + result.size());
        return result;
    }

    public void scrapeCookpad(String url) throws IOException {

        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("http://www.google.com")
                .timeout(100)
                .get();
        System.out.println(doc.text());

    }

    /**
     * Downloads a single recipe from the given "Streetkitchen" URL
     *
     * @param url URL
     */
    private void scrapeStreetkitchen(String url) throws IOException {
        Document page = Jsoup.connect(url).get();
        page = Jsoup.connect(url).get();
        System.out.println(page.text());
    }

    /**
     * Downloads a single recipe from the given "Receptneked" URL
     *
     * @param url URL
     */
    private void scrapeReceptneked(String url) throws IOException {
        Document page = Jsoup.connect(url).get();
        System.out.println(page.text());

    }

    /**
     * Downloads a single recipe from the given "Recepttar" URL
     *
     * @param url URL
     */
    private void scrapeRecepttar(String url) throws IOException {
        Document page = Jsoup.connect(url).get();
        System.out.println(page.text());
        //throw new NotImplementedException();
    }

    /**
     * Downloads a single recipe from the given "Mindmegette" URL
     *
     * @param url URL
     */
    private void scrapeMindmegette(String url) throws IOException {
        Document page = Jsoup.connect(url).get();
        System.out.println(page.text());
    }


    /**
     * to iterate trough all pages in main food categories, given by the site itself, I need these methods:
     * 1 inserts String between two specified chars
     * 2 replaces String between two specified chars
     * 3 add a String to specific index to base String
     * <p>
     * Basically modify a BASE URL in every website, to get access to all pages containing the links of all recipes
     */


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
     *  SCRATCH THE ABOVE!!!
     *  this way BASE URL can be constant: this is first page!!! (method already exists to the complicated solution, maybe is will come in handy somewhere else)
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
    /**
     * COOKPAD.hu
     *
     * @throws IOException
     */


    public void elapsedTimeTest() throws IOException {
        try {
            long start = System.currentTimeMillis();

            Thread.sleep(2000);
            System.out.println(getElapsedTime(System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
