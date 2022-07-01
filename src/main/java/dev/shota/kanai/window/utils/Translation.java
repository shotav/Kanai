package dev.shota.kanai.window.utils;

import lombok.experimental.UtilityClass;
import java.util.Locale;
import java.util.ResourceBundle;

@UtilityClass
public class Translation {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("translations/translation", Locale.getDefault());

    public static String get(String key) {
        return bundle.getString(key);
    }

}