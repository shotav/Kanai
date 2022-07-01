package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.reflection.Instance;
import dev.shota.kanai.window.Window;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import lombok.val;
import javax.swing.*;

public class Dialog extends JDialog {

    private final int width;
    private final int height;

    public Dialog(String title, int width, int height) {
        super(Instance.get(Window.class), title, true);
        this.width = width;
        this.height = height;
    }

    public void setRoot(Pane root) {
        val panel = new JFXPanel();
        panel.setScene(new Scene(root, width, height));
        add(panel);
        pack();
        setLocationRelativeTo(Instance.get(Window.class));
        setResizable(false);
        setVisible(true);
    }

}
