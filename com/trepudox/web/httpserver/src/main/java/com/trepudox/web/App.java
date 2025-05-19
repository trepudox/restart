package com.trepudox.web;

import com.trepudox.web.server.Server;

public class App {

    public static void main(String[] args) {
        Server server = new Server();

        server.start();
    }
}
