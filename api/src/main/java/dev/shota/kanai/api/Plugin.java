package dev.shota.kanai.api;

import javax.swing.*;
import java.util.List;

public class Plugin {

    private static List<JPanel> PANELS;
    private static JFrame WINDOW;

    public void onEnable() {}
    public void onDisable() {}

    public void addPanel(JPanel panel) {
        PANELS.add(panel);
    }

    public JFrame getWindow() {
        return WINDOW;
    }

}