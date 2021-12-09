package net.pryoscode.kanai.utils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import net.pryoscode.kanai.Reporter;

public class Loader {

    public Loader() {}

    public static InputStream load(String name) {
        return Loader.class.getClassLoader().getResourceAsStream(name);
    }

    public static String read(String name) {
        try {
            return new String(load(name).readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            new Reporter(e);
        }
        return null;
    }

}