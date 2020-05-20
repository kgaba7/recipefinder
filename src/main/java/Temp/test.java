package Temp;

import model.Ingredient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        test myTest = new test();
       // myTest.getRecInfoNOSALTY("https://www.nosalty.hu/recept/bazsalikomos-tejszines-csirkemell-rozmaringos-sult-burgonyaval");
        myTest.getRecInfoSTREET("https://streetkitchen.hu/category/receptek/");
    }


    public void getRecInfoNOSALTY(String url) throws IOException {
        page = Jsoup.connect(url).get();
        elements = page.select("h1");

        name = element.text();


        System.out.println(name + "\n");
        System.out.println(name + "\n");

    }

    public void getRecInfoRECNEKED(String url) {

    }

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
    private String description;
    private double calories;
    private double cookTime;
    private int recipeID;
    private double difficulty;
    private boolean isFavorite;
    private String URL;
    private boolean isUserMade;
    private int servings;

}
