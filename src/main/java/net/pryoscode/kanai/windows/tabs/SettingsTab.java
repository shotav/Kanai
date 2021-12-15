package net.pryoscode.kanai.windows.tabs;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import net.pryoscode.kanai.utils.CustomTab;

public class SettingsTab extends CustomTab {
    
    public SettingsTab() {
        GridPane pane = new GridPane();
        setText("Settings");
        setContent(pane);

        ComboBox<String> theme = new ComboBox<>(FXCollections.observableArrayList("Default"));
        pane.addRow(0, new Label("Theme"), theme);
    }

    @Override
    public String getIdentifier() {
        return "kanai:settings";
    }

}