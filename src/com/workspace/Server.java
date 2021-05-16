package com.workspace;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classification: Trimble Confidential.
 * Description: Custom Banner for Startup
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-05-16
 * @version: 0.1
 */
public class Server {

  private Socket socket = null;
  private ServerSocket serverSocket = null;
  private DataInputStream input = null;

  public Server(int port) {

    try {

      // Opening Connection
      serverSocket = new ServerSocket(port);
      System.out.println("Server Started");
      System.out.println("Waiting for the client ...");
      socket = serverSocket.accept();
      System.out.println("Client accepted");

      // Creating a stream to read the data send by client
      input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

      String line = "";

      while (!line.equals("Over")) {
        line = input.readUTF();
        System.out.println(line);
      }

      System.out.println("Closing connection");
      input.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {
    Server server = new Server(5000);
  }
}
