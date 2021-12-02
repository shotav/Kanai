package net.pryoscode.kanai;

import java.net.URL;
import com.sun.javafx.application.PlatformImpl;
import javafx.application.Application;
import net.pryoscode.kanai.utils.StylesheetHandlerFactory;
import net.pryoscode.kanai.windows.Window;

public class Main {

    public static void main(String[] args) {
        PlatformImpl.startup(() -> {});
        URL.setURLStreamHandlerFactory(new StylesheetHandlerFactory());
        Updater.check();
        Application.launch(Window.class, args);
    }

}