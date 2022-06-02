package net.pryoscode.kanai.api;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Plugin {

    private static final List<JComponent> PANELS = new ArrayList<>();
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