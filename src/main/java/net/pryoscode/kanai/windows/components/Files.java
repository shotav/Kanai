package net.pryoscode.kanai.windows.components;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Files extends TreeView<String> {
    
    public Files() {
        setRoot(new FileItem(new File(Paths.get("").toAbsolutePath().toString())));
        setShowRoot(false);
        setId("files");
    }

    private class FileItem extends TreeItem<String> {

        private final File file;

        public FileItem(File file) {
            super(file.getName());
            this.file = file;

            if (file.isDirectory()) {
                List<File> files = Arrays.asList(file.listFiles());
                Collections.sort(files, new Comparator<File>() {
                    @Override
                    public int compare(File f1, File f2) {
                        return f1.isDirectory() && !f2.isDirectory() ? -1 : 1;
                    }
                });
                for (File f : files)
                    getChildren().add(new FileItem(f));
            }
        }

        @Override
        public boolean isLeaf() {
            return !file.isDirectory();
        }

    }

}