package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.reflection.Instance;
import dev.shota.kanai.window.utils.Language;
import dev.shota.kanai.window.Window;
import javax.swing.*;

public class About extends JDialog {

    public About() {
        super(Instance.get(Window.class), Language.get("help.about"), true);
        add(new JLabel("Kanai Editor"));
        pack();
        setLocationRelativeTo(Instance.get(Window.class));
        setResizable(false);
        setVisible(true);
    }

}