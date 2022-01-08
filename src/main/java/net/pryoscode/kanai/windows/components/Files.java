package net.pryoscode.kanai.windows.components;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import net.pryoscode.kanai.Reporter;
import net.pryoscode.kanai.utils.FileTransferable;
import net.pryoscode.kanai.windows.tabs.CodeTab;

public class Files extends TreeView<File> {

    public Files(File directory) {
        setOnKeyPressed(this::onKeyPressed);
        setShowRoot(false);
        setRoot(new FileItem(directory));
        setCellFactory(param -> new FileCell());
    }

    private void onKeyPressed(KeyEvent event) {
        TreeItem<File> selected = getSelectionModel().getSelectedItem();
        if (selected != null && event.getCode() == KeyCode.ENTER)
            if (selected.getValue().isDirectory())
                selected.setExpanded(!selected.isExpanded());
            else
                Editor.open(new CodeTab(selected.getValue()));
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
            if (empty) setText("");
            else setText(item.getName());
        }

        private void onMouseClicked(MouseEvent event) {
            if (event.getButton().equals(MouseButton.PRIMARY) && getTreeItem() != null) {
                if (event.getClickCount() % 2 == 0 && !getTreeItem().getValue().isDirectory())
                    Editor.open(new CodeTab(getTreeItem().getValue()));
            } else if (event.getButton().equals(MouseButton.SECONDARY)) {
                ContextMenu menu = new ContextMenu();

                if (getTreeItem() == null || getTreeItem().getValue().isDirectory()) {
                    Menu newMenu = new Menu("New");
                    MenuItem file = new MenuItem("File");
                    MenuItem directory = new MenuItem("Directory");
                    file.setDisable(true);
                    directory.setDisable(true);
                    newMenu.getItems().addAll(file, directory);
                    menu.getItems().add(newMenu);
                } else {
                    MenuItem open = new MenuItem("Open");
                    open.setOnAction(event12 -> Editor.open(new CodeTab(getTreeItem().getValue())));
                    menu.getItems().add(open);
                }
                menu.getItems().add(new SeparatorMenuItem());

                if (getTreeItem() != null) {
                    MenuItem cut = new MenuItem("Cut");
                    cut.setDisable(true);
                    MenuItem copy = new MenuItem("Copy");
                    copy.setOnAction(event1 -> Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new FileTransferable(getTreeItem().getValue()), null));
                    menu.getItems().addAll(cut, copy);
                }

                if (getTreeItem() == null || getTreeItem().getValue().isDirectory()) {
                    MenuItem paste = new MenuItem("Paste");
                    menu.getItems().add(paste);
                    Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
                    if (!transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) paste.setDisable(true);
                    paste.setOnAction(event13 -> {
                        try {
                            List<File> files = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                            for (File source : files) {
                                if (getTreeItem() == null)
                                    java.nio.file.Files.copy(source.toPath(), new File(getTreeView().getRoot().getValue().getPath() + File.separator + source.getName()).toPath());
                                else
                                    java.nio.file.Files.copy(source.toPath(), new File(getTreeItem().getValue().getPath() + File.separator + source.getName()).toPath());
                            }
                        } catch (Exception e) {
                            new Reporter(e);
                        }
                    });
                }

                if (getTreeItem() != null) {
                    menu.getItems().add(new SeparatorMenuItem());
                    MenuItem rename = new MenuItem("Rename");
                    rename.setDisable(true);
                    MenuItem delete = new MenuItem("Delete");
                    delete.setOnAction(event1 -> getTreeItem().getValue().delete());
                    menu.getItems().addAll(rename, delete);
                }

                setContextMenu(menu);
            }
        }

    }

}