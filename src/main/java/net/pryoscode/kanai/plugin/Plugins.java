package net.pryoscode.kanai.plugin;

import net.pryoscode.kanai.Reporter;
import net.pryoscode.kanai.config.Config;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.jar.JarFile;

public class Plugins {

    private static final File FOLDER = new File(Config.FOLDER + File.separator + "plugins");

    private Plugins() {}

    public static void load() {
        if (!FOLDER.exists()) FOLDER.mkdirs();
        if (FOLDER.isFile()) return;
        for (File file : FOLDER.listFiles()) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                try {
                    JarFile jar = new JarFile(file);
                    Properties properties = new Properties();
                    properties.load(jar.getInputStream(jar.getEntry("plugin.properties")));
                    URLClassLoader child = new URLClassLoader(new URL[] { new URL("file:///" + file.getPath()) }, Plugins.class.getClassLoader());
                    Class<?> clazz = Class.forName(properties.getProperty("main"), true, child);
                    Object object = clazz.getDeclaredConstructor().newInstance();
                    clazz.getMethod("onEnable").invoke(object);
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        try {
                            clazz.getMethod("onDisable").invoke(object);
                        } catch (Exception e) {
                            new Reporter(e);
                        }
                    }));
                } catch (Exception e) {
                    new Reporter(e);
                }
            }
        }
    }

}