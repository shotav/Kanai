package dev.shota.kanai.window.menu.edit.items;

import dev.shota.kanai.window.utils.Translation;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Delete extends JMenuItem {

    public Delete() {
        super(Translation.get("edit.delete"), KeyEvent.VK_DELETE);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
    }

}