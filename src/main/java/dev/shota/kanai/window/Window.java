package dev.shota.kanai.window;

import com.formdev.flatlaf.util.SystemInfo;
import dev.shota.kanai.jvm.Singleton;
import dev.shota.kanai.window.menu.Menu;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import javax.swing.*;
import java.awt.*;

@Slf4j
@Singleton
public class Window extends JFrame {

    @FXML public SplitPane splitPane;

    @SneakyThrows
    private Window() {
        log.info("init");

        val panel = new JFXPanel();
        val loader = new FXMLLoader();
        loader.setControllerFactory(param -> this);
        Pane root = loader.load(getClass().getClassLoader().getResourceAsStream("scenes/Window.fxml"));
        panel.setScene(new Scene(root, root.getPrefWidth(), root.getPrefHeight()));
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
