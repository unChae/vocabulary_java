package Project_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Project.GmailSend;

public class LoginClass {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement st;

	boolean overlap = false;
	boolean code = false;
	boolean success = false;

	String userName = null;
	int count = 0;

	LoginClass() {

	}

	public void enterServer() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.26.1.212:1521:xe", "s1701115", "p1701115");
		} catch (Exception e) {
		}
	}

	public void createAccount(String id, String email, String password, String name, String phone) {
		enterServer();
		overlapEmail(id, email);
		if (overlap == true) {
			countMember();
			try {
				emailCheck(id, email);
				if (code == true) {
					String query = "insert into USERINFOR values(?,?,?,?,?,?)";
					st = con.prepareStatement(query);
					st.setString(1, id);
					st.setString(2, email);
					st.setString(3, password);
					st.setString(4, name);
					st.setString(5, phone);
					st.setString(6, count + "");

					st.execute();
					overlap = false;

					JOptionPane.showMessageDialog(null, "Welecome to Vocabulary\nUear : " + name, "Vocabulray",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Please authenticate the code", "Vocabulray",
							JOptionPane.INFORMATION_MESSAGE);
				}
				con.close();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Data inserted fail");
			}
		}
	}

	public void countMember() {
		try {
			String resultID = "NULL";
			String query = "select Max(user_number) from userinfor";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				resultID = (rs.getString("Max(user_number)"));
			}
			count = Integer.parseInt(resultID) + 1;
		} catch (Exception e) {
			count = 1;
		}
	}

	public void overlapEmail(String id, String email) {
		try {
			String resultID = "NULL";
			String query = "select user_email from USERINFOR where user_id = '" + id + "'";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				resultID = rs.getString("user_email");
			}
			if (resultID.equals("NULL")) {
				overlap = true;
			} else {
				resultID = "NULL";
				query = "select user_email from USERINFOR where user_email = '" + email + "'";
				st = con.prepareStatement(query);
				rs = st.executeQuery();
				while (rs.next()) {
					resultID = rs.getString("user_email");
				}
				if (resultID.equals("NULL")) {
					overlap = true;
				} else {
					JOptionPane.showMessageDialog(null, "Account Overlap");
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error : " + e.getMessage());
		}
	}

	public void createTable() {
		try {
			st = (PreparedStatement) con.createStatement();
		      
		      String sql = "CREATE TABLE REGISTRATION " +
		                   "(id INTEGER not NULL, " +
		                   " first VARCHAR(255), " + 
		                   " last VARCHAR(255), " + 
		                   " age INTEGER, " + 
		                   " PRIMARY KEY ( id ))"; 

		      st.executeUpdate(sql);
		}catch(Exception e) {}
	}
	
	public void login(String id, String password) {
		try {
			String result = "NULL";
			enterServer();
			String query = "select USER_PWD from userinfor where concat(concat(user_id,'@'),user_email) = '" + id + "'";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				result = rs.getString("user_pwd");
			}
			if (result.equals(password)) {
				success = true;
				JOptionPane.showMessageDialog(null, id + "\nSuccess Login");
			} else {
				JOptionPane.showMessageDialog(null, "Login Fail");
			}
			userName(id);
			con.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void userName(String id) {
		try {
			String result = "NULL";
			enterServer();
			String query = "select user_name from userinfor where concat(concat(user_id,'@'),user_email) = '" + id + "'";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				result = rs.getString("user_name");
			}
			userName = result;
		} catch (Exception e) {
		}
	}

	public void emailCheck(String id, String email) {
		String emailCheck = id + "@" + email;
		if (overlap == true) {
			GmailSend mail = new GmailSend();
			int randomNo = (int) (Math.random() * 8999 + 1000);
			mail.GmailSet(emailCheck, "Vocabulary", "input this code \n" + randomNo);

			String input = JOptionPane.showInputDialog("Sended Email\nCheck your email");

			if (input.equals(randomNo + "")) {
				JOptionPane.showMessageDialog(null, "Success", "Vocabulray", JOptionPane.INFORMATION_MESSAGE);
				code = true;
			} else {
				JOptionPane.showMessageDialog(null, "Fail", "Vocabulray", JOptionPane.INFORMATION_MESSAGE);
			}
			overlap = false;
		}
	}

}