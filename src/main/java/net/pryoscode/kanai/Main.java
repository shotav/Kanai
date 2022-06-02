package net.pryoscode.kanai;

import com.formdev.flatlaf.FlatDarkLaf;
import lombok.experimental.UtilityClass;
import net.pryoscode.kanai.code.Instance;
import net.pryoscode.kanai.window.Window;

@UtilityClass
public class Main {

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", "Kanai Editor");
        System.setProperty("apple.awt.application.appearance", "NSAppearanceNameDarkAqua");

        FlatDarkLaf.setup();
        Instance.get(Window.class).setVisible(true);
    }

}