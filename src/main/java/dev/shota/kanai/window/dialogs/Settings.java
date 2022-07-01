package dev.shota.kanai.window.dialogs;

import javafx.scene.layout.VBox;
import lombok.val;
import org.controlsfx.control.PropertySheet;

public class Settings extends Dialog {

    public Settings() {
        super("Settings", 200, 600);
        val root = new VBox();

        {
            val properties = new PropertySheet();
            root.getChildren().add(properties);
        }

        setRoot(root);
    }

}