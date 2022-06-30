package dev.shota.kanai.window.menu.edit;

import dev.shota.kanai.window.menu.edit.items.*;
import dev.shota.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class Edit extends JMenu {

    public Edit() {
        super(Language.get("edit"));
        setMnemonic(KeyEvent.VK_E);

        add(new Undo());
        add(new Redo());
        add(new JSeparator());
        add(new Cut());
        add(new Copy());
        add(new Paste());
        add(new Delete());
        add(new JSeparator());
        add(new Find());
        add(new Replace());
        add(new JSeparator());
        add(new FindFiles());
        add(new ReplaceFiles());
    }

}