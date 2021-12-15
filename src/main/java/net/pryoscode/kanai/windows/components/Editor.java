package net.pryoscode.kanai.windows.components;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import net.pryoscode.kanai.utils.CustomTab;
import java.util.HashMap;

public class Editor extends TabPane  {

    private static final HashMap<String, Tab> tabs = new HashMap<>();
    private static Editor instance;

    public Editor() {
        instance = this;
    }

    public static void open(CustomTab tab) {
        open(tab.getIdentifier(), tab);
    }

    private static void open(String id, Tab tab) {
        if (!tabs.containsKey(id)) {
            instance.getTabs().add(tab);
            tabs.put(id, tab);
        }
        tabs.get(id).setOnClosed(event -> tabs.remove(id));
        instance.getSelectionModel().select(tabs.get(id));
        tabs.get(id).getTabPane().requestFocus();
    }

}