package net.pryoscode.kanai.keyboard;

import javafx.scene.input.KeyEvent;
import net.pryoscode.kanai.keyboard.keys.New;
import net.pryoscode.kanai.keyboard.keys.Open;
import net.pryoscode.kanai.keyboard.keys.Save;
import java.util.ArrayList;
import java.util.List;

public class KeyManager {

    private final List<Key> keys = new ArrayList<>();

    public KeyManager() {
        keys.add(new New());
        keys.add(new Open());
        keys.add(new Save());
    }

    public void onKeyPressed(KeyEvent event) {
        if (!event.isControlDown()) return;
        for (Key key : keys)
            if (key.getCode() == event.getCode())
                key.onAction();
    }

}