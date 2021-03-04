package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ThermometerLog
{
  private ArrayList<Double> list;

  public ThermometerLog(){
    list = new ArrayList<Double>();
    list.add((double) 10);
  }

  //Round the number before adding
  public void add(double value){
    list.add(Math.round(value*100.0)/100.0);
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
