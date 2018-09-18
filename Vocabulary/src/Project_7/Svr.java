package Project_7;

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
			con = DriverManager.getConnection("jdbc:oracle:thin:@ 172.26.3.170:1521:xe", "s1701115", "p1701115");
		} catch (Exception e) {
		}
	}
}
