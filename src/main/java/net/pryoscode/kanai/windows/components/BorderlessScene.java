package net.pryoscode.kanai.windows.components;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BorderlessScene extends Scene {

    private final Stage stage;
    private double x;
    private double y;

    public BorderlessScene(Stage stage, Parent root, double width, double height) {
        super(new Pane(), width, height);
        this.stage = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        AnchorPane pane = new AnchorPane();
        setRoot(pane);

        pane.getChildren().add(root);
        AnchorPane.setTopAnchor(root, 0d);
        AnchorPane.setRightAnchor(root, 0d);
        AnchorPane.setBottomAnchor(root, 0d);
        AnchorPane.setLeftAnchor(root, 0d);

        Pane n = new Pane();
        n.setPrefHeight(5);
        n.setCursor(Cursor.N_RESIZE);
        pane.getChildren().add(n);
        AnchorPane.setTopAnchor(n, 0d);
        AnchorPane.setRightAnchor(n, 5d);
        AnchorPane.setLeftAnchor(n, 5d);
        n.setOnMouseDragged(this::topDragged);

        Pane ne = new Pane();
        ne.setPrefHeight(5);
        ne.setPrefWidth(5);
        ne.setCursor(Cursor.NE_RESIZE);
        pane.getChildren().add(ne);
        AnchorPane.setTopAnchor(ne, 0d);
        AnchorPane.setRightAnchor(ne, 0d);
        ne.setOnMouseDragged((event) -> {
            topDragged(event);
            rightDragged(event);
        });

        Pane e = new Pane();
        e.setPrefWidth(5);
        e.setCursor(Cursor.E_RESIZE);
        pane.getChildren().add(e);
        AnchorPane.setTopAnchor(e, 5d);
        AnchorPane.setRightAnchor(e, 0d);
        AnchorPane.setBottomAnchor(e, 5d);
        e.setOnMouseDragged(this::rightDragged);

        Pane se = new Pane();
        se.setPrefHeight(5);
        se.setPrefWidth(5);
        se.setCursor(Cursor.SE_RESIZE);
        pane.getChildren().add(se);
        AnchorPane.setRightAnchor(se, 0d);
        AnchorPane.setBottomAnchor(se, 0d);
        se.setOnMouseDragged((event) -> {
            rightDragged(event);
            bottomDragged(event);
        });

        Pane s = new Pane();
        s.setPrefHeight(5);
        s.setCursor(Cursor.S_RESIZE);
        pane.getChildren().add(s);
        AnchorPane.setRightAnchor(s, 5d);
        AnchorPane.setBottomAnchor(s, 0d);
        AnchorPane.setLeftAnchor(s, 5d);
        s.setOnMouseDragged(this::bottomDragged);
     
        Pane sw = new Pane();
        sw.setPrefHeight(5);
        sw.setPrefWidth(5);
        sw.setCursor(Cursor.SW_RESIZE);
        pane.getChildren().add(sw);
        AnchorPane.setBottomAnchor(sw, 0d);
        AnchorPane.setLeftAnchor(sw, 0d);
        sw.setOnMouseDragged((event) -> {
            bottomDragged(event);
            leftDragged(event);
        });

        Pane w = new Pane();
        w.setPrefWidth(5);
        w.setCursor(Cursor.W_RESIZE);
        pane.getChildren().add(w);
        AnchorPane.setTopAnchor(w, 5d);
        AnchorPane.setBottomAnchor(w, 5d);
        AnchorPane.setLeftAnchor(w, 0d);
        w.setOnMouseDragged(this::leftDragged);

        Pane nw = new Pane();
        nw.setPrefHeight(5);
        nw.setPrefWidth(5);
        nw.setCursor(Cursor.NW_RESIZE);
        pane.getChildren().add(nw);
        AnchorPane.setTopAnchor(nw, 0d);
        AnchorPane.setLeftAnchor(nw, 0d);
        nw.setOnMouseDragged((event) -> {
            topDragged(event);
            leftDragged(event);
        });

        stage.maximizedProperty().addListener((o, ov, nv) -> {
            n.setDisable(nv);
            ne.setDisable(nv);
            e.setDisable(nv);
            se.setDisable(nv);
            s.setDisable(nv);
            sw.setDisable(nv);
            w.setDisable(nv);
            nw.setDisable(nv);
        });
    }

    public void setDraggable(Region region) {
        region.setOnMousePressed(this::onMousePressed);
        region.setOnMouseDragged(this::onMouseDragged);
        region.setOnMouseClicked(this::onMouseClicked);
    }

    private void onMousePressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    private void onMouseDragged(MouseEvent event) {
        if (stage.isMaximized()) stage.setMaximized(false);
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    private void onMouseClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2)
            stage.setMaximized(!stage.isMaximized());
    }

    private void topDragged(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            if (stage.getHeight() > stage.getMinHeight() || event.getY() < 0) {
                stage.setHeight(stage.getHeight() - event.getScreenY() + stage.getY());
                stage.setY(event.getScreenY());
            }
        }
    }
    
    private void rightDragged(MouseEvent event) {
        if (event.isPrimaryButtonDown())
            if (stage.getWidth() > stage.getMinWidth() || event.getX() > 0)
                stage.setWidth(stage.getWidth() + event.getX());
    }

    private void bottomDragged(MouseEvent event) {
        if (event.isPrimaryButtonDown()) 
            if (stage.getHeight() > stage.getMinHeight() || event.getY() > 0)
                stage.setHeight(stage.getHeight() + event.getY());
    }

    private void leftDragged(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            if (stage.getWidth() > stage.getMinWidth() || event.getX() < 0) {
                stage.setWidth(stage.getWidth() - event.getScreenX() + stage.getX());
                stage.setX(event.getScreenX());
            }
        }
    }

}