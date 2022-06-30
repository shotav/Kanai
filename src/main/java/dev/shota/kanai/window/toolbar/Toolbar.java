package dev.shota.kanai.window.toolbar;

import com.formdev.flatlaf.util.SystemInfo;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar() {
        if (SystemInfo.isMacOS)
            add(Box.createHorizontalStrut(70));

        add(new JLabel("Test"));
        add(Box.createHorizontalGlue());
        add(new JButton(IconFontSwing.buildIcon(FontAwesome.PLAY, UIManager.getFont("defaultFont").getSize(), UIManager.getColor("Button.foreground"))));
    }

}