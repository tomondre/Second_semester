package view.graphView;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class GraphViewController
{
  public Button BackButton;
  public LineChart<String, Number> chart;
  public CategoryAxis xAxis;
  public NumberAxis yAxis;
  public Label header;

  private GraphViewModel viewModel;
  private ViewHandler handler;

  public void init(ViewHandler handler, GraphViewModel viewModel)
  {
    this.handler = handler;
    this.viewModel = viewModel;

    xAxis = new CategoryAxis();
    yAxis = new NumberAxis();
    chart = new LineChart<>(xAxis, yAxis);
    chart.setData(viewModel.getThermHistory());
    header.textProperty().bind(viewModel.getHeading());
  }

  public void onBackButton(ActionEvent actionEvent) throws IOException
  {
    handler.openHistoryView(viewModel.getSelectedItemID());
  }
}
