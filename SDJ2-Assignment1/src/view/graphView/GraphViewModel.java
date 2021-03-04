package view.graphView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class GraphViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<XYChart.Series<String, Number>> selectedThermHistory;
  private int selectedThermID;
  private StringProperty heading;

  public GraphViewModel(Model model)
  {
    this.model = model;
    model.addListener(this);
    heading = new SimpleStringProperty();
    selectedThermHistory = FXCollections.observableArrayList();
    loadThermHistory();
  }

  public ObservableList<XYChart.Series<String, Number>> getThermHistory()
  {
    return selectedThermHistory;
  }

  public StringProperty getHeading()
  {
    return heading;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if ((int) evt.getOldValue() == selectedThermID)
    {
      loadThermHistory();
    }
  }

  public void setIndex(int selectedThermID)
  {
    this.selectedThermID = selectedThermID;
    loadThermHistory();

    if (selectedThermID == 0)
    {
      heading.set("External thermometer number " + selectedThermID);
    }
    else
    {
      heading.set("Internal thermometer number " + selectedThermID);
    }
  }

  private void loadThermHistory()
  {
selectedThermHistory.clear();

    ArrayList<Double> temp = model.getThermometerHistory(selectedThermID);
    XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

    for (int i = 0; i < temp.size(); i++)
    {
      series.getData().add(
          new XYChart.Data<String, Number>(Integer.toString(i), temp.get(i)));
    }
    selectedThermHistory.add(series);
  }

  public int getSelectedItemID()
  {
    return selectedThermID;
  }
}

