package net.pryoscode.kanai.window;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("language", Locale.getDefault());

    public static String get(String key) {
        return bundle.getString(key);
    }

}