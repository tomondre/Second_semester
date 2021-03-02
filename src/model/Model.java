package model;

import javafx.collections.ObservableList;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model
{
void addListener(PropertyChangeListener listener);
ArrayList<Double> getThermometerHistory(int thermometerID);
double getLastThermometerValue(int thermometerID);
}
