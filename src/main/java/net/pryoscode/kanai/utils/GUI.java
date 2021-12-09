package net.pryoscode.kanai.utils;

import javafx.scene.layout.Region;

public class GUI {

    private GUI() {}

    public static void setSize(Region region, double width, double height) {
        region.setMinSize(width, height);
        region.setPrefSize(width, height);
        region.setMaxSize(width, height);
    }

}