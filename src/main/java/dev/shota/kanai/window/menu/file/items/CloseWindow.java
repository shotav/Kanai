package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CloseWindow extends JMenuItem {

    public CloseWindow() {
        super(Translation.get("file.closeWindow"), KeyEvent.VK_W);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.SHIFT_DOWN_MASK));
    }

}