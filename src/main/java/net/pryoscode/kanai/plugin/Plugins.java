package net.pryoscode.kanai.plugin;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;
import net.pryoscode.kanai.api.Plugin;
import net.pryoscode.kanai.code.Instance;
import net.pryoscode.kanai.code.Singleton;
import net.pryoscode.kanai.window.Window;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Plugins {

    @Getter private final List<Plugin> plugins = new ArrayList<>();

    @SneakyThrows
    private Plugins() {
        val window = Plugin.class.getDeclaredField("WINDOW");
        window.setAccessible(true);
        window.set(null, Instance.get(Window.class));

        val panelsField = Plugin.class.getDeclaredField("PANELS");
        panelsField.setAccessible(true);
        val panels = panelsField.get(null);
    }

}