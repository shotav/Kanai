package dev.shota.kanai.window.menu;

import dev.shota.kanai.window.menu.edit.Edit;
import dev.shota.kanai.window.menu.file.File;
import dev.shota.kanai.window.menu.help.Help;
import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu() {
        add(new File());
        add(new Edit());
        add(new Help());
    }

}