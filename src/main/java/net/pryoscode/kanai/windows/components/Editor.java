package net.pryoscode.kanai.windows.components;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Editor extends TabPane  {

    public Editor() {
        Tab tab = new Tab("Untitled*");
        CodeArea code = new CodeArea();
        code.setParagraphGraphicFactory(LineNumberFactory.get(code));
        tab.setContent(new VirtualizedScrollPane<>(code));
        getTabs().add(tab);
        setId("editor");
    }

}