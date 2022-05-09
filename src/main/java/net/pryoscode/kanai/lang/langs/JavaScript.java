package net.pryoscode.kanai.lang.langs;

import net.pryoscode.kanai.lang.Language;

public class JavaScript extends Language {

    @Override
    public void onSetup() throws Exception {
        Runtime.getRuntime().exec("npm install -g vscode-languageserver");
    }

}
