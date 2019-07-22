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

public class NewUser extends JFrame{
	
	Action myAction = new Action(this);
	
	JTextField usernameInput = null;
	JTextField passwordInput = null;
	String[] roleString = {"Admin", "TechSupp", "Manager"};
	JComboBox selectRole = new JComboBox(roleString);
	
	public NewUser() {
		
		setTitle("New User");
		setSize(500,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		this.setLayout(new GridLayout(4,2));
		
		JPanel panA = new JPanel();
			panA.setLayout(new FlowLayout(2,20,15));
		JPanel panB = new JPanel();
			panB.setLayout(new FlowLayout(3,0,15));
		JPanel panC = new JPanel();
			panC.setLayout(new FlowLayout(2,20,15));
		JPanel panD = new JPanel();
			panD.setLayout(new FlowLayout(3,0,15));	
		JPanel panE = new JPanel();
			panE.setLayout(new FlowLayout(2,20,15));
		JPanel panF = new JPanel();
			panF.setLayout(new FlowLayout(3,0,15));
		JPanel panG = new JPanel();
			panG.setLayout(new FlowLayout(2,5,15));
		JPanel panH = new JPanel();
			panH.setLayout(new FlowLayout(3,5,15));
		
		JLabel username = new JLabel("Set Username:");
			username.setFont(new Font("Serif", Font.BOLD, 18));
			panA.add(username);
			
		usernameInput = new JTextField(15);
			panB.add(usernameInput);
		
		JLabel password = new JLabel("Set Password:");
			password.setFont(new Font("Serif", Font.BOLD, 18));
			panC.add(password);
		
		passwordInput = new JTextField(15);
			panD.add(passwordInput);
			
		JLabel role = new JLabel("Set Role:");
			role.setFont(new Font("Serif", Font.BOLD, 18));
			panE.add(role);
			
		selectRole.setSelectedIndex(-1);
			panF.add(selectRole);
			
		JButton submit = new JButton ("Submit");
			submit.addActionListener(myAction);
			submit.setActionCommand("submitNewUser");
			panG.add(submit);
			
		JButton cancel = new JButton ("Cancel");
			cancel.addActionListener(myAction);
			cancel.setActionCommand("cancelNewUser");
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
