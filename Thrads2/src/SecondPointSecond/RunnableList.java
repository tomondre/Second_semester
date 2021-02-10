package SecondPointSecond;

public class RunnableList implements Runnable
{

  private ListContainer container;

  public RunnableList(ListContainer container)
  {
    this.container = container;
  }

  public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
    add(i);
    }

    System.out.println(container.length());
  }

  public synchronized void add(int i)
  {
    container.add(i);

  }
}
