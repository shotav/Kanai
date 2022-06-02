package net.pryoscode.kanai.window.dialogs;

import net.pryoscode.kanai.code.Instance;
import net.pryoscode.kanai.window.utils.Language;
import net.pryoscode.kanai.window.Window;
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