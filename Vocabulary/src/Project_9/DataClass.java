package Project_9;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class DataClass {
	//Userdata
	String userName = "";
	String userID = "";
	String userNumber = "";
	
	//Quiz
	String strQuiz[][];
	String strExam[] = new String[4];
	String answer = "";
	int score = 0;
	int cntQuit = 1;
	
	MainFrame f;	
	DataClass(MainFrame f) {
		this.f = f;
	}

	public void setTable() {

		Svr.enterServer();

		try {

			String query = "SELECT * FROM voca WHERE user_number = " + userNumber + " ORDER BY time_ck DESC";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();

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

	public void delVoca() {
		int row = f.tblVoca.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Select del voca", "Vocabulray", JOptionPane.INFORMATION_MESSAGE);
		} else {

			// 사용자가 선택한 행의 단어만 무조건 찾아온다.
			// 그래야 DB에서 단어를 찾아서 그행을 삭제할 수 있으므로 !!
			// 근데 문제가 한자나 카타카나가 없고 히라가나랑 뜻만 있는 단어가 있다.
			// 그럴경우는 2번째 컬럼의 값을 찾아서 삭제한다.
			Object valHiragana = f.tblVoca.getValueAt(row, 1);
			Object valMean = f.tblVoca.getValueAt(row, 2);
					
			// 첫번째 컬럼에 단어가 없을 수 있다.
			// 그래서 value값에 제대로 값이 저장이 되어있으면
			// 선택한 행의 첫번째 컬럼값을 통해서 DB의 행을 삭제하고
			// 그렇지 않을경우는 2번째 컬럼, 3번째 컬럼을 비교해서 삭제한다.
			// 히라가나가 같은경우가 있을 수 있으니 뜻까지 비교하겠다는 말
			if (valHiragana != null) {
				String selectHiragana = valHiragana.toString();
				String selectMean = valMean.toString();
				String deleteQuary = "DELETE FROM voca WHERE hiragana = ? AND mean = ?";

				try {
					Svr.enterServer();
					Svr.stmt = Svr.con.prepareStatement(deleteQuary);
					Svr.stmt.setString(1, selectHiragana);
					Svr.stmt.setString(2, selectMean);

					// stmt 실행
					Svr.stmt.executeUpdate();

					setTable();
					Svr.con.close();
				} catch (SQLException sqle) {
					System.out.println("Caugt Exception : " + sqle.getMessage());
				}
			}
		}
	}

	public void filter(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(f.model);
		f.tblVoca.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
}
