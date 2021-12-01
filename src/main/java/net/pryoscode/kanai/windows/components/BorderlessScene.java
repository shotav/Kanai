package net.pryoscode.kanai.windows.components;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BorderlessScene extends Scene {

    public BorderlessScene(Stage stage, Parent root, double width, double height) {
        super(root, width, height);
        stage.initStyle(StageStyle.UNDECORATED);
    }

}