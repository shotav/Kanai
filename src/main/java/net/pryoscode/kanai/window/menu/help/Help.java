package net.pryoscode.kanai.window.menu.help;

import net.pryoscode.kanai.window.Language;
import net.pryoscode.kanai.window.menu.help.items.About;
import javax.swing.*;

public class Help extends JMenu {

    public Help() {
        super(Language.get("help"));
        add(new About());
    }

}