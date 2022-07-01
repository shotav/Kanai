package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FindFiles extends JMenuItem {

    public FindFiles() {
        super(Translation.get("edit.findFiles"), KeyEvent.VK_F);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.SHIFT_DOWN_MASK));
    }

}