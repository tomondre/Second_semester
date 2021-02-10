package SecondPointSecond;

import java.util.ArrayList;

public class ListContainer
{
  private ArrayList<Integer> list;

  public ListContainer()
  {
    list = new ArrayList<Integer>();
  }

  public void add(int i)
  {
    list.add(i);
  }

  public int length()
  {
    return list.size();
  }


}
