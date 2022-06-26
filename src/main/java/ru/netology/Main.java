package ru.netology;

import java.io.IOException;


public class Main {
    final static int PORT = 9988;

    public static void main(String[] args) {

        final var server = new Server();

        for (String validPath : ClientHandler.validPaths) {

            server.addHandler("GET", validPath, (request, responseStream) -> {
                try {
                    ClientHandler.responseOK(request, responseStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }


        server.addHandler("POST", "/resources.html", (request, responseStream) -> {
            try {
                ClientHandler.responseOK(request, responseStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        server.listen(PORT);

    }
}


