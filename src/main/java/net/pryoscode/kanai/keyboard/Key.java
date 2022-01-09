package net.pryoscode.kanai.keyboard;

import javafx.scene.input.KeyCode;

public abstract class Key {

    private final boolean ctrl;
    private final KeyCode code;

    public Key(boolean ctrl, KeyCode code) {
        this.ctrl = ctrl;
        this.code = code;
    }

    public abstract void onAction();

    public boolean isCtrl() {
        return ctrl;
    }

    public KeyCode getCode() {
        return code;
    }

}