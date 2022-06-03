package net.pryoscode.kanai.window.menu.edit.items;

import net.pryoscode.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Paste extends JMenuItem {

    public Paste() {
        super(Language.get("edit.paste"), KeyEvent.VK_V);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}