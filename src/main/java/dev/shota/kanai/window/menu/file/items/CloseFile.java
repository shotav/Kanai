package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CloseFile extends JMenuItem {

    public CloseFile() {
        super(Translation.get("file.closeFile"), KeyEvent.VK_W);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

}