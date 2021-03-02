package core;

import model.HeatingSystem;
import model.Model;

public class ModelFactory
{
  private Model model;

  public ModelFactory(){
    model = new HeatingSystem();
  }

  public Model getModel(){
    return model;
  }
}
