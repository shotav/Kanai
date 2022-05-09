package net.pryoscode.kanai.lang;

import net.pryoscode.kanai.lang.langs.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageManager {

    private static final List<Language> list = new ArrayList();

    public static void init() {
        list.add(new Java());
        list.add(new JavaScript());
        list.add(new Kotlin());
        list.add(new Rust());
    }

}