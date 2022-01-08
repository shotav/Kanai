package net.pryoscode.kanai.windows;

import java.io.File;
import com.sun.javafx.tk.Toolkit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.Loader;
import net.pryoscode.kanai.windows.components.Editor;
import net.pryoscode.kanai.windows.components.Files;
import net.pryoscode.kanai.windows.components.Toolbar;
import net.pryoscode.kanai.windows.tabs.CodeTab;

public class Window extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        stage.setScene(new Scene(root, 1280, 720));
        stage.setTitle("Kanai Editor");
        stage.getIcons().add(new Image(Loader.load("img/icon.png")));
        stage.getScene().getStylesheets().add("styles:core");
        stage.getScene().getStylesheets().add("styles:window");
        stage.getScene().getStylesheets().add("styles:theme");
        Font.loadFont(Loader.load("fonts/FiraSans-Regular.ttf"), Toolkit.getToolkit().getFontLoader().getSystemFontSize());
        Font.loadFont(Loader.load("fonts/FiraMono-Regular.ttf"), Toolkit.getToolkit().getFontLoader().getSystemFontSize());

        BorderPane sidebar = new BorderPane();
        sidebar.setCenter(new Files(new File(System.getProperty("user.dir"))));
        sidebar.setBottom(new Toolbar(stage));
        root.setLeft(sidebar);
        root.setCenter(new Editor());
        Editor.open(new CodeTab());

        stage.show();
    }

}