package server.networking;

import client.networking.Client;
import server.model.ServerModel;
import shared.Request;
import shared.RequestType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIServer implements Server
{
  private ServerModel model;

  public RMIServer(ServerModel model)
  {
    this.model = model;

    try
    {
      UnicastRemoteObject.exportObject(this, 0);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendMessage(Request request) throws RemoteException
  {
    model.sendMessage(request);
  }

  @Override public void registerCallBack(Client rmiClient)
      throws RemoteException
  {
    model.addPropertyChangeListener(RequestType.Message.toString(), evt -> {

      try
      {
        rmiClient.receiveMessage((Request) evt.getNewValue());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    });
  }

  @Override public ArrayList<String> getConnectedClientList()
      throws RemoteException
  {
    return model.getClientList();
  }

  @Override public void setClientName(String oldName, String newName)
      throws RemoteException
  {
    model.setClientName(oldName, newName);
  }

  @Override public int getNumberOfConnectedClients() throws RemoteException
  {
    return model.getNumberOfConnectedClients();
  }

  @Override public void addClient(String clientName) throws RemoteException
  {
    model.addClient(clientName);
  }
}
