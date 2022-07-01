package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Copy extends JMenuItem {

    public Copy() {
        super(Translation.get("edit.copy"), KeyEvent.VK_C);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}