import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphSummary extends JFrame {
	
	Action myAction = new Action(this);
	
	String johnTicket = null;String johnOpenTicket = null;String johnClosedTicket = null;
	String jamesTicket = null;String jamesClosedTicket = null;String jamesOpenTicket = null;
	String johanTicket = null;String johanClosedTicket = null;String johanOpenTicket = null;
	
	public GraphSummary() {
		setTitle("Staff Summary - Open Tickets");
		setSize(400,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new GridLayout(3,1));

		myAction.CountJohnTickets();myAction.CountJohnOpenTickets();myAction.CountJohnClosedTickets();
		myAction.CountJamesTickets();myAction.CountJamesOpenTickets();myAction.CountJamesClosedTickets();
		myAction.CountJohanTickets();myAction.CountJohanOpenTickets();myAction.CountJohanClosedTickets();
	
		int johnA = Integer.parseInt(johnOpenTicket);int johnB = Integer.parseInt(johnClosedTicket);int johnC = Integer.parseInt(johnTicket);
		int jamesA = Integer.parseInt(jamesOpenTicket);int jamesB = Integer.parseInt(jamesClosedTicket);int jamesC = Integer.parseInt(jamesTicket);
		int johanA = Integer.parseInt(johanOpenTicket);int johanB = Integer.parseInt(johanClosedTicket);int johanC = Integer.parseInt(johanTicket);

		DefaultCategoryDataset openBarChart = new DefaultCategoryDataset();
			openBarChart.setValue(johnA, "Open Tickets", "John");
			openBarChart.setValue(jamesA, "Open Tickets", "James");
			openBarChart.setValue(johanA, "Open Tickets", "Johan");
		DefaultCategoryDataset closedBarChart = new DefaultCategoryDataset();
			closedBarChart.setValue(johnB, "Closed Tickets", "John");
			closedBarChart.setValue(jamesB, "Closed Tickets", "James");
			closedBarChart.setValue(johanB, "Closed Tickets", "Johan");
		DefaultCategoryDataset totalBarChart = new DefaultCategoryDataset();
			totalBarChart.setValue(johnC, "Total Tickets", "John");
			totalBarChart.setValue(jamesC, "Total Tickets", "James");
			totalBarChart.setValue(johanC, "Total Tickets", "Johan");
			
		JFreeChart chart = ChartFactory.createBarChart("Staff Productivity - Open Tickets", "Staff", "Open Tickets", 
				openBarChart, PlotOrientation.VERTICAL,	false, true, false);
		JFreeChart chart2 = ChartFactory.createBarChart("Staff Productivity - Closed Tickets", "Staff", "Closed Tickets", 
				closedBarChart, PlotOrientation.VERTICAL, false, true, false);
		JFreeChart chart3 = ChartFactory.createBarChart("Staff Productivity - Total Tickets", "Staff", "Total Tickets", 
				totalBarChart, PlotOrientation.VERTICAL, false, true, false);
		
		CategoryPlot p = chart.getCategoryPlot();
			p.setRangeGridlinePaint(Color.black);
		
		ChartPanel chartpanel = new ChartPanel(chart);
		ChartPanel chartpanel2 = new ChartPanel(chart2);
		ChartPanel chartpanel3 = new ChartPanel(chart3);
			
		JPanel panelChart = new JPanel();
			panelChart.setLayout(new BorderLayout());
			panelChart.add(chartpanel, BorderLayout.CENTER);
		JPanel panelChart2 = new JPanel();
			panelChart2.setLayout(new BorderLayout());
			panelChart2.add(chartpanel2, BorderLayout.CENTER);
		JPanel panelChart3 = new JPanel();
			panelChart3.setLayout(new BorderLayout());
			panelChart3.add(chartpanel3, BorderLayout.CENTER);
			
			this.add(panelChart);
			this.add(panelChart2);
			this.add(panelChart3);
			
			validate();
			repaint();
}
	

}
