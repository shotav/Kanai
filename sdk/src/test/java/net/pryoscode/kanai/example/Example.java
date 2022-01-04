package net.pryoscode.kanai.example;

import net.pryoscode.kanai.sdk.Plugin;

public class Example extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World!");
    }

    @Override
    public void onDisable() {
        System.out.println("Bye World!");
    }

}