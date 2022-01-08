package net.pryoscode.kanai.windows;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
        getScene().getStylesheets().add("styles:settings");
        getScene().getStylesheets().add("styles:theme");
        initModality(Modality.WINDOW_MODAL);
        setResizable(false);

        TabPane tabs = new TabPane();
        tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabs.setSide(Side.LEFT);
        pane.setCenter(tabs);

        for (int i = 1; i <= 10; i++)
            tabs.getTabs().add(new Tab("Test " + i, new Label("Test " + i)));

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.BASELINE_RIGHT);
        pane.setBottom(buttons);
        Button ok = new Button("OK");
        Button cancel = new Button("CANCEL");
        Button apply = new Button("APPLY");
        ok.setOnAction(event -> {
            save();
            close();
        });
        cancel.setOnAction(event -> close());
        apply.setOnAction(event -> save());
        buttons.getChildren().addAll(ok, cancel, apply);
    }

    private void save() {}

}