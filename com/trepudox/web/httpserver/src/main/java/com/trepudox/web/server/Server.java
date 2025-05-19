package com.trepudox.web.server;

import com.sun.net.httpserver.HttpServer;
import com.trepudox.web.handler.CustomHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private static final String HOSTNAME = "localhost";
    private static final int SERVER_PORT = 8000;

    public void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, SERVER_PORT), 0);

            createServerContexts(server);
            server.start();

            System.out.printf("Server iniciado na porta %s%n", SERVER_PORT);
        } catch (IOException e) {
            System.out.printf("%nDeu erro papai: %s%n%n", e.getMessage());
            e.printStackTrace();
        }
    }

    private void createServerContexts(HttpServer server) {
        server.createContext("/", new CustomHandler());
    }

}
