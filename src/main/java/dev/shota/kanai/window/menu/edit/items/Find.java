package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Find extends JMenuItem {

    public Find() {
        super(Translation.get("edit.find"), KeyEvent.VK_F);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}