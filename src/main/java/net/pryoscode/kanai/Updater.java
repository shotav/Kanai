package net.pryoscode.kanai;

import net.pryoscode.kanai.utils.Loader;
import javax.imageio.ImageIO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Updater {

    private Updater() {}

    public static void check() {
        new Thread(() -> {
            try {

                URL url = new URL("https://api.github.com/repos/PryosCode/Kanai/releases");
                Scanner scanner = new Scanner(url.openStream()).useDelimiter("\\A");
                String content = scanner.next();
                scanner.close();

                JsonArray array = new Gson().fromJson(content, JsonArray.class);
                if (array.size() == 0) return;

                JsonObject json = array.get(0).getAsJsonObject();
                if (json.get("tag_name").getAsString().equals("v" + Main.class.getPackage().getImplementationVersion())) return;

                URI uri = new URL(json.get("html_url").getAsString()).toURI();    
                TrayIcon icon = new TrayIcon(ImageIO.read(Loader.load("img/icon.png")), "Kanai Editor");
                icon.setImageAutoSize(true);
                SystemTray.getSystemTray().add(icon);
                Runtime.getRuntime().addShutdownHook(new Thread(() -> SystemTray.getSystemTray().remove(icon)));
                icon.addActionListener((e) -> {
                    try {
                        Desktop.getDesktop().browse(uri);
                    } catch (Exception ex) {
                        new Reporter(ex);
                    }
                });
                icon.displayMessage("Kanai Editor", "A new version is available to download.", TrayIcon.MessageType.INFO);

            } catch (UnknownHostException e) {
            } catch (Exception e) {
                new Reporter(e);
            }
        }).start();
    }

}