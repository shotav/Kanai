package net.pryoscode.kanai.config;

public abstract class Setting<T> {

    private final String name;
    private final T value;

    public Setting(String name, T standard) {
        this.name = name;
        value = standard;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

}