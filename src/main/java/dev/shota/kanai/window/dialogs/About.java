package dev.shota.kanai.window.dialogs;

import dev.shota.kanai.window.utils.Language;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.SneakyThrows;
import lombok.val;
import java.util.Objects;

public class About extends Dialog {

    @SneakyThrows
    public About() {
        super(Language.get("help.about"), 200, 150);
        val root = new BorderPane();

        {
            val icon = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("icon/icon.png"));
            val image = new ImageView(new Image(icon));
            image.setPreserveRatio(true);
            image.setFitWidth(50);
            root.setLeft(image);
        }

        {
            val pane = new VBox();
            root.setCenter(pane);
            val title = new Label("Kanai Editor");
            title.setId("title");
            pane.getChildren().addAll(
                    title,
                    new Label("Version 0.0.0"),
                    new Label("Copyright 2021 shota")
            );
        }

        {
            val pane = new HBox();
            root.setBottom(pane);
            val github = new Button("GitHub");
            val ok = new Button("OK");
            ok.setOnAction(event -> dispose());
            pane.getChildren().addAll(github, ok);
        }

        setRoot(root);
    }

}