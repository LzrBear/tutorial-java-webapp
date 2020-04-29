package webservice;

import org.glassfish.grizzly.http.server.HttpServer;

import org.glassfish.jersey.grizzly2.httpserver
    .GrizzlyHttpServerFactory;

import org.glassfish.grizzly.http.server.StaticHttpHandler;

import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static final String BASE_URI =
        "http://localhost:1337/CSVXtract-WS/rest";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig()
            .packages("webservice");

        return GrizzlyHttpServerFactory
            .createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(final String[] args)
        throws IOException {

        final HttpServer server = startServer();

        server
            .getServerConfiguration()
            .addHttpHandler(
                new StaticHttpHandler("src/main/webapp"),
                "/CSVXtract-WS"
            );

        System.out.printf(
            "Jersey app started with WADL available at "
                + "%sapplication.wadl\n"
                + "Hit enter to stop it...\n",
            BASE_URI
        );
        System.in.read();
        server.shutdownNow();
    }
}

