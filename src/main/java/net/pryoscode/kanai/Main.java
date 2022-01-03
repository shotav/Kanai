package net.pryoscode.kanai;

import java.net.URL;
import com.sun.javafx.application.PlatformImpl;
import javafx.application.Application;
import net.pryoscode.kanai.config.Config;
import net.pryoscode.kanai.plugin.Plugins;
import net.pryoscode.kanai.utils.StylesheetHandlerFactory;
import net.pryoscode.kanai.windows.Window;

public class Main {

    public static void main(String[] args) {
        PlatformImpl.startup(() -> {});
        Config.setup();
        URL.setURLStreamHandlerFactory(new StylesheetHandlerFactory());
        Updater.check();
        Plugins.load();
        Discord.start();
        Application.launch(Window.class, args);
    }

}