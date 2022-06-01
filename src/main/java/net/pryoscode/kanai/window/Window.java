package net.pryoscode.kanai.window;

import com.formdev.flatlaf.util.SystemInfo;
import lombok.SneakyThrows;
import lombok.val;
import net.pryoscode.kanai.boilerplate.Singleton;
import net.pryoscode.kanai.window.menu.Menu;
import javax.swing.*;
import java.awt.*;

@Singleton
public class Window extends JFrame {

    @SneakyThrows
    public Window() {
        if (SystemInfo.isMacFullWindowContentSupported ) {
            getRootPane().putClientProperty("apple.awt.fullWindowContent", true);
            getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
            getRootPane().putClientProperty("apple.awt.fullscreenable", true);
        }

        val icon = new ImageIcon(getClass().getClassLoader().getResourceAsStream("img/icon.png").readAllBytes()).getImage();
        if (Taskbar.getTaskbar().isSupported(Taskbar.Feature.ICON_IMAGE)) Taskbar.getTaskbar().setIconImage(icon);
        setIconImage(icon);

        setTitle("Kanai Editor");
        setJMenuBar(new Menu());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
    }

}
