package net.pryoscode.kanai.window.menu.edit;

import net.pryoscode.kanai.window.menu.edit.items.*;
import net.pryoscode.kanai.window.utils.Language;
import javax.swing.*;

public class Edit extends JMenu {

    public Edit() {
        super(Language.get("edit"));
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
    }

}