package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Find extends JMenuItem {

    public Find() {
        super(Language.get("edit.find"), KeyEvent.VK_F);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}