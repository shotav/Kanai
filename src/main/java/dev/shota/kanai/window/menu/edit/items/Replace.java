package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Replace extends JMenuItem {

    public Replace() {
        super(Language.get("edit.replace"), KeyEvent.VK_F);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.ALT_DOWN_MASK));
    }

}