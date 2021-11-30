package net.pryoscode.kanai;

import java.net.URL;
import javafx.application.Application;
import net.pryoscode.kanai.utils.StylesheetHandlerFactory;
import net.pryoscode.kanai.windows.Window;

public class Main {

    public static void main(String[] args) {
        URL.setURLStreamHandlerFactory(new StylesheetHandlerFactory());
        Application.launch(Window.class, args);
    }

}