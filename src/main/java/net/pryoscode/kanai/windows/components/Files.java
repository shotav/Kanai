package net.pryoscode.kanai.windows.components;

import java.io.File;
import java.nio.file.Paths;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Files extends TreeView<String> {
    
    public Files() {
        TreeItem<String> files = new TreeItem<>();

        for (File file : new File(Paths.get("").toAbsolutePath().toString()).listFiles())
            files.getChildren().add(new FileItem(file));

        setRoot(files);
        setShowRoot(false);
        setId("files");
    }

    private class FileItem extends TreeItem<String> {

        private final File file;

        public FileItem(File file) {
            super(file.getName());
            this.file = file;
        }

        @Override
        public boolean isLeaf() {
            return !file.isDirectory();
        }

    }

}