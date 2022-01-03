package net.pryoscode.kanai.windows.tabs;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import net.pryoscode.kanai.config.Config;
import net.pryoscode.kanai.config.Setting;
import net.pryoscode.kanai.utils.CustomTab;

public class SettingsTab extends CustomTab {
    
    public SettingsTab() {
        GridPane pane = new GridPane();
        setText("Settings");
        setContent(pane);

        for (int i = 0; i < Config.getSettings().size(); i++) {
            Setting<?> setting = Config.getSettings().get(i);
            Control control = null;
            if (setting.getValue() instanceof String) {
                control = new TextField((String) setting.getValue());
            } else if (setting.getValue() instanceof Boolean) {
                control = new CheckBox();
                ((CheckBox) control).setSelected((boolean) setting.getValue());
            }
            pane.addRow(i, new Label(setting.getName()), control);
        }
    }

    @Override
    public String getIdentifier() {
        return "kanai:settings";
    }

}