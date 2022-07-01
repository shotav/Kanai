package dev.shota.kanai.example;

import dev.shota.kanai.api.Plugin;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import lombok.val;

public class Example extends Plugin {

    @Override
    public void onEnable() {
        val label = new Label("Hello World!");
        addPane(new BorderPane(label));
    }

}