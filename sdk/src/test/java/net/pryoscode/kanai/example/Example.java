package net.pryoscode.kanai.example;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.pryoscode.kanai.sdk.Plugin;

public class Example extends Plugin {

    @Override
    public void onEnable() {
        getWindow().setOnShown(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().addAll(getWindow().getIcons());
            alert.initModality(Modality.WINDOW_MODAL);
            alert.initOwner(getWindow());
            alert.setTitle(getWindow().getTitle());
            alert.setHeaderText("Example");
            alert.setContentText("Plugin successfully loaded!");
            alert.show();
        });
    }

}