package second;

public class Hi implements Runnable
{
  private int num;
  public Hi(int num)
  {
    this.num = num;
  }
  @Override
  public void run(){
    while (true){
      for (int i = 0; i < num; i++)
      {
        System.out.println("hi");
      }
    }
  }
}
