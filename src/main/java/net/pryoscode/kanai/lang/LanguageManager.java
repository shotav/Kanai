package net.pryoscode.kanai.lang;

import net.pryoscode.kanai.lang.langs.Java;
import net.pryoscode.kanai.lang.langs.Kotlin;
import net.pryoscode.kanai.lang.langs.Rust;
import java.util.ArrayList;
import java.util.List;

public class LanguageManager {

    private static final List<Language> list = new ArrayList();

    public static void init() {
        list.add(new Java());
        list.add(new Kotlin());
        list.add(new Rust());
    }

}