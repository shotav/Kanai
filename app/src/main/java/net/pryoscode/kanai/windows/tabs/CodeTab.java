package net.pryoscode.kanai.windows.tabs;

import java.io.File;
import java.nio.file.Files;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import net.pryoscode.kanai.Reporter;

public class CodeTab extends Tab {

    private String name;

    public CodeTab() {
        this(null);
    }

    public CodeTab(File file) {
        CodeArea code = new CodeArea();
        code.setParagraphGraphicFactory(LineNumberFactory.get(code));
        code.textProperty().addListener(this::onTextChanged);
        setContent(new VirtualizedScrollPane<>(code));

        if (file == null) {
            name = "Untitled";
            setText(name + "*");
        } else {
            name = file.getName();
            if (file.exists()) {
                try {
                    code.appendText(Files.readString(file.toPath()));
                } catch (Exception e) {
                    new Reporter(e);
                }
            }
            setText(name);
        }
    }

    public void onTextChanged(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        setText(name + "*");
    }

}