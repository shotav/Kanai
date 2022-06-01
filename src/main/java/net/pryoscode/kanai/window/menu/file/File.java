package net.pryoscode.kanai.window.menu.file;

import net.pryoscode.kanai.window.menu.file.items.OpenFile;
import javax.swing.*;

public class File extends JMenu {

    public File() {
        super("File");
        add(new OpenFile());
    }

}
