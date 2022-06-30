package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.code.Instance;
import dev.shota.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Exit extends JMenuItem implements ActionListener {

    public Exit() {
        super(Language.get("file.exit"), KeyEvent.VK_Q);
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