package net.pryoscode.kanai.sdk;

import javafx.stage.Stage;

public class Plugin {

    private static Stage WINDOW;

    public void onEnable() {}
    public void onDisable() {}

    public Stage getWindow() {
        return WINDOW;
    }

}