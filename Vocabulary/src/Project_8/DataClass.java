package Project_8;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DataClass {
	String userName = "";
	String userID = "";
	String userNumber = "";
	MainFrame f;

	DataClass(MainFrame f) {
		this.f = f;
	}

	public void setTable() {

		Svr.enterServer();

		try {
			
			String query = "SELECT * FROM voca WHERE user_number = " + userNumber + " ORDER BY time_ck DESC";
			Svr.stmt = Svr.con.prepareStatement(query);

			DefaultTableModel model2 = (DefaultTableModel) f.tblVoca.getModel();
			model2.setNumRows(0);

			while (Svr.rs.next()) {
				String kanji = Svr.rs.getString(2);
				String hiragana = Svr.rs.getString(3);
				String mean = Svr.rs.getString(4);
				String format = Svr.rs.getString(5);

				f.listRow = new Vector<String>();
				f.listRow.addElement(kanji);
				f.listRow.addElement(hiragana);
				f.listRow.addElement(mean);
				f.listRow.addElement(format);
				f.model.addRow(f.listRow);
			}

		} catch (SQLException sqle) {
			System.out.println("Caugt Exception : " + sqle.getMessage());
		} finally {
			if (Svr.rs != null)
				try {
					Svr.rs.close();
				} catch (SQLException ex) {
				}
			if (Svr.stmt != null)
				try {
					Svr.stmt.close();
				} catch (SQLException ex) {
				}
			if (Svr.con != null)
				try {
					Svr.con.close();
				} catch (SQLException ex) {
				}
		}
	}
}
