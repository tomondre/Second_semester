package core;

import view.graphView.GraphViewModel;
import view.heaterView.HeaterViewModel;
import view.historyView.HistoryViewModel;
import view.thermometerView.ThermometerViewModel;

public class ViewModelFactory
{
  private ModelFactory model;
  private ThermometerViewModel thermometerVM;
  private HeaterViewModel heaterVM;
  private HistoryViewModel historyVM;
  private GraphViewModel graphViewModel;

  public ViewModelFactory(ModelFactory model)
  {
    this.model = model;

    historyVM = new HistoryViewModel(model.getModel());
    heaterVM = new HeaterViewModel(model.getModel());
    thermometerVM = new ThermometerViewModel(model.getModel());
    graphViewModel = new GraphViewModel(model.getModel());
  }

  public ThermometerViewModel getThermometerVM()
  {
    return thermometerVM;
  }

  public HeaterViewModel getHeaterVM()
  {
    return heaterVM;
  }

  public HistoryViewModel getHistoryVM()
  {
    return historyVM;
  }

  public GraphViewModel getGraphViewModel()
  {
    return graphViewModel;
  }
}