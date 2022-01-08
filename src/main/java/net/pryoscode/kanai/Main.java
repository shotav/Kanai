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
        URL.setURLStreamHandlerFactory(new StylesheetHandlerFactory());
        Config.init();
        Updater.init();
        Plugins.init();
        Discord.init();
        Application.launch(Window.class, args);
    }

}