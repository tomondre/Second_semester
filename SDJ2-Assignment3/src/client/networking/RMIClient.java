package client.networking;

import server.networking.Server;
import shared.PropertyChangeSubject;
import shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIClient implements Client, PropertyChangeSubject
{
  private Server server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  public void startClient(String name)
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (Server) registry.lookup("Server");
      server.registerCallBack(this);
      server.addClient(name);
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessage(Request request)
  {
    try
    {
      server.sendMessage(request);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public void setClientName(String oldName, String newName)
  {
    try
    {
      server.setClientName(oldName, newName);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public int getNumberOfConnectedClients()
  {
    try
    {
      return server.getNumberOfConnectedClients();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return -1;
  }

  public ArrayList<String> getClientList()
  {
    try
    {
      return server.getConnectedClientList();
    }
    catch (RemoteException e)
    {
    }
    return null;
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void receiveMessage(Request request)
  {
    support.firePropertyChange("", -1, request);
  }
}
