package model;

import java.util.ArrayList;

public class ThermometerLog
{
  private ArrayList<Double> list;

  public ThermometerLog(){
    list = new ArrayList<Double>();
  }

  public void add(double value){
    list.add(value);
  }

  public double getLastValue()
  {
    return list.get(list.size()-1);
  }

  public ArrayList<Double> getHistoryValues()
  {
    return list;
  }
}
