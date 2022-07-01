package dev.shota.kanai.window.menu.file;

import dev.shota.kanai.window.menu.file.items.*;
import dev.shota.kanai.window.utils.Translation;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class File extends JMenu {

    public File() {
        super(Translation.get("file"));
        setMnemonic(KeyEvent.VK_F);

        add(new NewFile());
        add(new NewWindow());
        add(new JSeparator());
        add(new Open());
        add(new OpenFolder());
        add(new OpenRecent());
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
