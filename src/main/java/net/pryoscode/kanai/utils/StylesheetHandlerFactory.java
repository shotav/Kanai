package net.pryoscode.kanai.utils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public class StylesheetHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if (protocol.equals("styles"))
            return new StylesheetStreamHandler();
        return null;
    }

    private static class StylesheetConnection extends URLConnection {

        public StylesheetConnection(URL url) {
            super(url);
        }

        @Override
        public void connect() {}

        @Override
        public InputStream getInputStream() {
            return Loader.load("styles/" + getURL().getPath() + ".css");
        }

    }

    private static class StylesheetStreamHandler extends URLStreamHandler {

        @Override
        public URLConnection openConnection(URL url) {
            return new StylesheetConnection(url);
        }

    }

}