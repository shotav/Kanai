package net.pryoscode.kanai.keyboard;

import javafx.scene.input.KeyCode;

public abstract class Key {

    private final KeyCode code;

    public Key(KeyCode code) {
        this.code = code;
    }

    public KeyCode getCode() {
        return code;
    }

    public abstract void onAction();

}