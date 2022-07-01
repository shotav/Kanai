package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Undo extends JMenuItem {

    public Undo() {
        super(Translation.get("edit.undo"), KeyEvent.VK_Z);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}