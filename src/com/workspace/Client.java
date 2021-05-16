package com.workspace;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * Description: Custom Banner for Startup
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-05-16
 * @version: 0.1
 */
public class Client {

  private Socket socket = null;
  private DataInputStream input = null;
  private DataOutputStream output = null;


  public Client(String ip, int port) {

    try {
      // Opening connection
      socket = new Socket(ip, port);
      System.out.println("Connected");

      // Creating a stream to read from keyboard
      input = new DataInputStream(System.in);
      // Creating a stream to send to the socket
      output = new DataOutputStream(socket.getOutputStream());


      // Sending message
      String line = "";
      while (!line.equals("Over")) {
        line = input.readLine();
        output.writeUTF(line);
      }

      // Closing connection
      input.close();
      output.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Client client = new Client("127.0.0.1", 5000);
  }
}
