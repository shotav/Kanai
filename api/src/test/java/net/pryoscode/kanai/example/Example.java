package net.pryoscode.kanai.example;

import net.pryoscode.kanai.api.Plugin;
import javax.swing.*;

public class Example extends Plugin {

    @Override
    public void onEnable() {
        addPanel(new JLabel("Hello World!"));
    }

}