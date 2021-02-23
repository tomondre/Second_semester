package Ex5_3.view.all;

import Ex5_3.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class AllTaskController
{
  public Button nextTaskButton;
  public Button addButton;
  public TableView table;
  public TableColumn descriptionColumn;
  public TableColumn creatorColumn;
  public TableColumn dateColumn;

  private AllTaskVM viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, AllTaskVM allTaskVM)
  {
    this.viewModel = allTaskVM;
    this.viewHandler = viewHandler;
    creatorColumn.setCellFactory(new PropertyValueFactory<>("owner"));
    descriptionColumn.setCellFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellFactory(new PropertyValueFactory<>("dateCreated"));
  }

  public void onAddButton(ActionEvent actionEvent) throws IOException
  {
viewHandler.openAddTaskView();
  }

  public void onNextTask(ActionEvent actionEvent)
  {

  }
}
