package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.reflection.Instance;
import dev.shota.kanai.window.Window;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import lombok.val;
import javax.swing.*;

public class Dialog extends JDialog {

    public Dialog(String title) {
        super(Instance.get(Window.class), title, true);
    }

    public void setRoot(Pane root) {
        val panel = new JFXPanel();
        panel.setScene(new Scene(root, root.getPrefWidth(), root.getPrefHeight()));
        add(panel);
        pack();
        setLocationRelativeTo(Instance.get(Window.class));
        setResizable(false);
        setVisible(true);
    }

}
