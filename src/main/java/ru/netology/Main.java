package ru.netology;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Main {
  final static int PORT = 9990;

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


