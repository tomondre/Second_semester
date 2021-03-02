package view.heaterView;

import javafx.scene.control.Label;

public class HeaterViewController
{
  public Label t0Label;
  public Label t1Label;
  public Label t2Label;

  private HeaterViewModel viewModel;

  public void init(HeaterViewModel model){
    viewModel = model;

    t0Label.textProperty().bind(model.getThermometerProperty(0).asString());
    t1Label.textProperty().bind(model.getThermometerProperty(1).asString());
    t2Label.textProperty().bind(model.getThermometerProperty(2).asString());
  }


}
