package net.pryoscode.kanai.windows.components;

import org.kordamp.ikonli.javafx.FontIcon;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.GUI;
import net.pryoscode.kanai.windows.tabs.SettingsTab;

public class Titlebar extends BorderPane {

    public Titlebar(Stage stage) {
        setMinHeight(32);
        setPrefHeight(32);
        setMaxHeight(32);
        setId("titlebar");

        HBox controls = new HBox();
        Button close = new Button();
        Button minimize = new Button();
        Button maximize = new Button();
        close.setFocusTraversable(false);
        minimize.setFocusTraversable(false);
        maximize.setFocusTraversable(false);
        close.setStyle("-fx-background-color: tomato;");
        minimize.setStyle("-fx-background-color: orange;");
        maximize.setStyle("-fx-background-color: palegreen;");
        close.setOnAction((e) -> Platform.exit());
        minimize.setOnAction((e) -> stage.setIconified(true));
        maximize.setOnAction((e) -> stage.setMaximized(!stage.isMaximized()));
        double size = getPrefHeight() / 2;
        GUI.setSize(close, size, size);
        GUI.setSize(minimize, size, size);
        GUI.setSize(maximize, size, size);
        controls.setId("controls");
        controls.getChildren().addAll(close, minimize, maximize);
        setLeft(controls);

        Button settings = new Button();
        settings.setGraphic(new FontIcon("fa-cog"));
        settings.setOnAction((e) -> Editor.open(new SettingsTab()));
        setRight(settings);
    }

}