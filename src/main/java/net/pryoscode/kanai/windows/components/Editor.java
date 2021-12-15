package net.pryoscode.kanai.windows.components;

import javafx.collections.ListChangeListener;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import net.pryoscode.kanai.utils.CustomTab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Editor extends TabPane  {

    private static final HashMap<String, Tab> tabs = new HashMap<>();
    private static Editor instance;

    public Editor() {
        instance = this;
        setTabDragPolicy(TabDragPolicy.REORDER);
    }

    public static void open(CustomTab tab) {
        open(tab.getIdentifier(), tab);
    }

    private static void open(String id, Tab tab) {
        if (!tabs.containsKey(id)) {
            instance.getTabs().add(tab);
            tabs.put(id, tab);
        }
        Tab current = tabs.get(id);

        ContextMenu menu = new ContextMenu();
        MenuItem close = new MenuItem("Close");
        MenuItem closeOther = new MenuItem("Close Others");
        closeOther.setDisable(instance.getTabs().size() == 1);
        instance.getTabs().addListener((ListChangeListener<Tab>) c -> closeOther.setDisable(instance.getTabs().size() == 1));
        MenuItem closeAll = new MenuItem("Close All");
        close.setOnAction(event -> {
            instance.getTabs().remove(current);
            tabs.remove(id);
        });
        closeOther.setOnAction(event ->  {
            Iterator<Map.Entry<String, Tab>> iterator = tabs.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Tab> entry = iterator.next();
                if (!entry.getKey().equals(id)) {
                    instance.getTabs().remove(entry.getValue());
                    iterator.remove();
                }
            }
        });
        closeAll.setOnAction(event ->  {
            Iterator<Map.Entry<String, Tab>> iterator = tabs.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Tab> entry = iterator.next();
                instance.getTabs().remove(entry.getValue());
                iterator.remove();
            }
        });
        menu.getItems().addAll(close, closeOther, closeAll);

        current.setContextMenu(menu);
        current.setOnClosed(event -> tabs.remove(id));
        instance.getSelectionModel().select(current);
        current.getTabPane().requestFocus();
    }

}