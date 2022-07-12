package dev.shota.kanai.window.editor;

import dev.shota.kanai.jvm.Singleton;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;
import lombok.Getter;
import lombok.SneakyThrows;
import java.util.Objects;

@Singleton
public class Editor {

    @Getter private final TabPane root;

    @SneakyThrows
    private Editor() {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("scenes/components/Editor.fxml")));
    }

}