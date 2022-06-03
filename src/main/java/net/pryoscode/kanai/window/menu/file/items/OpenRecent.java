package net.pryoscode.kanai.window.menu.file.items;

import net.pryoscode.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class OpenRecent extends JMenu {

    public OpenRecent() {
        super(Language.get("file.openRecent"));
        setMnemonic(KeyEvent.VK_O);
    }

}