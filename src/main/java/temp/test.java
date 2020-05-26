package temp;

import constants.Constant;
import controller.RecipeFinderController;
import model.Ingredient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        test myTest = new test();
        RecipeFinderController controller = new RecipeFinderController();
       // myTest.getRecInfoNOSALTY("https://www.nosalty.hu/recept/bazsalikomos-tejszines-csirkemell-rozmaringos-sult-burgonyaval");
        //  myTest.getRecInfoSTREET("https://streetkitchen.hu/category/receptek/");
        // controller.insertMainFoodCategoryToURL(Constant.nosaltyMainCategories, Constant.nosaltyBaseURL);
        // controller.iteratePages("https://www.nosalty.hu/receptek/kategoria/aprosutemeny/osszes?page=0%2C0&%3Flimit=100&view=small&order=abc");
        controller.scrapeNosalty("https://www.nosalty.hu/recept/feher-spargakremleves-andreatol");
    }


    public void getRecInfoNOSALTY(String url) throws IOException {
        page = Jsoup.connect(url).get();
        // elements = page.select("h1").first(); name
        //elements = page.select("div.recept-elkeszites"); description
       // elements = page.select("* a[href]"); // select all a with href
        elements = page.select("div.main-footer");


        System.out.println(elements.text());


    }

    public void getRecInfoRECNEKED(String url) {

    }

    //wtf is this shit tho
    public void getRecInfoSTREET(String url) throws IOException {
        page = Jsoup.connect(url).get();
        //  elements = page.select("div.row > div.col-content-item-small.archive-col-1");
        elements = page.select("div.row > div.col-content-item-small");

        System.out.println(elements.text());

    }


    Document page;
    Element element;
    Elements elements;

    private String name;  // check
    private Ingredient ingredients;
    private String description;  // check
    private String calories;
    private double cookTime;
    private int recipeID;
    private double difficulty;
    private boolean isFavorite;
    private String URL;
    private boolean isUserMade;
    private int servings;

}
