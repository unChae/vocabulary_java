package Project_11;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class WidgetClass {
	int count = 1;
	int max = 0;
	String format;
	JLabel lblNumber;
	JLabel lblKanji;
	JLabel lblHiragana;
	JLabel lblMean;
	JComboBox cmbFormat;
	DataClass data;

	WidgetClass(DataClass data, JLabel lblNumber, JLabel lblKanji, JLabel lblHiragana, JLabel lblMean,
			JComboBox cmbFormat) {
		this.data = data;
		this.lblNumber = lblNumber;
		this.lblKanji = lblKanji;
		this.lblHiragana = lblHiragana;
		this.lblMean = lblMean;
		this.cmbFormat = cmbFormat;

		openData();
	}

	public void openData() {
		format = cmbFormat.getSelectedItem().toString();
		findMax();
		Svr.enterServer();
		try {
			String rsKanji = "NULL";
			String rsHiragana = "NULL";
			String rsMean = "NULL";
			String query = "SELECT NVL(KANJI, 'NoDATA'), NVL(HIRAGANA, 'NoDATA'), NVL(MEAN, 'NoDATA') FROM (SELECT ROWNUM AS COUNT, KANJI, HIRAGANA, MEAN from VOCA WHERE VOCA.USER_NUMBER = '"
					+ data.userNumber + "' AND VOCA.SHAPE = '" + format + "' ORDER BY VOCA.TIME_CK) WHERE COUNT = "
					+ count;
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				rsKanji = (Svr.rs.getString(1));
				rsHiragana = (Svr.rs.getString(2));
				rsMean = (Svr.rs.getString(3));
			}
			Svr.con.close();
			showData(rsKanji, rsHiragana, rsMean);
		} catch (Exception e) {

		}
	}

	public void pre() {
		if (count == 1) {
			count = max;
		} else {
			count -= 1;
		}
		openData();
	}

	public void next() {
		if (max == count) {
			count = 1;
		} else {
			count += 1;
		}
		openData();
	}

	public void findMax() {
		Svr.enterServer();
		try {
			String result = "NULL";
			String query = "SELECT COUNT(*) FROM voca WHERE SHAPE = '" + format + "' AND USER_NUMBER = '"
					+ data.userNumber + "'";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				result = (Svr.rs.getString(1));
			}
			max = Integer.parseInt(result);
			Svr.con.close();
		} catch (Exception e) {

		}
	}

	public void showData(String kanji, String hiragana, String mean) {
		lblNumber.setText("No." + count);
		lblKanji.setText(kanji);
		lblHiragana.setText(hiragana);
		lblMean.setText(mean);
	}

}
