package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class SaveAs extends JMenuItem {

    public SaveAs() {
        super(Translation.get("file.saveAs"), KeyEvent.VK_S);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + KeyEvent.SHIFT_DOWN_MASK));
    }

}