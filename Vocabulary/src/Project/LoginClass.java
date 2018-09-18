package Project;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginClass {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement st;
	boolean overlap = false;
	boolean code = false;

	public LoginClass() {

	}

	public void enterServer() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.26.3.2:1521:xe", "s1701115", "p1701115");
		} catch (Exception e) {
		}
	}

	public void newAcount(String email, String password, String name, String phone) {
		try {
			enterServer();
			// test connection now
			// create sql table now
			// we have S entries

			String query = "insert into USERINFOR values(?,?,?,?,?)";
			st = con.prepareStatement(query);
			st.setString(1, "1");
			st.setString(2, email);
			st.setString(3, password);
			st.setString(4, name);
			st.setString(5, phone);

			st.execute();

			JOptionPane.showMessageDialog(null, "Welecome to Vocabulary\nUear : " + name, "Vocabulray",
					JOptionPane.INFORMATION_MESSAGE);

			con.close();
			// display massage if data enterred
			JOptionPane.showMessageDialog(null, "Data inserted sucessfully");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Data inserted fail");
		}
	}

	public void checkAcount(String id) {
		try {
			enterServer();
			String resultID = "NULL";
			String query = "select user_email from USERINFOR where user_email = '" + id + "'";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				resultID = rs.getString("user_email");
			}
			if (resultID.equals("NULL")) {
				overlap = true;
			} else {
				JOptionPane.showMessageDialog(null, "Acount Overlap");
			}
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error : " + e.getMessage());
		}
	}

	public void login(String email, String password, CardLayout cardManager, JPanel bgPanel) {
		try {
			String resultPWD = "";
			enterServer();
			String query = "select user_pwd from userinfor where user_email = '" + email + "'";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				resultPWD = rs.getString("user_pwd");
			}
			if (resultPWD.equals(password)) {
				cardManager.show(bgPanel, "main");
				JOptionPane.showMessageDialog(null, email + " Success Login");
			} else {
				JOptionPane.showMessageDialog(null, "Login Fail");
			}
			con.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
