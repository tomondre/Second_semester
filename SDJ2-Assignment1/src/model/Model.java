package model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{
  void addListener(PropertyChangeListener listener);
  ArrayList<Double> getThermometerHistory(int thermometerID);
  double getLastThermometerValue(int thermometerID);
  int getHeaterLevel();
  void turnHeaterUp();
  void turnHeaterDown();
}
