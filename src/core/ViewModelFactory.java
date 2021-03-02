package core;

import view.heaterView.HeaterViewModel;

public class ViewModelFactory
{
  private ModelFactory model;
  private HeaterViewModel heaterVM;

  public ViewModelFactory(ModelFactory model)
  {
    this.model = model;
    heaterVM = new HeaterViewModel(model.getModel());
  }

  public HeaterViewModel getHeaterVM()
  {
    return heaterVM;
  }
}