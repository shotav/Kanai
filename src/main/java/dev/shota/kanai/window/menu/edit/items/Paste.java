package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Paste extends JMenuItem {

    public Paste() {
        super(Translation.get("edit.paste"), KeyEvent.VK_V);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}