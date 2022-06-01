package net.pryoscode.kanai.window.menu;

import net.pryoscode.kanai.window.menu.file.File;
import net.pryoscode.kanai.window.menu.help.Help;
import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu() {
        add(new File());
        add(new Help());
    }

}