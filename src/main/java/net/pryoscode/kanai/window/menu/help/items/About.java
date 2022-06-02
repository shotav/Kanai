package net.pryoscode.kanai.window.menu.help.items;

import net.pryoscode.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JMenuItem implements ActionListener {

    public About() {
        super(Language.get("help.about"));
        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new net.pryoscode.kanai.window.dialogs.About();
    }

}