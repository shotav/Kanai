package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.jvm.Instance;
import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Exit extends JMenuItem implements ActionListener {

    public Exit() {
        super(Translation.get("file.exit"), KeyEvent.VK_Q);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        if (Desktop.getDesktop().isSupported(Desktop.Action.APP_QUIT_HANDLER)) {
            Desktop.getDesktop().setQuitHandler((e, response) -> actionPerformed(null));
            setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Instance.get(Window.class).dispose();
    }

}