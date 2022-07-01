package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.window.utils.Language;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import lombok.SneakyThrows;
import lombok.val;

public class About extends Dialog {

    @SneakyThrows
    public About() {
        super(Language.get("help.about"));
        val loader = new FXMLLoader();
        loader.setControllerFactory(param -> this);
        Pane root = loader.load(getClass().getClassLoader().getResourceAsStream("scenes/About.fxml"));
        setRoot(root);
    }
    @FXML
    private void github() {
        System.out.println("Hello World!");
    }

    @FXML
    private void ok() {
        dispose();
    }

}