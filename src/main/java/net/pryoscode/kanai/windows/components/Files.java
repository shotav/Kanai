package net.pryoscode.kanai.windows.components;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Files extends TreeView<String> {

    public Files(File directory) {
        setRoot(new FileItem(directory));
        setShowRoot(false);
        setId("files");
    }

    private static class FileItem extends TreeItem<String> {

        private final File file;

        public FileItem(File file) {
            super(file.getName());
            this.file = file;

            if (file.isDirectory()) {
                List<File> files = Arrays.asList(file.listFiles());
                files.sort((f1, f2) -> f1.isDirectory() && !f2.isDirectory() ? -1 : 1);
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