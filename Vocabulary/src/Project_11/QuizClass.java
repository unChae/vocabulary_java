package Project_11;

import javax.swing.JOptionPane;

public class QuizClass {
	DataClass data;
	MainFrame f;
	String strQuiz[][];
	String strExam[][] = new String[4][3];
	String strRanExam[][] = new String[4][3];
	int quizCount = 0;
	int cntFormat = 0;
	String format;

	QuizClass(DataClass data, MainFrame f) {
		this.data = data;
		this.f = f;
	}

	// click submit button
	public void setQuiz() {
		data.score = 0;
		data.cntQuiz = 1;
		quizCount = Integer.parseInt(f.txtQuizNumber.getText()); // get Number Users Want
		this.format = f.cmdFormat.getSelectedItem().toString(); // get Form Users Want
		// check number of limit
		checkCount();
		if (cntFormat < quizCount) {
			JOptionPane.showMessageDialog(null, "exceed the limit");
			return;
		}
		// ready for check score

		strQuiz = new String[quizCount][4];
		for (int i = 0; i < quizCount; i++) {
			strQuiz[i][3] = "0";
		}
		randQuiz();

	}

	// insert Quiz
	public void randQuiz() {
		Svr.enterServer(); // enter the server
		int i = 0;
		int j = 0;
		try {
			String rsKanji = "NULL";
			String rsHiragana = "NULL";
			String rsMean = "NULL";
			String query = "SELECT KANJI, HIRAGANA, MEAN FROM (SELECT * FROM VOCA ORDER BY dbms_random.VALUE) WHERE ROWNUM <= "
					+ quizCount + " AND SHAPE = '" + format + "' AND USER_NUMBER = '" + data.userNumber + "'";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				rsKanji = (Svr.rs.getString(1));
				rsHiragana = (Svr.rs.getString(2));
				rsMean = (Svr.rs.getString(3));

				strQuiz[i][j] = rsKanji;
				j++;
				strQuiz[i][j] = rsHiragana;
				j++;
				strQuiz[i][j] = rsMean;
				j = 0;
				i++;
			}
			Svr.con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		randExam();
		quizType();
	}

	// insert Exam
	public void randExam() {
		Svr.enterServer(); // enter the server
		int i = 0;
		int j = 0;
		strExam = new String[4][3];
		try {
			String rsKanji = "NULL";
			String rsHiragana = "NULL";
			String rsMean = "NULL";
			String query = "SELECT KANJI, HIRAGANA, MEAN FROM (SELECT * FROM VOCA ORDER BY dbms_random.VALUE) WHERE ROWNUM <= 3 AND HIRAGANA != '"
					+ strQuiz[data.cntQuiz - 1][1] + "' AND MEAN != '" + strQuiz[data.cntQuiz - 1][2]
					+ "' AND SHAPE = '" + format + "' AND USER_NUMBER = '" + data.userNumber + "'";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				rsKanji = (Svr.rs.getString(1));
				rsHiragana = (Svr.rs.getString(2));
				rsMean = (Svr.rs.getString(3));

				strExam[i][j] = rsKanji;
				j++;
				strExam[i][j] = rsHiragana;
				j++;
				strExam[i][j] = rsMean;
				j = 0;
				i++;
			}
			strExam[3] = strQuiz[data.cntQuiz - 1];
			Svr.con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		shuffleExam();
	}

	// shuffle Exam
	public void shuffleExam() {
		for (int i = 0; i < 4; i++) {
			int randNumber = (int) (Math.random() * 4);
			String strInput[] = new String[3];
			for (int j = 0; j < 3; j++) {
				strInput[j] = strExam[randNumber][j];
			}
			boolean bln = true;
			for (int k = 0; k < 3; k++) {
				if (strInput[2].equals(strRanExam[k][2])) {
					bln = false;
				}
			}
			if (bln == false) {
				bln = true;
				i -= 1;
				continue;
			}
			strRanExam[i][0] = strInput[0];
			strRanExam[i][1] = strInput[1];
			strRanExam[i][2] = strInput[2];
		}
	}

	// quiz by type
	public void quizType() {
		int randNumber = 0;
		if (strQuiz[data.cntQuiz - 1][0] == null) {
			randNumber = (int) (Math.random() * 2) + 5;
		} else {
			randNumber = (int) (Math.random() * 6) + 1;
		}
		f.lblQuiz.setVisible(true);
		f.lblQuizTime.setVisible(true);
		f.lblQuizTime.setText(data.cntQuiz + "/" + quizCount);
		f.lblQuizNumber.setVisible(true);
		f.lblQuizNumber.setText("No." + data.cntQuiz);
		f.btnNextQuiz.setVisible(true);
		for (int i = 0; i < 4; i++) {
			f.radQuizzes[i].setVisible(true);
		}
		// 한자 - > 의미
		if (randNumber == 1) {
			f.lblQuiz.setText(strQuiz[data.cntQuiz - 1][0]);
			f.radQuizzes[0].setText(strRanExam[0][2]);
			f.radQuizzes[1].setText(strRanExam[1][2]);
			f.radQuizzes[2].setText(strRanExam[2][2]);
			f.radQuizzes[3].setText(strRanExam[3][2]);

			// 의미 - > 한자
		} else if (randNumber == 2) {
			f.lblQuiz.setText(strQuiz[data.cntQuiz - 1][2]);
			f.radQuizzes[0].setText(strRanExam[0][0]);
			f.radQuizzes[1].setText(strRanExam[1][0]);
			f.radQuizzes[2].setText(strRanExam[2][0]);
			f.radQuizzes[3].setText(strRanExam[3][0]);
			// 한자 - > 히라가나
		} else if (randNumber == 3) {
			f.lblQuiz.setText(strQuiz[data.cntQuiz - 1][0]);
			f.radQuizzes[0].setText(strRanExam[0][1]);
			f.radQuizzes[1].setText(strRanExam[1][1]);
			f.radQuizzes[2].setText(strRanExam[2][1]);
			f.radQuizzes[3].setText(strRanExam[3][1]);
			// 히라가나 - > 한자
		} else if (randNumber == 4) {
			f.lblQuiz.setText(strQuiz[data.cntQuiz - 1][1]);
			f.radQuizzes[0].setText(strRanExam[0][0]);
			f.radQuizzes[1].setText(strRanExam[1][0]);
			f.radQuizzes[2].setText(strRanExam[2][0]);
			f.radQuizzes[3].setText(strRanExam[3][0]);
			// 히라가나 - > 의미
		} else if (randNumber == 5) {
			f.lblQuiz.setText(strQuiz[data.cntQuiz - 1][1]);
			f.radQuizzes[0].setText(strRanExam[0][2]);
			f.radQuizzes[1].setText(strRanExam[1][2]);
			f.radQuizzes[2].setText(strRanExam[2][2]);
			f.radQuizzes[3].setText(strRanExam[3][2]);
			// 의미 - > 히라가나
		} else if (randNumber == 6) {
			f.lblQuiz.setText(strQuiz[data.cntQuiz - 1][2]);
			f.radQuizzes[0].setText(strRanExam[0][1]);
			f.radQuizzes[1].setText(strRanExam[1][1]);
			f.radQuizzes[2].setText(strRanExam[2][1]);
			f.radQuizzes[3].setText(strRanExam[3][1]);
		}
	}

	// quiz limit
	public void checkCount() {
		Svr.enterServer(); // enter the server
		try {
			String result = "NULL";
			String query = "SELECT COUNT(*) FROM voca WHERE SHAPE = '" + format + "' AND USER_NUMBER = '"
					+ data.userNumber + "'";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				result = (Svr.rs.getString(1));
			}
			cntFormat = Integer.parseInt(result);
			Svr.con.close();
		} catch (Exception e) {

		}
	}

	// click nextQuiz button
	public void nextQuestion() {
		if (data.cntQuiz < quizCount) {
			showResult();
			randExam();
			quizType();

			f.radQuizzes[0].setSelected(true);

			f.lblQuizTime.setText(data.cntQuiz + "/" + quizCount);
			f.lblQuizNumber.setText("No." + data.cntQuiz);

		} else if (data.cntQuiz == quizCount) {

			showResult();
			f.btnNextQuiz.setText("Result");

		} else {
			JOptionPane.showMessageDialog(null, checkScore());
			f.lblScore.setText("Score : " + (double) (data.score) / (double) (quizCount) * 100);
			f.btnNextQuiz.setText("Next");
		}
	}

	// show result
	public void showResult() {
		for (int i = 0; i < 4; i++) {
			if (f.radQuizzes[i].isSelected() == true) {
				data.answer = f.radQuizzes[i].getText().toString();
			}
		}
		for (int i = 0; i < 3; i++) {
			if (data.answer.equals(strQuiz[data.cntQuiz - 1][i])) {
				strQuiz[data.cntQuiz - 1][3] = "1";
				data.score += 1;
				break;
			}
		}
		data.cntQuiz += 1;
	}

	// check score
	public String checkScore() {
		String str = "";
		for (int i = 0; i < quizCount; i++) {
			if (strQuiz[i][3].equals("1")) {
				str += (i + 1) + "문제 " + strQuiz[i][0] + " / " + strQuiz[i][1] + " / " + strQuiz[i][2] + " 정답\n";
			} else {
				str += (i + 1) + "문제 " + strQuiz[i][0] + " / " + strQuiz[i][1] + " / " + strQuiz[i][2] + " 오답\n";
			}
		}
		return str;
	}
}
