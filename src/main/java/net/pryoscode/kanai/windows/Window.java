package net.pryoscode.kanai.windows;

import java.io.File;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.Loader;
import net.pryoscode.kanai.windows.components.BorderlessScene;
import net.pryoscode.kanai.windows.components.Editor;
import net.pryoscode.kanai.windows.components.Files;
import net.pryoscode.kanai.windows.components.Titlebar;
import net.pryoscode.kanai.windows.tabs.CodeTab;

public class Window extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        BorderlessScene scene = new BorderlessScene(stage, root, 1280, 720);
        root.setId("root");
        stage.setScene(scene);
        stage.setTitle("Kanai Editor");
        stage.getIcons().add(new Image(Loader.load("img/icon.png")));
        stage.getScene().getStylesheets().add("styles:core");
        stage.getScene().getStylesheets().add("styles:theme");

        BorderPane sidepanel = new BorderPane();
        Titlebar titlebar = new Titlebar(stage);
        scene.setDraggable(titlebar);
        sidepanel.setTop(titlebar);
        sidepanel.setCenter(new Files(new File(System.getProperty("user.dir"))));
        root.setLeft(sidepanel);
        root.setCenter(new Editor());
        Editor.open(new CodeTab());

        stage.show();
    }

}