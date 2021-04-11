package Ex22_2.client.core;

import Ex22_2.client.model.ChatModel;
import Ex22_2.client.model.Model;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private Model model;
  private static ModelFactory modelFactory = new ModelFactory(ClientFactory.getInstance());

  private ModelFactory(ClientFactory client)
  {
    this.clientFactory = client;
    model = new ChatModel(client.getClient());
  }

  public static ModelFactory getInstance()
  {
    return modelFactory;
  }

  public Model getModel()
  {
    return model;
  }

}
