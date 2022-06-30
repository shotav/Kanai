package dev.shota.kanai.window;

import com.formdev.flatlaf.util.SystemInfo;
import dev.shota.kanai.window.editor.Editor;
import dev.shota.kanai.window.explorer.Explorer;
import dev.shota.kanai.window.toolbar.Toolbar;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import dev.shota.kanai.reflection.Instance;
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

        IconFontSwing.register(FontAwesome.getIconFont());
        val root = new JPanel(new BorderLayout());
        root.add(new Toolbar(), BorderLayout.PAGE_START);
        add(root);

        val splitPane = new JSplitPane();
        splitPane.setLeftComponent(Instance.get(Explorer.class));
        splitPane.setRightComponent(Instance.get(Editor.class));
        root.add(splitPane, BorderLayout.CENTER);

        if (SystemInfo.isMacFullWindowContentSupported) {
            getRootPane().putClientProperty("apple.awt.fullWindowContent", true);
            getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
            getRootPane().putClientProperty("apple.awt.fullscreenable", true);
        }

        log.info("icon");
        val icon = new ImageIcon(getClass().getClassLoader().getResourceAsStream("img/icon.png").readAllBytes()).getImage();
        if (Taskbar.getTaskbar().isSupported(Taskbar.Feature.ICON_IMAGE)) Taskbar.getTaskbar().setIconImage(icon);
        setIconImage(icon);

        setTitle("Kanai Editor");
        setJMenuBar(new Menu());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
    }

    @Override
    public void dispose() {
        super.dispose();
        System.exit(0);
    }

}
