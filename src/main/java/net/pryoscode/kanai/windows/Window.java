package net.pryoscode.kanai.windows;

import java.io.File;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import net.pryoscode.kanai.keyboard.KeyManager;
import net.pryoscode.kanai.utils.Loader;
import net.pryoscode.kanai.windows.components.Editor;
import net.pryoscode.kanai.windows.components.Files;
import net.pryoscode.kanai.windows.components.Toolbar;
import net.pryoscode.kanai.windows.tabs.CodeTab;

public class Window extends Stage {

    private static Stage stage;

    public Window() {
        stage = this;
        BorderPane root = new BorderPane();
        setScene(new Scene(root, 1280, 720));
        setTitle("Kanai Editor");
        setFullScreenExitHint("");
        getIcons().add(new Image(Loader.load("img/icon.png")));
        getScene().getStylesheets().add("styles:core");
        getScene().getStylesheets().add("styles:window");
        getScene().getStylesheets().add("styles:theme");
        addEventHandler(KeyEvent.KEY_PRESSED, new KeyManager()::onKeyPressed);
        Font.loadFont(Loader.load("fonts/FiraSans-Regular.ttf"), Toolkit.getToolkit().getFontLoader().getSystemFontSize());
        Font.loadFont(Loader.load("fonts/FiraMono-Regular.ttf"), Toolkit.getToolkit().getFontLoader().getSystemFontSize());

        BorderPane sidebar = new BorderPane();
        sidebar.setCenter(new Files(new File(System.getProperty("user.dir"))));
        sidebar.setBottom(new Toolbar(this));
        root.setLeft(sidebar);
        root.setCenter(new Editor());
        Editor.open(new CodeTab());
    }

    public static Stage getStage() {
        return stage;
    }

}