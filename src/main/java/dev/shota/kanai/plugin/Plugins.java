package dev.shota.kanai.plugin;

import dev.shota.kanai.jvm.Instance;
import dev.shota.kanai.window.Window;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;
import dev.shota.kanai.api.Plugin;
import dev.shota.kanai.jvm.Singleton;
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

        val panesField = Plugin.class.getDeclaredField("PANES");
        panesField.setAccessible(true);
        panesField.set(null, new ArrayList<Pane>());

        val panes = ((List<?>) panesField.get(null)).stream().map(o -> (Pane) o).toList();
        Instance.get(Window.class).getSplitPane().getItems().addAll(panes);
    }

}