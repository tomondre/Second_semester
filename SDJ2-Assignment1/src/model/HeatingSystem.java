package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class HeatingSystem implements Model
{
  private Heater heater;
  private PropertyChangeSupport propertyChangeSupport;

  //Internal thermometers in list has externalThermometer field set to null.
  private Thermometer[] thermometers;
  private Thread[] threads;

  public HeatingSystem()
  {
    propertyChangeSupport = new PropertyChangeSupport(this);
    heater = new Heater(this);

    thermometers = new Thermometer[3];
    thermometers[0] = new Thermometer(0, this, 0, null);
    thermometers[1] = new Thermometer(1, this, 1, thermometers[0]);
    thermometers[2] = new Thermometer(2, this, 7, thermometers[0]);

    threads = new Thread[thermometers.length];
    for (int i = 0; i < threads.length; i++)
    {
      threads[i] = new Thread(thermometers[i]);
      threads[i].setDaemon(true);
      threads[i].start();
    }
  }

  public int getHeatingPower()
  {
    return heater.getPower();
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

  @Override public int getHeaterLevel()
  {
    return heater.getPower();
  }

  @Override public void turnHeaterUp()
  {
    heater.turnUp();
  }

  @Override public void turnHeaterDown()
  {
    heater.turnDown();
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override public void firePropertyChange(String propertyName, int thermometerID,
      double newValue)
  {
    propertyChangeSupport
        .firePropertyChange(propertyName, thermometerID, newValue);
  }
}

