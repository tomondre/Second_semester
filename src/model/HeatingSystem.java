package model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class HeatingSystem implements Model
{
  private Heater heater;

  //Internal thermometers in list has externalThermometer field set to null.
  private Thermometer[] thermometers;

  public HeatingSystem()
  {
    heater = new Heater();
    thermometers = new Thermometer[3];
    thermometers[0] = new Thermometer(0, this, 0, null);
    thermometers[1] = new Thermometer(1, this, 1, thermometers[0]);
    thermometers[2] = new Thermometer(2, this, 7, thermometers[0]);
  }

  public int getHeatingPower()
  {
    return heater.getPower();
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    for (Thermometer thermometer : thermometers)
    {
      thermometer.addListener(listener);
    }
  }

  @Override public ArrayList<Double> getThermometerHistory(int thermometerID)
  {
    for (Thermometer thermometer : thermometers)
    {
      if (thermometer.getID() == thermometerID)
      {
        return thermometer.getHistory();
      }
    }
    return null;
  }

  @Override public double getLastThermometerValue(int thermometerID)
  {
    for (Thermometer thermometer : thermometers)
    {
      if (thermometer.getID() == thermometerID)
      {
        return thermometer.getLastValue();
      }
    }
    return 0;
  }
}
