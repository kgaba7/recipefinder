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

/**
 * @author kissg on 2020. 05. 15.
 */
public class RecipeFinderMainWindow extends Application {
    private RecipeFinderController controller;

    public void start(Stage primaryStage) throws Exception {
        this.controller = new RecipeFinderController();
        initComponents();
        addHandlersToButtons();
        GridPane paneContainer, paneTextfields, paneButtons;

        paneContainer = getGridPane(Pos.CENTER);
        paneTextfields = getGridPane(Pos.CENTER);
        paneButtons = getGridPane(Pos.CENTER);

        addComponentsToPanes(paneTextfields, paneButtons);

        paneContainer.add(paneTextfields, 0, 0);
        paneContainer.add(paneButtons, 0, 1);

        //TODO set size
        Scene scene = new Scene(paneContainer, screenBounds.getWidth()/2, screenBounds.getHeight()/3);


        primaryStage.setTitle("Recipe Finder");
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
     * Exits the application
     */
    private void exit() {
        controller.exit();
    }

    /**
     * Starts download session
     */
    private void download() {
        controller.downloadFactory(this.txtfUrl.getText());
    }

    /**
     * Adds action listeners to buttons
     */
    private void addHandlersToButtons() {
        this.btnExit.setOnAction(event -> exit());
        this.btnScrape.setOnAction(event -> download());
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


        //TODO set sizes CHECK
    }

    /**
     *  screenBounds gets primary screen width and height.
     */
    private Rectangle2D screenBounds;
    private Label lblUrl;
    private TextField txtfUrl;
    private Button btnExit;
    private Button btnScrape;
}
