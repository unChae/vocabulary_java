package Project_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Project.GmailSend;

public class LoginClass {
	
	boolean overlap = false;
	boolean code = false;
	boolean success = false;

	String userName = null;
	int count = 0;

	LoginClass() {

	}

	public void createAccount(String id, String email, String password, String name, String phone) {
		Svr.enterServer();
		overlapEmail(id, email);
		if (overlap == true) {
			countMember();
			try {
				emailCheck(id, email);
				if (code == true) {
					String query = "insert into USERINFOR values(?,?,?,?,?,?)";
					Svr.stmt = Svr.con.prepareStatement(query);
					Svr.stmt.setString(1, id);
					Svr.stmt.setString(2, email);
					Svr.stmt.setString(3, password);
					Svr.stmt.setString(4, name);
					Svr.stmt.setString(5, phone);
					Svr.stmt.setString(6, count + "");

					Svr.stmt.execute();

					overlap = false;

					JOptionPane.showMessageDialog(null, "Welecome to Vocabulary\nUear : " + name, "Vocabulray",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Please authenticate the code", "Vocabulray",
							JOptionPane.INFORMATION_MESSAGE);
				}
				Svr.con.close();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Data inserted fail");
			}
		}
	}

	public void countMember() {
		try {
			String resultID = "NULL";
			String query = "select Max(user_number) from userinfor";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				resultID = (Svr.rs.getString("Max(user_number)"));
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
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				resultID = Svr.rs.getString("user_email");
			}
			if (resultID.equals("NULL")) {
				overlap = true;
			} else {
				resultID = "NULL";
				query = "select user_email from USERINFOR where user_email = '" + email + "'";
				Svr.stmt = Svr.con.prepareStatement(query);
				Svr.rs = Svr.stmt.executeQuery();
				while (Svr.rs.next()) {
					resultID = Svr.rs.getString("user_email");
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

	public void login(String id, String password) {
		try {
			String result = "NULL";
			Svr.enterServer();
			String query = "select USER_PWD from userinfor where concat(concat(user_id,'@'),user_email) = '" + id + "'";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				result = Svr.rs.getString("user_pwd");
			}
			if (result.equals(password)) {
				success = true;
				JOptionPane.showMessageDialog(null, id + "\nSuccess Login");
			} else {
				JOptionPane.showMessageDialog(null, "Login Fail");
			}
			userName(id);
			Svr.con.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void userName(String id) {
		try {
			String result = "NULL";
			Svr.enterServer();
			String query = "select user_name from userinfor where concat(concat(user_id,'@'),user_email) = '" + id
					+ "'";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				result = Svr.rs.getString("user_name");
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