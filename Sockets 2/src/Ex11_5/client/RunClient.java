package Ex11_5.client;

import Ex11_5.client.networking.SocketClient;
import Ex11_5.client.ui.ChatController;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunClient
{
  public static void main(String[] args)
  {
    Application.launch(ChatController.class);
  }
}
