import java.awt.BorderLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Manager extends JFrame {
	
	Action myAction = new Action(this);
	
	JTable table = new JTable();
	String [] colNames = {"Ticket ID", "Staff", "Opened", "Closed"};
	String [][] data = new String[99][9];
	int counter = 0;

	String totalTicketCount = null;
	String openTicketCount = null;
	String closedTicketCount = null;
		
	public Manager() {
		
		setTitle("Manager");
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
			panA.setLayout(new GridLayout(0,2));
		JPanel panB = new JPanel();
			panB.setLayout(new GridLayout(3,2));
		JPanel panC = new JPanel();
			panC.setLayout(new FlowLayout(1,25,50));
	
		JLabel header = new JLabel("Ticket Statistics");
			header.setFont(new Font("Serif", Font.BOLD, 25));
			header.setForeground(new Color(600060000));
			panHead.add(header);
			
		table = new JTable(data, colNames);
		JScrollPane sr = new JScrollPane(table);
			table.getColumnModel().getColumn(0).setPreferredWidth(0);
			table.getColumnModel().getColumn(1).setPreferredWidth(0);
			table.getColumnModel().getColumn(2).setPreferredWidth(70);
			table.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		myAction.CountTotalTickets();myAction.CountOpenTickets();myAction.CountClosedTickets();
			
		JLabel tT = new JLabel("Total Tickets: ");
			tT.setFont(new Font("Serif", Font.BOLD, 15));
			tT.setHorizontalAlignment(JTextField.RIGHT);	
				JTextField totalTicket = new JTextField(totalTicketCount);
					totalTicket.setFont(new Font("Serif", Font.BOLD, 20));
					totalTicket.setEditable(false);
					totalTicket.setBorder(null);
					panB.add(tT);
					panB.add(totalTicket);
					
		JLabel oT = new JLabel("Open Tickets: ");
			oT.setFont(new Font("Serif", Font.BOLD, 15));
			oT.setHorizontalAlignment(JTextField.RIGHT);
				JTextField openTicket = new JTextField(openTicketCount);
					openTicket.setFont(new Font("Serif", Font.BOLD, 20));
					openTicket.setEditable(false);
					openTicket.setBorder(null);
					panB.add(oT);
					panB.add(openTicket);
					
		JLabel cT = new JLabel("Closed Tickets: ");
			cT.setFont(new Font("Serif", Font.BOLD, 15));
			cT.setHorizontalAlignment(JTextField.RIGHT);
				JTextField closedTicket = new JTextField(closedTicketCount);
				closedTicket.setFont(new Font("Serif", Font.BOLD, 20));
				closedTicket.setEditable(false);
					closedTicket.setBorder(null);
					panB.add(cT);
					panB.add(closedTicket);
					
		JButton graphOpen = new JButton("Staff Summary");
			graphOpen.addActionListener(myAction);
			graphOpen.setActionCommand("graph");
			this.add(graphOpen);
			panC.add(graphOpen);
				
		JButton costSum = new JButton("Cost Summary");
			costSum.addActionListener(myAction);
			costSum.setActionCommand("cost");
			panC.add(costSum);
	
		JButton refresh = new JButton("Refresh");
			refresh.addActionListener(myAction);
			refresh.setActionCommand("refresh");
			panC.add(refresh);
			
			this.add(panHead);
			this.add(panA);
			this.add(panB);
			panA.add(sr);
			panA.add(panB);	
			this.add(panC);
			
		myAction.ShowTableManager();
		validate();
		repaint();
		
	}

}