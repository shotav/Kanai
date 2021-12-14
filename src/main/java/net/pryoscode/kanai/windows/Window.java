package net.pryoscode.kanai.windows;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.Loader;
import net.pryoscode.kanai.windows.components.Editor;
import net.pryoscode.kanai.windows.components.Sidebar;
import net.pryoscode.kanai.windows.tabs.CodeTab;

public class Window extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        stage.setScene(new Scene(root, 1280, 720));
        stage.setTitle("Kanai Editor");
        stage.getIcons().add(new Image(Loader.load("img/icon.png")));
        stage.getScene().getStylesheets().add("styles:core");
        stage.getScene().getStylesheets().add("styles:theme");

        root.setLeft(new Sidebar(new File(System.getProperty("user.dir"))));
        root.setCenter(new Editor());
        Editor.open(new CodeTab());

        stage.show();
    }

}