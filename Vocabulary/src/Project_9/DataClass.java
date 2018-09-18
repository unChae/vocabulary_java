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

			// ����ڰ� ������ ���� �ܾ ������ ã�ƿ´�.
			// �׷��� DB���� �ܾ ã�Ƽ� ������ ������ �� �����Ƿ� !!
			// �ٵ� ������ ���ڳ� īŸī���� ���� ���󰡳��� �游 �ִ� �ܾ �ִ�.
			// �׷����� 2��° �÷��� ���� ã�Ƽ� �����Ѵ�.
			Object valHiragana = f.tblVoca.getValueAt(row, 1);
			Object valMean = f.tblVoca.getValueAt(row, 2);
					
			// ù��° �÷��� �ܾ ���� �� �ִ�.
			// �׷��� value���� ����� ���� ������ �Ǿ�������
			// ������ ���� ù��° �÷����� ���ؼ� DB�� ���� �����ϰ�
			// �׷��� �������� 2��° �÷�, 3��° �÷��� ���ؼ� �����Ѵ�.
			// ���󰡳��� ������찡 ���� �� ������ ����� ���ϰڴٴ� ��
			if (valHiragana != null) {
				String selectHiragana = valHiragana.toString();
				String selectMean = valMean.toString();
				String deleteQuary = "DELETE FROM voca WHERE hiragana = ? AND mean = ?";

				try {
					Svr.enterServer();
					Svr.stmt = Svr.con.prepareStatement(deleteQuary);
					Svr.stmt.setString(1, selectHiragana);
					Svr.stmt.setString(2, selectMean);

					// stmt ����
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
