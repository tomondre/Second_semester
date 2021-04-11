package Ex22_2.client.view.login;

import Ex22_2.client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private Model model;
private StringProperty nameProperty;


  public LoginViewModel(Model model)
  {
    this.model = model;
    nameProperty = new SimpleStringProperty();
  }

  public void setName()
  {
    model.setName(nameProperty.get());
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }
}
