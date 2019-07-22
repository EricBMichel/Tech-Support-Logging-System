import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Action implements ActionListener{
	
	Login login = null;
	TechSupp support = null;
	NewTicket ticket = null;
	Manager manager = null;
	CostSummary cost = null;
	Admin admin = null;
	NewUser newUser = null;
	UserTable userTable = null;
	NewPassword newPassword = null;
	GraphSummary graph = null;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	public Action(Login a1) {
		this.login = a1;
	}
		
	public Action(TechSupp a2) {
		this.support = a2;
	}
	
	public Action(NewTicket a3) {
		this.ticket = a3;
	}
	
	public Action(Manager a4) {
		this.manager = a4;
	}
	
	public Action(CostSummary a5) {
		this.cost = a5;
	}
	
	public Action(Admin a6) {
		this.admin = a6;
	}
	
	public Action(NewUser a7) {
		this.newUser = a7;
	}
	
	public Action(UserTable a8) {
		this.userTable = a8;
	}
	
	public Action(NewPassword a9) {
		this.newPassword = a9;
	}
	
	public Action(GraphSummary a10) {
		this.graph = a10;
	}
	
	
	public void loginDatabase(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}

    	try {
    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
    	    stmt = conn.createStatement();

    	    String un = login.username.getText();
    	    @SuppressWarnings("deprecation")
			String pw = login.password.getText();
    	        	    
    	    if (stmt.execute("SELECT * FROM usertype WHERE username = '"+un+"' and password = '"+pw+"'")) {
    	        rs = stmt.getResultSet();
    	    }
    	
    	    if(rs.next()){
    	    	String role = rs.getString("role");
	
    	    	if (role.equals("TechSupp")) {
    	    		new TechSupp();	
    	    	}
    	    	else if (role.equals("Manager")) {
    	    		new Manager();
    	    	}
    	    	else if (role.equals("SystemAdmin")){
    	    		new Admin();
    	    	}
    	    	
    	    	login.dispose();
    	    	JOptionPane.showMessageDialog(login, "Welcome, "+login.username.getText());
    	    	
    	    } else if(!rs.next()){
	    		JOptionPane.showMessageDialog(login, "Please check your login details and try again");
	    	}
    	    
    	    
    	} catch (SQLException ex) {
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}	
	}
	
	public void AddTicket() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
		
			String des = ticket.description.getText();
			String stff = ticket.staff.getSelectedItem().toString();
			String prior = ticket.priority.getSelectedItem().toString();	
  	    
  	    if (stmt.execute("INSERT INTO `ca_gui`.`tickets` (`description`, `staff`, `priority`) VALUES ('"+des+"', '"+stff+"','"+prior+"');")) { 
  	    }
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void AddUser() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
		
			
			String un = newUser.usernameInput.getText();
			String pw = newUser.passwordInput.getText();
			String role = newUser.selectRole.getSelectedItem().toString();

  	    if (stmt.execute("INSERT INTO `ca_gui`.`usertype` (`username`, `password`, `role`) VALUES ('"+un+"', '"+pw+"','"+role+"');")) {
  	        
  	    }
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void ShowTableManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ticket_ID, staff, DATE_FORMAT(time_opened, '%d/%m/%Y   %H:%i') AS time_opened, "
					+ "DATE_FORMAT(time_closed, '%d/%m/%Y   %H:%i') AS time_closed FROM tickets");
			
			while(rs.next()){
				String id = rs.getString("ticket_ID");
					manager.data[manager.counter][0]=id;
				String stf = rs.getString("staff");
					manager.data[manager.counter][1]=stf;
				String opened = rs.getString("time_opened");
					manager.data[manager.counter][2]=opened;
				String closed = rs.getString("time_closed");
					manager.data[manager.counter][3]=closed;
					    	        
					manager.counter = manager.counter + 1;
			}
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}
	
	public void ShowTableTechSupp() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select ticket_ID, description, priority, staff, status, DATE_FORMAT(time_opened, '%d/%m/%Y   %H:%i') AS time_opened from tickets;");
			
			while(rs.next()){
				String id = rs.getString("ticket_ID");
					support.data[support.counter][0]=id;
				String dis = rs.getString("description");
					support.data[support.counter][1]=dis;
				String prior = rs.getString("priority");
					support.data[support.counter][2]=prior;
				String stf = rs.getString("staff");
					support.data[support.counter][3]=stf;
				String sts = rs.getString("status");
					support.data[support.counter][4]=sts;
				String time = rs.getString("time_opened");
					support.data[support.counter][5]=time;
					    	        
				support.counter = support.counter + 1;
			}
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}
	
	public void ShowTableAdmin() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM usertype;");
			
			while(rs.next()){
				String id = rs.getString("user_ID");
					userTable.data[userTable.counter][0]=id;
				String un = rs.getString("username");
					userTable.data[userTable.counter][1]=un;
				String role = rs.getString("role");
					userTable.data[userTable.counter][2]=role;
				String pw = rs.getString("password");
					userTable.data[userTable.counter][3]=pw;
				String pwreq = rs.getString("password_request");
					userTable.data[userTable.counter][4]=pwreq;
					    	        
					userTable.counter = userTable.counter + 1;
			}
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public void UpdatUser() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			
			String un = userTable.usernameInput.getText();
	    	String pw = userTable.passwordInput.getText();
			
			int column = 0;
			int row = userTable.table.getSelectedRow();
			String staffID = userTable.table.getModel().getValueAt(row, column).toString();

	    if (stmt.execute("UPDATE `ca_gui`.`usertype` SET `username`='"+un+"', `password`='"+pw+"' WHERE  `user_ID`='"+staffID+"';")) {
	        
	   }
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CloseTicket() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			
			int column = 0;
			int row = support.table.getSelectedRow();
			String tickID = support.table.getModel().getValueAt(row, column).toString();

	    if (stmt.execute("UPDATE `ca_gui`.`tickets` SET `status`='CLOSED' WHERE `ticket_ID` = '"+tickID+"'")) {
	        
	    }
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
		
	}

	public void DeleteTicket() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			
			int column = 0;
			int row = support.table.getSelectedRow();
			String tickID = support.table.getModel().getValueAt(row, column).toString();

	    if (stmt.execute("DELETE FROM `ca_gui`.`tickets` WHERE  `ticket_ID`='"+tickID+"'")) {
	        
	    }
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
		
	}
	
	public void CountTotalTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(ticket_ID) FROM tickets");
	    
	    while(rs.next()) {
	    	manager.totalTicketCount = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountOpenTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(ticket_ID) FROM tickets WHERE status = 'Open'");
	    
	    while(rs.next()) {
	    	manager.openTicketCount = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountClosedTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(ticket_ID) FROM tickets WHERE status = 'CLOSED'");
	    
	    while(rs.next()) {
	    	manager.closedTicketCount = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void OpenTicketCost() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(ticket_ID) FROM tickets WHERE status = 'Open'");
	    
	    while(rs.next()) {
	    	cost.openTicketCost = rs.getInt(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void ClosedTicketCost() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(ticket_ID) FROM tickets WHERE status = 'CLOSED'");
	    
	    while(rs.next()) {
	    	cost.closedTicketCost = rs.getInt(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJohnTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'John';");
			
	    
	    while(rs.next()) {
	    	graph.johnTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJamesTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'James';");
			
	    
	    while(rs.next()) {
	    	graph.jamesTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJohanTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'Johan';");
			
	    
	    while(rs.next()) {
	    	graph.johanTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJohnOpenTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'John' AND status = 'Open';");
			
	    
	    while(rs.next()) {
	    	graph.johnOpenTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}

	public void CountJohnClosedTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'John' AND status = 'Closed';");
			
	    
	    while(rs.next()) {
	    	graph.johnClosedTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJamesOpenTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'James' AND status = 'Open';");
			
	    
	    while(rs.next()) {
	    	graph.jamesOpenTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJamesClosedTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'James' AND status = 'Closed';");
			
	    
	    while(rs.next()) {
	    	graph.jamesClosedTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJohanOpenTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'Johan' AND status = 'Open';");
			
	    
	    while(rs.next()) {
	    	graph.johanOpenTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void CountJohanClosedTickets() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(staff) FROM tickets WHERE staff = 'Johan' AND status = 'Closed';");
			
	    
	    while(rs.next()) {
	    	graph.johanClosedTicket = rs.getString(1);
	    }
	
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	public void PasswordRequest() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		try{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ca_gui?user=root&password=");
			stmt = conn.createStatement();
			
			String un = newPassword.username.getText();
	    	String pw = newPassword.password.getText();

	    	if (stmt.execute("UPDATE `ca_gui`.`usertype` SET `password_request` = '"+pw+"' WHERE username = '"+un+"';")) {
	    		
	  	    }
	    	JOptionPane.showMessageDialog(newPassword, "A request has been sent to the System Admistrator");
			newPassword.dispose();
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}	
	}
	
@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("login")){
			if(login.password.getText().equals("")||login.username.getText().equals("")) {
				JOptionPane.showMessageDialog(login, "Please ensure all fields have been filled");
			}else {
				loginDatabase();				
				}
		}
		if(e.getActionCommand().equals("reset")){
			new NewPassword();
		}

		if(e.getActionCommand().equals("newTicket")) {
			support.dispose();
			new NewTicket();
			
		}
		if(e.getActionCommand().equals("submitTicket")){
			if(ticket.staff.getSelectedIndex() == -1 ) {
				JOptionPane.showMessageDialog(ticket, "Please assign a staff member");
			}
			else if(ticket.description.getText().equals("")) {
					JOptionPane.showMessageDialog(ticket, "Please enter a description");
			}else {
				AddTicket();
				ticket.dispose();
				new TechSupp();
				JOptionPane.showMessageDialog(ticket, "Ticket Submitted");
			}			
		}
		if(e.getActionCommand().equals("cancelTicket")){
			ticket.dispose();
			new TechSupp();
		}
		if(e.getActionCommand().equals("closeTicket" )||e.getActionCommand().equals("deleteTicket" )) {
			if(support.table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(support, "Please select a ticket first");
			}else if(e.getActionCommand().equals("deleteTicket" )) {
				int n = JOptionPane.showConfirmDialog(
						support, 
						"Delete ticket?", 
						"Confirmation", 
						JOptionPane.YES_NO_OPTION);
				if(n==0) {
					DeleteTicket();
					support.dispose();
					new TechSupp();
				}
			}else {
				int n = JOptionPane.showConfirmDialog(
						support, 
						"Close ticket?", 
						"Confirmation", 
						JOptionPane.YES_NO_OPTION);
				if(n==0) {
					CloseTicket();
					support.dispose();
					new TechSupp();
				}
			}	
		}
		
		if(e.getActionCommand().equals("graph")){
			new GraphSummary();
		}
		if(e.getActionCommand().equals("cost")){
			new CostSummary();
		}
		if(e.getActionCommand().equals("okay")){
			cost.dispose();
		}
		if(e.getActionCommand().equals("refresh")){
			manager.dispose();
			new Manager();
		}
		
		if(e.getActionCommand().equals("userTable")){
			new UserTable();
		}
		if(e.getActionCommand().equals("cancelUserTable")){
			userTable.dispose();
		}
		if(e.getActionCommand().equals("createNewUser")){
			new NewUser();
		}
		if(e.getActionCommand().equals("cancelNewUser")){
			newUser.dispose();
		}
		if(e.getActionCommand().equals("submitNewUser")){
			if(newUser.usernameInput.getText().equals("")) {
					JOptionPane.showMessageDialog(newUser, "Please enter a Username");
			}else if(newUser.passwordInput.getText().equals("")) {
					JOptionPane.showMessageDialog(newUser, "Please enter a Password");
			}else if(newUser.selectRole.getSelectedIndex() == -1 ) {
				JOptionPane.showMessageDialog(newUser, "Please assign a Role");
			}else {
				AddUser();
				newUser.dispose();
				new UserTable();
				JOptionPane.showMessageDialog(newUser, "User has been submitted");
			}			
		}
		if(e.getActionCommand().equals("updateUser")){
			if(userTable.table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(support, "Please select a user first");
			}else if(userTable.usernameInput.getText().equals("")||userTable.passwordInput.getText().equals("")) {
				JOptionPane.showMessageDialog(userTable, "Enter a Username AND Password");
			}else {
				int n = JOptionPane.showConfirmDialog(
						userTable, 
						"Update user profile?", 
						"Confirmation", 
						JOptionPane.YES_NO_OPTION);
				if(n==0) {
					UpdatUser();
					userTable.dispose();
					new UserTable();
					JOptionPane.showMessageDialog(userTable, "Profile has been updated");
				}
			}
		}

		if(e.getActionCommand().equals("newPasswordSubmit")){
			if(newPassword.password.getText().equals("")||newPassword.username.getText().equals("")) {
				JOptionPane.showMessageDialog(newPassword, "Please ensure all fields have been filled");
			}else {
				PasswordRequest();
			}	
		}
		if(e.getActionCommand().equals("newPasswordCancel")){
			newPassword.dispose();
		}
		
		if(e.getActionCommand().equals("logout")){
			int n = JOptionPane.showConfirmDialog(
					login, 
					"Log out?", 
					"Confirmation", 
					JOptionPane.YES_NO_OPTION);
			if(n==0) {
				System.exit(1); 
			}
		}
	
	}

}
