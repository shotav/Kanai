package dev.shota.kanai.window.utils;

import lombok.experimental.UtilityClass;
import java.util.Locale;
import java.util.ResourceBundle;

@UtilityClass
public class Language {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("langs/language", Locale.getDefault());

    public static String get(String key) {
        return bundle.getString(key);
    }

}