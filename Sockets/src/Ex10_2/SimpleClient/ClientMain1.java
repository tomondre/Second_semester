package Ex10_2.SimpleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain1
{

  public static void main(String[] args) throws IOException
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 1235);

      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      //The protocol for showing name + protocol for displaying toString() method so 1+3
      for (int i = 0; i < 4; i++)
      {
        String message = in.readLine();
        System.out.println(message);
        String name = new Scanner(System.in).nextLine();
        out.println(name);
        message = in.readLine();
        if (message.equals("error") || message.equals("stop"))
        {
          System.out.println("Socket closed");
          return;
        }
        System.out.println(message);
      }
    }
    catch (ConnectException e)
    {
      System.out.println("Error, couldn't find server socket".toUpperCase());
    }
  }
}
