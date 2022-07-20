package kata4view;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import kata4model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    private final Histogram histogram;
    public HistogramDisplay(Histogram histogram) {
        super("HISTOGRAM");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel() {
        //creamo un grafico
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500, 400));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart",
                "Dominios emails x", "Nº email y", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return chart;        
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Object key : histogram.keySet()) {
            dataSet.addValue(this.histogram.getMap(key), "", key.toString());
            return dataSet;
        }
        dataSet.addValue(150, "", "gmail.com");
        dataSet.addValue(50, "", "ulpgc.com");
        dataSet.addValue(220, "", "dis.ulpgc.com");
        dataSet.addValue(250, "", "hotmail.es");
        return dataSet;
    }
    
}
