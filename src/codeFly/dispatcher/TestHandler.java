package codeFly.dispatcher;

import codeFly.CodeFly;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        File aboutPage = new File(CodeFly.ROOT_DIR + "frontEnd/about.html");
        // response with a success response
        exchange.sendResponseHeaders(200, aboutPage.length());
        OutputStream os = exchange.getResponseBody();
        Files.copy(aboutPage.toPath(), os);
        os.close();
        CodeFly.logger.info("Sent aboutus.html to client" + exchange.getRemoteAddress());
    }
}
