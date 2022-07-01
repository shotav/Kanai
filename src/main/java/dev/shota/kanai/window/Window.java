package dev.shota.kanai.window;

import com.formdev.flatlaf.util.SystemInfo;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import dev.shota.kanai.reflection.Singleton;
import dev.shota.kanai.window.menu.Menu;
import javax.swing.*;
import java.awt.*;

@Slf4j
@Singleton
public class Window extends JFrame {

    @SneakyThrows
    private Window() {
        log.info("init");

        val panel = new JFXPanel();
        val root = new SplitPane();
        panel.setScene(new Scene(root, 1280, 800));
        add(panel);

        if (SystemInfo.isMacOS && SystemInfo.isMacFullWindowContentSupported) {
            getRootPane().putClientProperty("apple.awt.fullWindowContent", true);
            getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
            getRootPane().putClientProperty("apple.awt.fullscreenable", true);
        }

        log.info("icon");
        val icon = new ImageIcon(getClass().getClassLoader().getResourceAsStream("icon/icon.png").readAllBytes()).getImage();
        if (Taskbar.isTaskbarSupported() && Taskbar.getTaskbar().isSupported(Taskbar.Feature.ICON_IMAGE)) Taskbar.getTaskbar().setIconImage(icon);
        setIconImage(icon);

        pack();
        setTitle("Kanai Editor");
        setJMenuBar(new Menu());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void dispose() {
        super.dispose();
        System.exit(0);
    }

}
