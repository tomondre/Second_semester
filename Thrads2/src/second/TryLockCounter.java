package second;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockCounter
{
  private int count;
  private Lock lock = new ReentrantLock();

  public void inc()
  {
    if (lock.tryLock())
    {
      count++;
      lock.unlock();
    }
    else
    {
      System.out.println("Lock was in use");
    }
  }

  public synchronized int get()
  {
    return count;
  }

}
