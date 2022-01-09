package net.pryoscode.kanai.plugin;

import net.pryoscode.kanai.Reporter;
import net.pryoscode.kanai.config.Config;
import net.pryoscode.kanai.sdk.Plugin;
import net.pryoscode.kanai.windows.Window;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class Plugins {

    private static final File FOLDER = new File(Config.FOLDER + File.separator + "plugins");

    private Plugins() {}

    public static void init() {
        if (!FOLDER.exists()) FOLDER.mkdirs();
        if (FOLDER.isFile()) return;

        try {
            Field window = Plugin.class.getDeclaredField("WINDOW");
            window.setAccessible(true);
            window.set(null, Window.getStage());
        } catch (Exception e) {
            new Reporter(e);
        }

        for (File file : FOLDER.listFiles()) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                try {
                    JarFile jar = new JarFile(file);
                    ZipEntry entry = jar.getEntry("plugin.properties");
                    if (entry == null) continue;
                    Properties properties = new Properties();
                    properties.load(jar.getInputStream(jar.getEntry("plugin.properties")));
                    URLClassLoader child = new URLClassLoader(new URL[] { new URL("file:///" + file.getPath()) }, Plugins.class.getClassLoader());
                    Class<?> clazz = Class.forName(properties.getProperty("main"), true, child);
                    Object object = clazz.getDeclaredConstructor().newInstance();
                    if (!(object instanceof Plugin)) continue;
                    try {
                        clazz.getMethod("onEnable").invoke(object);
                    } catch (NoSuchMethodException ignored) {}
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        try {
                            clazz.getMethod("onDisable").invoke(object);
                        } catch (NoSuchMethodException ignored) {
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