import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CostSummary extends JFrame {
	
	Action myAction = new Action(this);
	
	int openTicketCost;
	int closedTicketCost;
	
	public CostSummary() {
		
		setTitle("Summary");
		setSize(600,280);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	
		this.setLayout(new GridLayout(3,0));
		
		JPanel panHead = new JPanel();
			panHead.setLayout(new FlowLayout(1,0,25));
		JPanel panA = new JPanel();
			panA.setLayout(new GridLayout(0,2));
		JPanel panB = new JPanel();
			panB.setLayout(new FlowLayout(1,45,35));
			
		JLabel header = new JLabel("Cost Summary");
			header.setFont(new Font("Serif", Font.BOLD, 25));
			header.setForeground(new Color(600060000));
			this.add(panHead);
			panHead.add(header);
			
		myAction.OpenTicketCost();
		myAction.ClosedTicketCost();
			
		JLabel oT = new JLabel("Open Ticket Cost: ");
			oT.setFont(new Font("Serif", Font.BOLD, 20));
			oT.setHorizontalAlignment(JTextField.RIGHT);
				JTextField openTicket = new JTextField("€ "+openTicketCost*50.0);
					openTicket.setHorizontalAlignment(JTextField.LEFT);
					openTicket.setFont(new Font("Serif", Font.BOLD, 20));
					openTicket.setEditable(false);
					openTicket.setBorder(null);
					panA.add(oT);
					panA.add(openTicket);
					
		JLabel cT = new JLabel("Closed Ticket Cost: ");
			cT.setFont(new Font("Serif", Font.BOLD, 20));
			cT.setHorizontalAlignment(JTextField.RIGHT);
				JTextField closedTicket = new JTextField("€ "+closedTicketCost*50.0);
					closedTicket.setHorizontalAlignment(JTextField.LEFT);
					closedTicket.setFont(new Font("Serif", Font.BOLD, 20));
					closedTicket.setEditable(false);
					closedTicket.setBorder(null);
					panA.add(cT);
					panA.add(closedTicket);
					
		JLabel tT = new JLabel("Total: ");
			tT.setFont(new Font("Serif", Font.BOLD, 20));
			tT.setHorizontalAlignment(JTextField.RIGHT);
				JTextField totalTicket = new JTextField("€ "+closedTicketCost*50.0);
					totalTicket.setHorizontalAlignment(JTextField.LEFT);
					totalTicket.setFont(new Font("Serif", Font.BOLD, 20));
					totalTicket.setForeground(Color.RED);
					totalTicket.setEditable(false);
					totalTicket.setBorder(null);
					panA.add(tT);
					panA.add(totalTicket);
				

			
		JButton okay = new JButton("Okay");
			okay.addActionListener(myAction);
			okay.setActionCommand("okay");
			this.add(okay);
			panB.add(okay);
	
			this.add(panHead);
			this.add(panA);
			this.add(panB);
			
		validate();
		repaint();
			
			
	}
	
	

}
