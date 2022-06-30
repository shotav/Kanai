package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class SaveAll extends JMenuItem {

    public SaveAll() {
        super(Language.get("file.saveAll"), KeyEvent.VK_S);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.ALT_DOWN_MASK));
    }

}