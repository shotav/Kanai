package dev.shota.kanai.plugin;

import dev.shota.kanai.code.Instance;
import dev.shota.kanai.window.Window;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;
import dev.shota.kanai.api.Plugin;
import dev.shota.kanai.code.Singleton;

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
        panelsField.set(null, new ArrayList<>());

        val panels = panelsField.get(null);
    }

}