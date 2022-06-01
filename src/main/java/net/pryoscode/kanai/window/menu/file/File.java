package net.pryoscode.kanai.window.menu.file;

import net.pryoscode.kanai.window.Language;
import net.pryoscode.kanai.window.menu.file.items.*;
import javax.swing.*;

public class File extends JMenu {

    public File() {
        super(Language.get("file"));
        add(new NewFile());
        add(new NewWindow());
        add(new JSeparator());
        add(new Open());
        add(new OpenFolder());
        add(new JSeparator());
        add(new Save());
        add(new SaveAs());
        add(new SaveAll());
        add(new JSeparator());
        add(new CloseFile());
        add(new CloseAllFiles());
        add(new CloseWindow());
        add(new JSeparator());
        add(new Exit());
    }

}
