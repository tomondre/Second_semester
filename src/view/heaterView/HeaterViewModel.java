package view.heaterView;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewModel implements PropertyChangeListener
{

  private DoubleProperty[] thermometerProperties;

  private Model model;

  public HeaterViewModel(Model model)
  {
    thermometerProperties = new SimpleDoubleProperty[3];
    this.model = model;
  }

  public DoubleProperty getThermometerProperty(int thermometerID){
    return thermometerProperties[thermometerID];
  }


  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    int thermometerChangedID = (int) evt.getOldValue();

    for (int i = 0; i < thermometerProperties.length; i++)
    {
      if (thermometerChangedID == i)
      {
        thermometerProperties[i]
            .set(model.getLastThermometerValue(thermometerChangedID));
      }
    }
  }
}
