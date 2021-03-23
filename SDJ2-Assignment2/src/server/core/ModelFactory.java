package server.core;

import server.model.MessengerManager;
import server.model.ServerModel;

public class ModelFactory
{
  private ServerModel model;


  public ServerModel getServerModel()
  {
    if(model == null)
    {
      model = new MessengerManager();
    }
    return model;
  }
}
