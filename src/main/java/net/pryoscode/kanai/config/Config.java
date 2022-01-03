package net.pryoscode.kanai.config;

import net.pryoscode.kanai.config.settings.Discord;
import net.pryoscode.kanai.config.settings.Theme;
import java.util.ArrayList;
import java.util.List;

public class Config {

    private static final List<Setting<?>> settings = new ArrayList<>();

    private Config() {}

    public static void setup() {
        settings.add(new Theme());
        settings.add(new Discord());
    }

    public static <T> T getSetting(Class<?> clazz) {
        for (Setting<?> setting : settings)
            if (clazz.isInstance(setting))
                return (T) setting.getValue();
        return null;
    }

    public static List<Setting<?>> getSettings() {
        return settings;
    }

}