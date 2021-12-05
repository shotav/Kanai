package net.pryoscode.kanai;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.pryoscode.kanai.utils.Loader;

public class Reporter {
    
    public Reporter(Exception exception) {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.ERROR);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(Loader.load("img/icon.png")));
            alert.setTitle("Kanai Editor");
            alert.setHeaderText("An error occurred!");
            alert.setContentText(exception.getMessage());

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);

            TextArea textArea = new TextArea(sw.toString());
            textArea.setEditable(false);
            alert.getDialogPane().setExpandableContent(new BorderPane(textArea));

            ButtonType github = new ButtonType("New issue", ButtonData.OK_DONE);
            alert.getDialogPane().getButtonTypes().setAll(github, ButtonType.CANCEL);

            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(github)) {
                try {
                    String title = URLEncoder.encode(exception.getMessage(), StandardCharsets.UTF_8.toString());
                    String body = URLEncoder.encode("\u0060\u0060\u0060\n" + sw.toString() + "\u0060\u0060\u0060\n", StandardCharsets.UTF_8.toString());
                    String url = String.format("https://github.com/PryosCode/Kanai/issues/new?title=%s&body=%s&labels=bug", title, body);
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception e) {}
            }
        });
    }
    
}