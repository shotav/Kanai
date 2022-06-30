package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Language;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Delete extends JMenuItem {

    public Delete() {
        super(Language.get("edit.delete"), KeyEvent.VK_DELETE);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
    }

}