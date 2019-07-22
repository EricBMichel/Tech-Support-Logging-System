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

public class Admin extends JFrame{
	
	Action myAction = new Action(this);
	
	public Admin () {
		
		setTitle("Admin Support");
		setSize(500,250);
		setVisible(true);
		setLocationRelativeTo(null);
		
		this.setLayout(new GridLayout(3,0));
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
			JMenu options = new JMenu("Options");
			menuBar.add(options);
				JMenuItem logout = new JMenuItem("Log Out");
					options.add(logout);
					logout.addActionListener(myAction);
					logout.setActionCommand("logout");
		
		JPanel panHead = new JPanel();
			panHead.setLayout(new FlowLayout(1,20,15));
		JPanel panA = new JPanel();
			panA.setLayout(new FlowLayout(1,20,15));
		JPanel panB = new JPanel();
			panB.setLayout(new FlowLayout(1,20,15));
				
		JLabel header = new JLabel("System Administration");
			header.setFont(new Font("Serif", Font.BOLD, 25));
			header.setForeground(new Color(600060000));
			panHead.add(header);
			
		JButton userTable = new JButton("Show Users Table");
			panA.add(userTable);
			userTable.addActionListener(myAction);
			userTable.setActionCommand("userTable");
			
		JButton newUser = new JButton("Add New User To System");
			panB.add(newUser);
			newUser.addActionListener(myAction);
			newUser.setActionCommand("createNewUser");

		
		this.add(panHead);
		this.add(panA);
		this.add(panB);

		validate();
		repaint();
	}

}
