package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.reflection.Instance;
import dev.shota.kanai.window.utils.Language;
import dev.shota.kanai.window.Window;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import lombok.SneakyThrows;
import lombok.val;
import javax.swing.*;

public class About extends JDialog {

    @SneakyThrows
    public About() {
        super(Instance.get(Window.class), Language.get("help.about"), true);
        val panel = new JFXPanel();
        Pane root = new FXMLLoader().load(getClass().getClassLoader().getResourceAsStream("scenes/About.fxml"));
        panel.setScene(new Scene(root, 0,0));
        add(panel);
        setSize((int) root.getPrefWidth(), (int) root.getPrefHeight());
        setLocationRelativeTo(Instance.get(Window.class));
        setResizable(false);
        setVisible(true);
    }

}