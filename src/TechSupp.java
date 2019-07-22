import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TechSupp extends JFrame{
	
	Action myAction = new Action(this);	
	
	JTable table = new JTable();
	String [] colNames = {"Ticket ID", "Description", "Priority", "Staff", "Status", "Time Opened",};
	String [][] data = new String[99][9];
	int counter = 0;

	public TechSupp() {
		
		setTitle("Tech Support");
		setSize(700,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
			
		this.setLayout(new GridLayout(3,0));
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
			JMenu options = new JMenu ("Options");
				menuBar.add(options);
				JMenuItem logout = new JMenuItem("Log Out");
					options.add(logout);
					logout.addActionListener(myAction);
					logout.setActionCommand("logout");
			
		JPanel panHead = new JPanel();
			panHead.setLayout(new FlowLayout(1,20,45));
		JPanel panA = new JPanel();
			panA.setLayout(new FlowLayout(1,20,35));
	
		JLabel header = new JLabel("Ticket Status");
			header.setFont(new Font("Serif", Font.BOLD, 25));
			header.setForeground(new Color(600060000));
			panHead.add(header);
			
		table = new JTable(data, colNames);
		JScrollPane sr = new JScrollPane(table);
			table.getColumnModel().getColumn(0).setPreferredWidth(1);
			table.getColumnModel().getColumn(1).setPreferredWidth(180);
			table.getColumnModel().getColumn(2).setPreferredWidth(1);
			table.getColumnModel().getColumn(3).setPreferredWidth(1);
			table.getColumnModel().getColumn(4).setPreferredWidth(1);
			
		JButton newTicket = new JButton("New Ticket");
			newTicket.addActionListener(myAction);
			newTicket.setActionCommand("newTicket");
			panA.add(newTicket);
		
		JButton closeTicket = new JButton("Close Ticket");
			closeTicket.addActionListener(myAction);
			closeTicket.setActionCommand("closeTicket");
			panA.add(closeTicket);
			
		JButton deleteTicket = new JButton("Delete Ticket");
			deleteTicket.addActionListener(myAction);
			deleteTicket.setActionCommand("deleteTicket");
			panA.add(deleteTicket);
			
			this.add(panHead);
			this.add(sr);
			this.add(panA);
			
		myAction.ShowTableTechSupp();
		validate();
		repaint();			
}
	
}
