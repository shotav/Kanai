package net.pryoscode.kanai.windows.components;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Editor extends TabPane  {

    private static Editor instance;

    public Editor() {
        instance = this;
        setId("editor");
    }

    public static void open(Tab tab) {
        instance.getTabs().add(tab);
        instance.getSelectionModel().select(tab);
        tab.getTabPane().requestFocus();
    }

}