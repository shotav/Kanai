package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.window.utils.Translation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import lombok.SneakyThrows;
import lombok.val;
import java.awt.*;
import java.net.URI;

public class About extends Dialog {

    @SneakyThrows
    public About() {
        super(Translation.get("help.about"));
        val loader = new FXMLLoader();
        loader.setControllerFactory(param -> this);
        Pane root = loader.load(getClass().getClassLoader().getResourceAsStream("scenes/About.fxml"));
        setRoot(root);
    }

    @FXML
    @SneakyThrows
    private void github() {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
            Desktop.getDesktop().browse(new URI("https://github.com/shotav/Kanai"));
    }

    @FXML
    private void ok() {
        dispose();
    }

}