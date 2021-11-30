package net.pryoscode.kanai.windows.components;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import javafx.scene.layout.BorderPane;

public class Editor extends BorderPane  {

    public Editor() {
        CodeArea code = new CodeArea();
        code.setParagraphGraphicFactory(LineNumberFactory.get(code));
        setCenter(new VirtualizedScrollPane<>(code));
    }

}