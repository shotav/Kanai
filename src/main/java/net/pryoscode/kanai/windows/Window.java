package net.pryoscode.kanai.windows;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.Loader;
import net.pryoscode.kanai.windows.components.BorderlessScene;
import net.pryoscode.kanai.windows.components.Files;
import net.pryoscode.kanai.windows.components.Titlebar;

public class Window extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setTop(new Titlebar("Test"));
        root.setLeft(new Files());
        stage.setScene(new BorderlessScene(stage, root, 1280, 720));
        stage.setTitle("Kanai Editor");
        stage.getIcons().add(new Image(Loader.load("img/icon.png")));
        stage.getScene().getStylesheets().add("styles:Core");
        stage.getScene().getStylesheets().add("styles:Theme");
        stage.show();
    }

}