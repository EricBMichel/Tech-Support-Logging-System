import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewPassword extends JFrame {
	
	Action myAction = new Action(this);
	
	JTextField username = null;
	JTextField password = null;
	
	public NewPassword () {
		
		setSize(400,250);
		setUndecorated(true);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		this.setLayout(new GridLayout(3,0));
		
		JPanel panA = new JPanel();
			panA.setLayout(new FlowLayout(2,10,50));
		JPanel panB = new JPanel();
			panB.setLayout(new FlowLayout(2,10,50));
		JPanel panC = new JPanel();
			panC.setLayout(new FlowLayout(1,25,30));
	
			
		JLabel un = new JLabel("Username: ");
			un.setFont(new Font("Serif", Font.BOLD, 18));
			username = new JTextField(20);
			panA.add(un);
			panA.add(username);
		
		JLabel pw = new JLabel("New Password: ");
			pw.setFont(new Font("Serif", Font.BOLD, 18));
			password = new JPasswordField(20);
			panB.add(pw);
			panB.add(password);
			
		JButton submit = new JButton("Submit");
			submit.addActionListener(myAction);
			submit.setActionCommand("newPasswordSubmit");
			panC.add(submit);
		JButton cancel = new JButton("Cancel");
			cancel.addActionListener(myAction);
			cancel.setActionCommand("newPasswordCancel");
			panC.add(cancel);
			
			
		this.add(panA);
		this.add(panB);
		this.add(panC);
		
		validate();
		repaint();
		
	}

}
