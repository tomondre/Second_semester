package Ex4_3.view.log;

import Ex4_3.core.ViewHandler;
import javafx.scene.control.ListView;

public class LogViewController
{
private ListView<String> logList;
private LogViewModel logVM;
private ViewHandler viewHandler;

public void init()
{

  logList.setItems(logVM.getLog());

}
}
