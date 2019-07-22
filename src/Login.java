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
import javax.swing.JTextField;

public class Login extends JFrame {
	
	Action myAction = new Action(this);
	
	JTextField username = null;
	JPasswordField password = null;		
	
	public Login(){

		setTitle("Log In");
		setSize(625,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(5,1));
		
		JPanel panHead = new JPanel();
			panHead.setLayout(new FlowLayout(1,20,25));
		JPanel panA = new JPanel();
			panA.setLayout(new FlowLayout(1,20,25));
		JPanel panB = new JPanel();
			panB.setLayout(new FlowLayout(1,20,25));
		JPanel panC = new JPanel();
			panC.setLayout(new FlowLayout(1,55,30));
		JPanel panD = new JPanel();
				
		JLabel header = new JLabel("Welcome, please log in to continue...");
			header.setFont(new Font("Serif", Font.BOLD, 25));
			header.setForeground(new Color(600060000));
			panHead.add(header);
	
		JLabel un = new JLabel("Username: ");
			un.setFont(new Font("Serif", Font.BOLD, 18));
			username = new JTextField(20);
			panA.add(un);
			panA.add(username);
		
		JLabel pw = new JLabel("Password: ");
			pw.setFont(new Font("Serif", Font.BOLD, 18));
			password = new JPasswordField(20);
			panB.add(pw);
			panB.add(password);
		
		JButton login = new JButton("Login");
			login.addActionListener(myAction);
			login.setActionCommand("login");
			panC.add(login);
			
		JButton forgotPW = new JButton("Request a new password");
			forgotPW.addActionListener(myAction);
			forgotPW.setActionCommand("reset");
			panD.add(forgotPW);
			
			this.add(panHead);
			this.add(panA);
			this.add(panB);
			this.add(panC);
			this.add(panD);
			
		validate();
		repaint();
	}

	
	

}