package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class NewWindow extends JMenuItem {

    public NewWindow() {
        super(Translation.get("file.newWindow"), KeyEvent.VK_N);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.SHIFT_DOWN_MASK));
    }

}