package server.networking;

import client.networking.Client;
import shared.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Server extends Remote
{
  void sendMessage(Request request) throws RemoteException;
  void registerCallBack(Client rmiClient) throws RemoteException;
  ArrayList<String> getConnectedClientList() throws RemoteException;
  void setClientName(String oldName, String newName) throws RemoteException;
  int getNumberOfConnectedClients() throws RemoteException;
  void addClient(String clientName) throws RemoteException;
}
