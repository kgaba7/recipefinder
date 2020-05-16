package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainVIEW extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Recipe-Finder");
        Button btn = new Button();

        Button btn1 = new Button();


        GridPane root = new GridPane();
        root.getChildren().addAll(btn,btn1);
        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.show();
    }

}
