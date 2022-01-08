package net.pryoscode.kanai.windows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.Loader;

public class Settings extends Stage {

    public Settings() {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 720, 640);
        setScene(scene);
        setTitle("Kanai Editor");
        getIcons().add(new Image(Loader.load("img/icon.png")));
        getScene().getStylesheets().add("styles:core");
        getScene().getStylesheets().add("styles:theme");
        initModality(Modality.WINDOW_MODAL);

        Label label = new Label("Settings");
        pane.setCenter(label);

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.BASELINE_RIGHT);
        pane.setBottom(buttons);
        Button ok = new Button("OK");
        Button apply = new Button("APPLY");
        Button cancel = new Button("CANCEL");
        ok.setOnAction(event -> {
            save();
            close();
        });
        apply.setOnAction(event -> save());
        cancel.setOnAction(event -> close());
        buttons.getChildren().addAll(ok, apply, cancel);
    }

    private void save() {}

}