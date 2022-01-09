package net.pryoscode.kanai.keyboard.keys;

import javafx.scene.input.KeyCode;
import net.pryoscode.kanai.keyboard.Key;
import net.pryoscode.kanai.windows.Window;

public class Fullscreen extends Key {

    public Fullscreen() {
        super(false, KeyCode.F11);
    }

    @Override
    public void onAction() {
        Window.getStage().setFullScreen(!Window.getStage().isFullScreen());
    }

}