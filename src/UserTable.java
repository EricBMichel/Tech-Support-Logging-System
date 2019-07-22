import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UserTable extends JFrame{
	
	Action myAction = new Action(this);
	
	JTextField usernameInput = null;
	JTextField passwordInput = null;
	
	JTable table = new JTable();
	String [] colNames = {"User ID", "Username","Role", "Current Password", "Password Request"};
	String [][] data = new String[99][9];
	int counter = 0;
	
	public UserTable() {
		
		setTitle("User Table");
		setSize(500,300);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		this.setLayout(new GridLayout(2,0));
		
		table = new JTable(data, colNames);
		JScrollPane sr = new JScrollPane(table);
			table.getColumnModel().getColumn(0).setPreferredWidth(1);
			table.getColumnModel().getColumn(1).setPreferredWidth(1);
			table.getColumnModel().getColumn(2).setPreferredWidth(1);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(40);
			
		JPanel panA = new JPanel();
			panA.setLayout(new GridLayout(3,2));
		JPanel panA1 = new JPanel();
			panA1.setLayout(new FlowLayout(2,20,5));
		JPanel panA2 = new JPanel();
			panA2.setLayout(new FlowLayout(0,20,10));
		JPanel panA3 = new JPanel();
			panA3.setLayout(new FlowLayout(2,20,5));
		JPanel panA4 = new JPanel();
			panA4.setLayout(new FlowLayout(0,20,10));
		JPanel panA5 = new JPanel();
			panA5.setLayout(new FlowLayout(2,20,0));
		JPanel panA6 = new JPanel();
			panA6.setLayout(new FlowLayout(0,20,0));
		
		JLabel username = new JLabel("Enter username:");
			username.setFont(new Font("Serif", Font.BOLD, 18));
			panA1.add(username);	
			usernameInput = new JTextField(15);
			panA2.add(usernameInput);
			
		JLabel password = new JLabel("Enter new password:");
			password.setFont(new Font("Serif", Font.BOLD, 18));
			panA3.add(password);
			passwordInput = new JTextField(15);
			panA4.add(passwordInput);
			
		JButton update = new JButton("Update User");
			update.addActionListener(myAction);
			update.setActionCommand("updateUser");
			panA5.add(update);
			
		JButton cancel = new JButton("Cancel");
			cancel.addActionListener(myAction);
			cancel.setActionCommand("cancelUserTable");
			panA6.add(cancel);
			
		myAction.ShowTableAdmin();
		this.add(sr);
		this.add(panA);
		panA.add(panA1);
		panA.add(panA2);
		panA.add(panA3);
		panA.add(panA4);
		panA.add(panA5);
		panA.add(panA6);

		
		
		
		
		validate();
		repaint();
	}
	
	

}
