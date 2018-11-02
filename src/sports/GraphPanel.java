package sports;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * @author imssbora
 */
public class GraphPanel extends JFrame {
  private static final long serialVersionUID = 6294689542092367723L;

  public GraphPanel(String title) {
    super(title);

    // Create dataset
    XYDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createXYLineChart(
        "XY Line Chart Example",
        "X-Axis",
        "Y-Axis",
        dataset,
        PlotOrientation.VERTICAL,
        true, true, false);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private XYDataset createDataset() {
    XYSeriesCollection dataset = new XYSeriesCollection();

    XYSeries series = new XYSeries("Y = X + 2");
    series.add(2, 4);
    series.add(8, 10);
    series.add(10, 12);
    series.add(13, 15);
    series.add(17, 19);
    series.add(18, 20);
    series.add(21, 23);

    //Add series to dataset
    dataset.addSeries(series);
    
    return dataset;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      GraphPanel example = new GraphPanel("XY Chart Example | BORAJI.COM");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
}