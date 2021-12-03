package net.pryoscode.kanai.windows.components;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.GUI;
import net.pryoscode.kanai.utils.Loader;

public class Titlebar extends BorderPane {

    private double x;
    private double y;

    public Titlebar(Stage stage) {
        ImageView icon = new ImageView(new Image(Loader.load("img/icon.png")));
        Label title = new Label();
        setMinHeight(32);
        setPrefHeight(32);
        setMaxHeight(32);
        icon.setFitHeight(getPrefHeight());
        icon.setPreserveRatio(true);
        title.setPrefHeight(getPrefHeight());
        title.textProperty().bind(stage.titleProperty());

        HBox controls = new HBox();
        Button minimize = new Button();
        Button maximize = new Button();
        Button close = new Button();
        minimize.setFocusTraversable(false);
        minimize.setFocusTraversable(false);
        close.setFocusTraversable(false);
        minimize.setStyle("-fx-background-color: palegreen;");
        maximize.setStyle("-fx-background-color: orange;");
        close.setStyle("-fx-background-color: tomato;");
        minimize.setOnAction((e) -> stage.setIconified(true));
        maximize.setOnAction((e) -> stage.setMaximized(!stage.isMaximized()));
        close.setOnAction((e) -> Platform.exit());
        double size = getPrefHeight() / 2;
        GUI.setSize(minimize, size, size);
        GUI.setSize(maximize, size, size);
        GUI.setSize(close, size, size);
        controls.setId("controls");
        controls.getChildren().addAll(minimize, maximize, close);

        setLeft(icon);
        setCenter(title);
        setRight(controls);
        setId("titlebar");
        setOnMousePressed(this::onMousePressed);
        setOnMouseDragged(this::onMouseDragged);
        setOnMouseClicked(this::onMouseClicked);
    }

    private void onMousePressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    private void onMouseDragged(MouseEvent event) {
        Stage stage = (Stage) getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    private void onMouseClicked(MouseEvent event) {
        Stage stage = ((Stage) getScene().getWindow());
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2)
            stage.setMaximized(!stage.isMaximized());
    }

}