package net.pryoscode.kanai.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public class StylesheetHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if (protocol.equals("styles")) {
            return new StylesheetStreamHandler();
        }
        return null;
    }

    private class StylesheetConnection extends URLConnection {

        protected StylesheetConnection(URL url) {
            super(url);
        }

        @Override
        public void connect() throws IOException {}

        @Override
        public InputStream getInputStream() throws IOException {
            return Loader.load("styles/" + getURL().getPath() + ".css");
        }

    }

    private class StylesheetStreamHandler extends URLStreamHandler {

        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new StylesheetConnection(url);
        }

    }

}