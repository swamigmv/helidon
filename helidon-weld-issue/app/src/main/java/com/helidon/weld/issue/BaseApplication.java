package com.helidon.weld.issue;

import io.helidon.config.Config;
import io.helidon.microprofile.server.Server;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.helidon.config.ConfigSources.create;


public class BaseApplication {
    public static void main(final String[] args) {

            startServer();
            System.setProperty("org.jboss.weld.se.archive.isolation","false");

    }

    protected static void startServer() {

        Server server = Server.builder().build();
        server.start();
    }

}
