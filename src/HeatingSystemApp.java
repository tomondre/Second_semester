import core.ModelFactory;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Thermometer;

public class HeatingSystemApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {

    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);

  }
}