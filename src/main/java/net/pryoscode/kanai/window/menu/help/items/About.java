package net.pryoscode.kanai.window.menu.help.items;

import net.pryoscode.kanai.window.Language;
import javax.swing.*;

public class About extends JMenuItem {

    public About() {
        super(Language.get("help.about"));
    }

}