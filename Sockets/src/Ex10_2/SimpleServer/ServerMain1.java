package Ex10_2.SimpleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain1
{

  public static void main(String[] args) throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(1235);

    while (true)
    {
      Socket socket = serverSocket.accept();
      System.out.println(
          "Client connected from " + socket.getInetAddress().getHostAddress()
              + " " + socket.getLocalPort());
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      out.println("Hello from server. Write your name");
      String nameFromClient = in.readLine();
      out.println("Hello " + nameFromClient);

      for (int i = 0; i < 3; i++)
      {
        out.println("Hello from server. Write your string");
        String stringFromClient = in.readLine();

        if (stringFromClient.equals("error"))
        {
          System.out.println("Server closing");
          out.println(stringFromClient);
          return;
        }
        else if (stringFromClient.equals("stop"))
        {
          System.out.println("Socket stopped");
          out.println(stringFromClient);
          break;
        }

        out.println("Uppercase: " + stringFromClient.toUpperCase());
      }
      System.out.println("Operation done");
    }
  }

}
