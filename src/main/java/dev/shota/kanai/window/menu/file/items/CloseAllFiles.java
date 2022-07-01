package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CloseAllFiles extends JMenuItem {

    public CloseAllFiles() {
        super(Translation.get("file.closeAllFiles"), KeyEvent.VK_W);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.ALT_DOWN_MASK));
    }

}