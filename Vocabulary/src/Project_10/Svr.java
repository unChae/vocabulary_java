package Project_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Svr {

	static Connection con;
	static ResultSet rs;
	static PreparedStatement stmt;
	static Statement stat;

	public static void enterServer() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@ 192.168.0.6:1521:xe", "s1701115", "win126");
		} catch (Exception e) {
		}
	}

	static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
}
