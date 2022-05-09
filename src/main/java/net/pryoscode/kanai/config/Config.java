package net.pryoscode.kanai.config;

import com.moandjiezana.toml.TomlWriter;
import net.pryoscode.kanai.Reporter;
import net.pryoscode.kanai.config.settings.Discord;
import net.pryoscode.kanai.config.settings.Theme;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Config {

    public static final File FOLDER = new File(System.getProperty("user.home") + File.separator + ".kanai");
    private static final File FILE = new File(FOLDER.getPath() + File.separator + "config.toml");
    private static final List<Setting<?>> settings = new ArrayList<>();

    private Config() {}

    public static void init() {
        setup();
        load();
    }

    private static void setup() {
        settings.add(new Theme());
        settings.add(new Discord());
    }

    private static void load() {
        if (!FILE.exists()) {
            try {
                HashMap<String, Object> config = new HashMap<>();
                for (Setting<?> setting : settings)
                    config.put(setting.getName(), setting.getValue());
                new TomlWriter().write(config, FILE);
            } catch (Exception e) {
                new Reporter(e);
            }
        }
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