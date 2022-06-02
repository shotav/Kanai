package net.pryoscode.kanai.window.menu.help;

import net.pryoscode.kanai.window.utils.Language;
import net.pryoscode.kanai.window.menu.help.items.About;
import javax.swing.*;
import java.awt.*;

public class Help extends JMenu {

    public Help() {
        super(Language.get("help"));
        add(new About());

        if (Desktop.getDesktop().isSupported(Desktop.Action.APP_ABOUT))
            setVisible(false);
    }

}