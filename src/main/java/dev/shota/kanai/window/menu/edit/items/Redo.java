package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Redo extends JMenuItem {

    public Redo() {
        super(Translation.get("edit.redo"), KeyEvent.VK_Z);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.SHIFT_DOWN_MASK));
    }

}