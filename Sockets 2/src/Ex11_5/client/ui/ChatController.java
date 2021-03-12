package Ex11_5.client.ui;

import Ex11_5.client.networking.SocketClient;
import Ex11_5.transferobjects.Message;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatController extends Application
{

  public TextField nameField;
  public TextField messageField;
  public Button setNameButton;
  public Button sendMessageButton;
  public TextArea chatArea;

  private SocketClient client;
  private String name;

  public void start(Stage stage) throws Exception
  {
    name = "unnamed";
    openView(stage);
  }

  public void onSetNameButton(ActionEvent actionEvent)
  {
    name = nameField.getText();
  }

  public void onSendMessageButton(ActionEvent actionEvent)
  {
    if (client == null)
    {
      client = new SocketClient(this);
    }
    System.out.println(client);
    Platform.runLater(() -> {
      client.sendMessage(new Message(name + ": " + messageField.getText()));
    });
  }

  public void messageReceived(Message message)
  {
    Platform.runLater(() -> {
      chatArea.appendText(" \n" + message.get());
    });
  }

  public void openView(Stage stage) throws Exception
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("Chat.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }
}
