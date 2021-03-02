package model;

import model.heaterStates.HeaterState;
import model.heaterStates.Power0State;

public class Heater
{
  private HeaterState state = new Power0State();

  public Heater()
  {
  }



  public void setState(HeaterState state){
    this.state = state;
  }

  public int getPower()
  {
    return state.getPower();
  }
}
