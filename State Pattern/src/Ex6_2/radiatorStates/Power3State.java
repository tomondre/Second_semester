package Ex6_2.radiatorStates;

import Ex6_2.Radiator;

public class Power3State implements RadiatorState
{
  private static int POWER = 3;

  public Power3State(Radiator radiator)
  {
    Runnable runnable = () -> {
      try
      {
        Thread.sleep(10000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      finally
      {
        turnDown(radiator);
      }
    };
    Thread thread = new Thread(runnable);
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void turnUp(Radiator radiator)
  {

  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
