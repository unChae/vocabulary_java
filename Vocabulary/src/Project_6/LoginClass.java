package Project_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Project.GmailSend;

public class LoginClass {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement stmt;
	private Statement stat;
	
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
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.26.1.11:1521:xe", "s1701115", "p1701115");
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
					stmt = con.prepareStatement(query);
					stmt.setString(1, id);
					stmt.setString(2, email);
					stmt.setString(3, password);
					stmt.setString(4, name);
					stmt.setString(5, phone);
					stmt.setString(6, count + "");

					stmt.execute();

					createTable(count, id);
					
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
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
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
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				resultID = rs.getString("user_email");
			}
			if (resultID.equals("NULL")) {
				overlap = true;
			} else {
				resultID = "NULL";
				query = "select user_email from USERINFOR where user_email = '" + email + "'";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
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

	public void createTable(int id, String email) {
		JOptionPane.showMessageDialog(null, id);
		JOptionPane.showMessageDialog(null, email);
		try {
			
			stat = con.createStatement();
			
			String sql = "CREATE TABLE " + email + "_" + id +  "(" + 
			"KANJI VARCHAR2(20)," + 
			"HIRAGANA VARCHAR2(20) NOT NULL," + 
			"MEAN VARCHAR2(20) NOT NULL,"+ 
			"SHAPE VARCHAR2(20),"+
			"TIMES TIMESTAMP NOT NULL)";

			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login(String id, String password) {
		try {
			String result = "NULL";
			enterServer();
			String query = "select USER_PWD from userinfor where concat(concat(user_id,'@'),user_email) = '" + id + "'";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
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
			String query = "select user_name from userinfor where concat(concat(user_id,'@'),user_email) = '" + id
					+ "'";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
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