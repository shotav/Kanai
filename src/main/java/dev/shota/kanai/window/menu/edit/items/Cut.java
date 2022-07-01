package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Cut extends JMenuItem {

    public Cut() {
        super(Translation.get("edit.cut"), KeyEvent.VK_X);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}