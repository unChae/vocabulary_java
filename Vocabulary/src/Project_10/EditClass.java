package Project_10;

import javax.swing.JOptionPane;

public class EditClass {

	DataClass data;

	EditClass(DataClass data) {
		this.data = data;
	}
	
	public void insertData(String kanji, String hiragana, String mean, String format) {
		try {
			
			Svr.enterServer();
			String query = "insert into VOCA values(?,?,?,?,?,?)";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.stmt.setString(1, data.userNumber);
			Svr.stmt.setString(2, kanji);
			Svr.stmt.setString(3, hiragana);
			Svr.stmt.setString(4, mean);
			Svr.stmt.setString(5, format);
			Svr.stmt.setTimestamp(6, Svr.getCurrentTimeStamp());
			
			Svr.stmt.execute();

			Svr.con.close();

			data.setTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
