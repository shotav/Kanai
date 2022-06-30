package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ReplaceFiles extends JMenuItem {

    public ReplaceFiles() {
        super(Language.get("edit.replaceFiles"), KeyEvent.VK_F);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.SHIFT_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
    }

}