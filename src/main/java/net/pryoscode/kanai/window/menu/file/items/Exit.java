package net.pryoscode.kanai.window.menu.file.items;

import net.pryoscode.kanai.code.Instance;
import net.pryoscode.kanai.window.utils.Language;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit extends JMenuItem implements ActionListener {

    public Exit() {
        super(Language.get("file.exit"));

        if (Desktop.getDesktop().isSupported(Desktop.Action.APP_QUIT_HANDLER)) {
            Desktop.getDesktop().setQuitHandler((e, response) -> actionPerformed(null));
            setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Instance.get(Window.class).dispose();
    }

}