package net.pryoscode.kanai.windows.components;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import net.pryoscode.kanai.windows.tabs.CodeTab;

public class Files extends TreeView<File> {

    public Files(File directory) {
        setRoot(new FileItem(directory));
        setShowRoot(false);
        setCellFactory(param -> new FileCell());
    }

    private static class FileItem extends TreeItem<File> {

        public FileItem(File file) {
            setValue(file);
            if (file.isDirectory()) {
                List<File> files = Arrays.asList(file.listFiles());
                files.sort((f1, f2) -> f1.isDirectory() && !f2.isDirectory() ? -1 : 1);
                for (File f : files)
                    getChildren().add(new FileItem(f));
            }
        }

        @Override
        public boolean isLeaf() {
            return !getValue().isDirectory();
        }

    }

    private static class FileCell extends TreeCell<File> {

        public FileCell() {
            addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMouseClicked);
        }

        @Override
        protected void updateItem(File item, boolean empty) {
            super.updateItem(item, empty);
            if (empty)
                setText("");
            else
                setText(item.getName());
        }

        private void onMouseClicked(MouseEvent event) {
            if (getTreeItem() == null)
                return;

            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2 && !getTreeItem().getValue().isDirectory())
                    Editor.open(new CodeTab(getTreeItem().getValue()));
            } else if (event.getButton().equals(MouseButton.SECONDARY)) {
                ContextMenu menu = new ContextMenu();

                if (getTreeItem().getValue().isDirectory()) {
                    Menu newMenu = new Menu("New");
                    MenuItem file = new MenuItem("File");
                    MenuItem directory = new MenuItem("Directory");
                    newMenu.getItems().addAll(file, directory);
                    menu.getItems().add(newMenu);
                } else {
                    MenuItem open = new MenuItem("Open");
                    open.setOnAction(event12 -> Editor.open(new CodeTab(getTreeItem().getValue())));
                    menu.getItems().add(open);
                }
                menu.getItems().add(new SeparatorMenuItem());

                MenuItem cut = new MenuItem("Cut");
                MenuItem copy = new MenuItem("Copy");
                MenuItem paste = new MenuItem("Paste");
                menu.getItems().addAll(cut, copy, paste);

                menu.getItems().add(new SeparatorMenuItem());

                MenuItem rename = new MenuItem("Rename");
                rename.setDisable(true);
                MenuItem delete = new MenuItem("Delete");
                delete.setOnAction(event1 -> getTreeItem().getValue().delete());
                menu.getItems().addAll(rename, delete);

                setContextMenu(menu);
            }
        }

    }

}