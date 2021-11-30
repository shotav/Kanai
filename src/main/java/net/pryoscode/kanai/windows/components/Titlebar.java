package net.pryoscode.kanai.windows.components;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.GUI;
import net.pryoscode.kanai.utils.Loader;

public class Titlebar extends BorderPane {

    private Label title;
    private double x;
    private double y;

    public Titlebar(Stage stage) {
        ImageView icon = new ImageView(new Image(Loader.load("img/icon.png")));
        title = new Label();
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
        minimize.setStyle("-fx-background-color: palegreen;");
        maximize.setStyle("-fx-background-color: orange;");
        close.setStyle("-fx-background-color: tomato;");
        minimize.setOnAction(this::onMinimizeClick);
        maximize.setOnAction(this::onMaximizeClick);
        close.setOnAction(this::onCloseClick);
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
    }

    private void onMinimizeClick(ActionEvent event) {
        Stage stage = (Stage) getScene().getWindow();
        stage.setIconified(true);
    }

    private void onMaximizeClick(ActionEvent event) {
        Stage stage = (Stage) getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    private void onCloseClick(ActionEvent event) {
        Stage stage = (Stage) getScene().getWindow();
        stage.hide();
        System.exit(0);
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

    public void setTitle(String text) {
        title.setText(text);
    }
   
}