package net.pryoscode.kanai.windows.components;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BorderlessScene extends Scene {

    public BorderlessScene(Stage stage, Parent root, double width, double height) {
        super(new Pane(), width, height);
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

        Pane ne = new Pane();
        ne.setPrefHeight(5);
        ne.setPrefWidth(5);
        ne.setCursor(Cursor.NE_RESIZE);
        pane.getChildren().add(ne);
        AnchorPane.setTopAnchor(ne, 0d);
        AnchorPane.setRightAnchor(ne, 0d);

        Pane e = new Pane();
        e.setPrefWidth(5);
        e.setCursor(Cursor.E_RESIZE);
        pane.getChildren().add(e);
        AnchorPane.setTopAnchor(e, 5d);
        AnchorPane.setRightAnchor(e, 0d);
        AnchorPane.setBottomAnchor(e, 5d);

        Pane se = new Pane();
        se.setPrefHeight(5);
        se.setPrefWidth(5);
        se.setCursor(Cursor.SE_RESIZE);
        pane.getChildren().add(se);
        AnchorPane.setRightAnchor(se, 0d);
        AnchorPane.setBottomAnchor(se, 0d);

        Pane s = new Pane();
        s.setPrefHeight(5);
        s.setCursor(Cursor.S_RESIZE);
        pane.getChildren().add(s);
        AnchorPane.setRightAnchor(s, 5d);
        AnchorPane.setBottomAnchor(s, 0d);
        AnchorPane.setLeftAnchor(s, 5d);
     
        Pane sw = new Pane();
        sw.setPrefHeight(5);
        sw.setPrefWidth(5);
        sw.setCursor(Cursor.SW_RESIZE);
        pane.getChildren().add(sw);
        AnchorPane.setBottomAnchor(sw, 0d);
        AnchorPane.setLeftAnchor(sw, 0d);

        Pane w = new Pane();
        w.setPrefWidth(5);
        w.setCursor(Cursor.W_RESIZE);
        pane.getChildren().add(w);
        AnchorPane.setTopAnchor(w, 5d);
        AnchorPane.setBottomAnchor(w, 5d);
        AnchorPane.setLeftAnchor(w, 0d);

        Pane nw = new Pane();
        nw.setPrefHeight(5);
        nw.setPrefWidth(5);
        nw.setCursor(Cursor.NW_RESIZE);
        pane.getChildren().add(nw);
        AnchorPane.setTopAnchor(nw, 0d);
        AnchorPane.setLeftAnchor(nw, 0d);

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

}