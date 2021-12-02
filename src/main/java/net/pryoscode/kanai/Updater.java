package net.pryoscode.kanai;

import java.net.URL;
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
                System.out.println(content);
            } catch (Exception e) {
                new Reporter(e);
            }
        }).start();
    }
    
}