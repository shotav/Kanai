package net.pryoscode.kanai.utils;

import com.github.sommeri.less4j.core.ThreadUnsafeLessCompiler;
import net.pryoscode.kanai.Reporter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.nio.charset.StandardCharsets;

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
            try {
                String content = Loader.read("styles/" + getURL().getPath() + ".less");
                String css = new ThreadUnsafeLessCompiler().compile(content).getCss();
                return new ByteArrayInputStream(css.getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                new Reporter(e);
            }
            return null;
        }

    }

    private static class StylesheetStreamHandler extends URLStreamHandler {

        @Override
        public URLConnection openConnection(URL url) {
            return new StylesheetConnection(url);
        }

    }

}