package first;

public class CounterStart
{
  public static void main(String[] args)
  {
    Counter c = new Counter();
    Thread t1 = new Thread(new Invoking(c));
    Thread t2 = new Thread(new Invoking(c));

    t1.start();
    t2.start();
  }
}
