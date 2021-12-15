package net.pryoscode.kanai.windows.tabs;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import net.pryoscode.kanai.utils.CustomTab;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import javafx.beans.value.ObservableValue;
import net.pryoscode.kanai.Reporter;
import javax.xml.bind.DatatypeConverter;

public class CodeTab extends CustomTab {

    private final File file;
    private final String name;
    private String hash;

    public CodeTab() {
        this(null);
    }

    public CodeTab(File file) {
        this.file = file;
        String text = "";
        if (file != null && file.exists()) {
            try {
                text = Files.readString(file.toPath(), StandardCharsets.UTF_8);
                hash = hash(text);
            } catch (Exception e) {
                new Reporter(e);
            }
        }
        CodeArea code = new CodeArea(text);
        code.setParagraphGraphicFactory(LineNumberFactory.get(code));
        code.textProperty().addListener(this::onTextChanged);
        setContent(new VirtualizedScrollPane<>(code));

        if (file == null) {
            name = "Untitled";
            setText(name + "*");
        } else {
            name = file.getName();
            setText(name);
        }
    }

    public void onTextChanged(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if (hash(newValue).equals(hash))
            setText(name);
        else
            setText(name + "*");
    }

    private String hash(String input) {
        try {
            byte[] hash = MessageDigest.getInstance("MD5").digest(input.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(hash);
        } catch (Exception e) {
            new Reporter(e);
        }
        return "";
    }

    @Override
    public String getIdentifier() {
        if (file == null)
            return null;
        return file.getPath();
    }

}