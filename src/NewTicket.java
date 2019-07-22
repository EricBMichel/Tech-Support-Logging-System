import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewTicket extends JFrame{
	
	Action myAction = new Action(this);
	
	String[] staffString = {"John", "James", "Johan"};
	String[] priorityString = {"Urgent", "Normal", "Long Term"};
	String status = null;
	JTextField description = null;
	JComboBox staff = new JComboBox(staffString);
	JComboBox priority = new JComboBox(priorityString);
	
public NewTicket() {
		
		setTitle("New Ticket");
		setSize(550,300);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		this.setLayout(new GridLayout(4,0));
		
		JPanel panA = new JPanel();
			panA.setLayout(new FlowLayout(0,20,25));
		JPanel panB = new JPanel();
			panB.setLayout(new FlowLayout(0,20,25));
		JPanel panC = new JPanel();
			panC.setLayout(new FlowLayout(0,20,25));
		JPanel panD = new JPanel();
			panD.setLayout(new FlowLayout(0,20,25));
		JPanel panE = new JPanel();
			panE.setLayout(new FlowLayout(0,20,25));
		JPanel panF = new JPanel();
			panF.setLayout(new FlowLayout(0,20,25));
		JPanel panG = new JPanel();
			panG.setLayout(new FlowLayout(4,20,25));	
		JPanel panH = new JPanel();
			panH.setLayout(new FlowLayout(0,20,25));
	
		JLabel selectStaff = new JLabel("Assign a certain staff member:");
			selectStaff.setFont(new Font("Serif", Font.BOLD, 18));
			panA.add(selectStaff);
			
		staff.setSelectedIndex(-1);
			panB.add(staff);
			
		JLabel selectProirity = new JLabel("Assign priority:");
			selectProirity.setFont(new Font("Serif", Font.BOLD, 18));
			panC.add(selectProirity);
			
		priority.setSelectedIndex(1);
			panD.add(priority);
				
		JLabel selectDescription = new JLabel("Description of problem:");
			selectDescription.setFont(new Font("Serif", Font.BOLD, 18));
			panE.add(selectDescription);
			
		description = new JTextField(22);
			panF.add(description);
			
		JButton submit = new JButton("Submit Ticket");
			submit.addActionListener(myAction);
			submit.setActionCommand("submitTicket");
			panG.add(submit);
			
		JButton cancel = new JButton("Cancel");
			cancel.addActionListener(myAction);
			cancel.setActionCommand("cancelTicket");
			panH.add(cancel);
			
			this.add(panA);
			this.add(panB);
			this.add(panC);
			this.add(panD);
			this.add(panE);
			this.add(panF);
			this.add(panG);
			this.add(panH);

		validate();
		repaint();
	}

}
