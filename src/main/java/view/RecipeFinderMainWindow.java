package view;

import controller.RecipeFinderController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logger.RecipeFinderLogger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author kissg on 2020. 05. 15.
 */
public class RecipeFinderMainWindow  extends Application {
    private RecipeFinderController controller;
    private RecipeFinderLogger logger;

    public void start(Stage primaryStage) throws Exception {
        this.controller = new RecipeFinderController(logger);
        initComponents();
        addHandlersToButtons();
        GridPane paneContainer, paneTextfields, paneButtons;

        paneContainer = getGridPane(Pos.CENTER);
        paneTextfields = getGridPane(Pos.CENTER);
        paneButtons = getGridPane(Pos.CENTER);

        addComponentsToPanes(paneTextfields, paneButtons);

        paneContainer.add(paneTextfields, 0, 0);
        paneContainer.add(paneButtons, 0, 1);


        Scene scene = new Scene(paneContainer, screenBounds.getWidth()/2, screenBounds.getHeight()/3);


        primaryStage.setTitle("RecipeNosalty Finder");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Adds components to each pane
     *
     * @param paneTextfields pane for textfields
     * @param paneButtons    pane for buttons
     */
    private void addComponentsToPanes(GridPane paneTextfields, GridPane paneButtons) {
        paneTextfields.add(this.lblUrl, 0, 0);
        paneTextfields.add(this.txtfUrl, 1, 0);

        paneButtons.add(this.btnScrape, 0, 0);
        paneButtons.add(this.btnExit, 1, 0);
    }

    /**
     * Creates a basic gridpane with the given positioning
     *
     * @param pos pane's positioning
     * @return Basic gridPane
     */
    private GridPane getGridPane(Pos pos) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5, 0, 5, 0));
        gridPane.setAlignment(pos);
        return gridPane;
    }

    /**
     * Searches the downloaded recipes (downloaded by initialize()) based on the "Added ingredients" and the "Forbidden ingredients" lists + the basic settings (difficulty, type etc) and adds the result(s) to the "Results" list
     */
    private void search()
    {
        //controller-es method lesz
        throw new NotImplementedException();
    }

    /**
     * Adds the selected ingredient to the "Forbidden ingredients" list
     */
    private void removeIngredient()
    {
        //itteni funkció
        throw new NotImplementedException();
    }

    /**
     * Adds the selected ingredient to the "Added ingredients" list
     */
    private void addIngredient()
    {
        //itteni funkció
        throw new NotImplementedException();
    }

    /**
     * Downloads 10-15-20 random recipes from Nosalty, for testing
     */
    private void initialize()
    {
        //controller-es method lesz
        throw new NotImplementedException();
    }

    /**
     * Clears the "Added ingredients" and the "Forbidden ingredients" lists
     */
    private void reset()
    {
        //itteni funkció
        throw new NotImplementedException();
    }

    /**
     * Exits the application
     */
    private void exit() {
        controller.exit();
    }

    /**
     * Starts download session
     */
    private void download() throws Exception {
        controller.downloadFactory(this.txtfUrl.getText());
    }

    /**
     * Adds action listeners to buttons
     */
    private void addHandlersToButtons() {
        this.btnExit.setOnAction(event -> exit());
        this.btnScrape.setOnAction(event -> {
            try {
                download();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Initializes all javafx components
     */
    private void initComponents() {
        this.lblUrl = new Label("URL");
        this.txtfUrl = new TextField();

        this.btnExit = new Button("Exit");
        this.btnScrape = new Button("Download");

        screenBounds = Screen.getPrimary().getBounds();


        //TODO set sizes CHECK? vagy nem a scene sizera gondoltál?
    }

    /**
     *  screenBounds gets primary screen width and height
     */
    private Rectangle2D screenBounds;
    private Label lblUrl;
    private TextField txtfUrl;
    private Button btnExit;
    private Button btnScrape;

    //TODO komponenseket létrehozni + inicializálni + handler-eket hozzáadni a gombokhoz stb. Mint a fentieknél (azok csak full példák, van amit fel lehet használni belőle, van ami full nem kell)
}
