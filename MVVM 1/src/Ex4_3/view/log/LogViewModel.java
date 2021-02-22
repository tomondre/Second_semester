package Ex4_3.view.log;

import Ex4_3.model.TextConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class LogViewModel
{
  private TextConverter log;
  private ObservableList<String> logs;

  public LogViewModel(TextConverter converter)
  {
    log = converter;
    logs = FXCollections.observableArrayList();;
  }

  public ObservableList<String> getLog(){
    return logs;
  }
}
