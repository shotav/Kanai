package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Undo extends JMenuItem {

    public Undo() {
        super(Language.get("edit.undo"), KeyEvent.VK_Z);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}