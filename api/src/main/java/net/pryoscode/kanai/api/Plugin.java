package net.pryoscode.kanai.api;

import javax.swing.*;
import java.util.List;

public class Plugin {

    private static List<JComponent> PANELS;
    private static JFrame WINDOW;

    public void onEnable() {}
    public void onDisable() {}

    public void addPanel(JComponent component) {
        PANELS.add(component);
    }

    public JFrame getWindow() {
        return WINDOW;
    }

}