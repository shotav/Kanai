package net.pryoscode.kanai;

import java.net.URL;
import com.sun.javafx.application.PlatformImpl;
import javafx.application.Platform;
import javafx.stage.Stage;
import net.pryoscode.kanai.config.Config;
import net.pryoscode.kanai.plugin.Plugins;
import net.pryoscode.kanai.utils.StylesheetHandlerFactory;
import net.pryoscode.kanai.windows.Window;

public class Main {

    public static void main(String[] args) {
        PlatformImpl.startup(() -> {});
        URL.setURLStreamHandlerFactory(new StylesheetHandlerFactory());
        Platform.runLater(() -> {
            Stage window = new Window();
            Config.init();
            Updater.init();
            Discord.init();
            Plugins.init();
            window.show();
        });
    }

}