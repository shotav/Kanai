package dev.shota.kanai;

import com.formdev.flatlaf.FlatDarkLaf;
import dev.shota.kanai.code.Instance;
import dev.shota.kanai.plugin.Plugins;
import dev.shota.kanai.window.Window;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
@UtilityClass
public class Main {

    public static void main(String[] args) {
        log.info("main");
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", "Kanai Editor");
        System.setProperty("apple.awt.application.appearance", "NSAppearanceNameDarkAqua");
        FlatDarkLaf.setup();

        val window = Instance.get(Window.class);
        Instance.get(Plugins.class);
        window.setVisible(true);
    }

}