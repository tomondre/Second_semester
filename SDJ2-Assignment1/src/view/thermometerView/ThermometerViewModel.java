package view.thermometerView;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{

  private StringProperty[] thermometerProperties;

  private Model model;

  public ThermometerViewModel(Model model)
  {
    this.model = model;
    model.addListener(this);

    thermometerProperties = new SimpleStringProperty[3];
    for (int i = 0; i < thermometerProperties.length; i++)
    {
      thermometerProperties[i] = new SimpleStringProperty();
      thermometerProperties[i]
          .set(String.valueOf(model.getLastThermometerValue(i)));
    }
  }

  public StringProperty getThermometerProperty(int thermometerID)
  {
    return thermometerProperties[thermometerID];
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      int thermometerChangedID = (int) evt.getOldValue();

      for (int i = 0; i < thermometerProperties.length; i++)
      {
        if (thermometerChangedID == i)
        {
          String lastDoubleTemperatureAsString = String
              .valueOf(model.getLastThermometerValue(thermometerChangedID));
          thermometerProperties[i].set(lastDoubleTemperatureAsString);
        }
      }
    });
  }
}
