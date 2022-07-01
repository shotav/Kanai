package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.reflection.Instance;
import dev.shota.kanai.window.Window;
import dev.shota.kanai.window.utils.Language;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import lombok.SneakyThrows;
import lombok.val;
import javax.swing.*;
import java.util.Objects;

public class About extends JDialog {

    @SneakyThrows
    public About() {
        super(Instance.get(Window.class), Language.get("help.about"), true);
        val panel = new JFXPanel();
        val root = new BorderPane();

        {
            val icon = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("icon/icon.png"));
            val image = new ImageView(new Image(icon));
            image.setPreserveRatio(true);
            image.setFitWidth(50);
            root.setCenter(image);
        }

        panel.setScene(new Scene(root, 200, 150));
        add(panel);
        pack();
        setLocationRelativeTo(Instance.get(Window.class));
        setResizable(false);
        setVisible(true);
    }

}