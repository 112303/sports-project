package sports;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class MatchesAnalytics extends ApplicationFrame {
   
   public MatchesAnalytics( String title ) {
      super( title );
      
      setContentPane(createDemoPanel());
           
//       XYDataset graphDataset = getGraphDataset();
//       
//       JFreeChart chart = ChartFactory.createXYLineChart(
//               "XY Line Chart Example",
//               "X-Axis",
//               "Y-Axis",
//               graphDataset,
//               PlotOrientation.VERTICAL,
//               true, true, false);
//
//        // Create Panel
//        ChartPanel panel = new ChartPanel(chart);
//        setContentPane(panel);
       
   }
   
   private static PieDataset createDataset(){
       DefaultPieDataset dataset = new DefaultPieDataset( );
           
       try {
           Connector conn = new Connector();
           HashMap<String, Integer> matchesHash = conn.getMatchesAnalytics();
           
           for (Map.Entry<String, Integer> entry : matchesHash.entrySet()){
               String key = entry.getKey();
               int value = entry.getValue();
               dataset.setValue(key, new Double(value));
           }
//           
//           dataset.setValue( "Female" , new Double( 50 ) );
//           dataset.setValue( "Male" , new Double( 47 ) );
           //      dataset.setValue( "" , new Double( 40 ) );
           //      dataset.setValue( "" , new Double( 10 ) );
           
           
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(MatchesAnalytics.class.getName()).log(Level.SEVERE, null, ex);
       }
       return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Gender Distribution",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false
      );

      return chart;
   }
   
   public static JPanel createDemoPanel( ){
      JFreeChart chart = createChart(createDataset() );  
      return new ChartPanel( chart ); 
   }
   
   private XYDataset getGraphDataset(){
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
   public static void main( String[ ] args ) {
      MatchesAnalytics demo = new MatchesAnalytics( "Number of tickets per match" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true );
      
//      SwingUtilities.invokeLater(() -> {
//        MatchesAnalytics example = new MatchesAnalytics("XY Chart Example | BORAJI.COM");
//        example.setSize(800, 400);
//        example.setLocationRelativeTo(null);
//        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        example.setVisible(true);
//      });
   }
}
