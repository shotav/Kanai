package dev.shota.kanai.window.menu.help;

import dev.shota.kanai.window.utils.Translation;
import dev.shota.kanai.window.menu.help.items.About;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Help extends JMenu {

    public Help() {
        super(Translation.get("help"));
        setMnemonic(KeyEvent.VK_H);

        setVisible(!Desktop.getDesktop().isSupported(Desktop.Action.APP_ABOUT));
        add(new About());
    }

}