package dev.shota.kanai.window.menu.file.items;

import dev.shota.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class OpenRecent extends JMenu {

    public OpenRecent() {
        super(Language.get("file.openRecent"));
        setMnemonic(KeyEvent.VK_O);
    }

}