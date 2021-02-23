package Ex5_3.view.remove;

import Ex5_3.core.ViewHandler;
import Ex5_3.model.Task;
import Ex5_3.model.TaskModel;
import javafx.beans.property.StringProperty;

public class NextTaskVM
{
  private StringProperty description;
  private StringProperty creator;
  private StringProperty date;
  private TaskModel model;
  private ViewHandler handler;

  public NextTaskVM(TaskModel model)
  {
  this.model = model;
  this.handler = handler;
  }

  public void getNextTask()
  {
  Task task = model.getNextTask();
  description.setValue(task.getOwner());
  creator.setValue(task.getOwner());
  date.setValue(task.getTimeCreated());
  }
}
