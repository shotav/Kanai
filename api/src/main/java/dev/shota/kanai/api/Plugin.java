package dev.shota.kanai.api;

import javafx.scene.layout.Pane;
import lombok.Getter;
import javax.swing.*;
import java.util.List;

public class Plugin {

    private static List<Pane> PANES;
    @Getter private static JFrame WINDOW;

    public void onEnable() {}
    public void onDisable() {}

    public void addPane(Pane pane) {
        PANES.add(pane);
    }

}