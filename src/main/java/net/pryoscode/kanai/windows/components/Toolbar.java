package net.pryoscode.kanai.windows.components;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.pryoscode.kanai.windows.Settings;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class Toolbar extends HBox {

    public Toolbar(Stage stage) {
        Button settings = new Button();
        settings.setGraphic(new FontIcon(FontAwesomeSolid.COG));
        settings.setOnAction(event -> {
            Stage ss = new Settings();
            ss.initOwner(stage);
            ss.setX(stage.getX() + (stage.getWidth() - ss.getScene().getWidth()) / 2);
            ss.setY(stage.getY() + (stage.getHeight() - ss.getScene().getHeight()) / 2);
            ss.show();
        });
        getChildren().add(settings);
    }

}