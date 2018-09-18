package Project_9;

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

	public void setQuiz() {
		Svr.enterServer();
		data.score = 0;
		data.cntQuit = 1;
		quizCount = Integer.parseInt(f.txtQuizNumber.getText());
		this.format = f.cmdFormat.getSelectedItem().toString();
		if(quizCount < 4) {
			JOptionPane.showMessageDialog(null, "Over 3");
			return;
		}
		checkCount();
		if (cntFormat < quizCount) {
			JOptionPane.showMessageDialog(null, "exceed the limit");
			return;
		}
		try {
			this.quizCount = quizCount;
			strQuiz = new String[quizCount][5];
			for (int i = 0; i < quizCount; i++) {
				int randNumber = (int) (Math.random() * 6) + 1;
				strQuiz[i][0] = Integer.toString(randNumber);
				strQuiz[i][4] = "0";
			}
			randQuiz();
			Svr.con.close();
		} catch (Exception e) {

		}

		f.lblQuiz.setVisible(true);
		f.lblQuizTime.setVisible(true);
		f.lblQuizTime.setText(data.cntQuit + "/" + f.txtQuizNumber.getText());
		f.lblQuizNumber.setVisible(true);
		f.lblQuizNumber.setText("No." + data.cntQuit);
		f.btnNextQuiz.setVisible(true);
		for (int i = 0; i < 4; i++) {
			f.radQuizzes[i].setVisible(true);
		}
	}

	public void randQuiz() {
		for (int i = 0; i < quizCount; i++) {
			try {
				String rsKanji = "NULL";
				String rsHiragana = "NULL";
				String rsMean = "NULL";
				String query = "SELECT KANJI, HIRAGANA, MEAN FROM (SELECT * FROM VOCA ORDER BY dbms_random.VALUE) WHERE ROWNUM = 1 AND SHAPE = '"
						+ format + "' AND USER_NUMBER = '" + data.userNumber + "'";
				Svr.stmt = Svr.con.prepareStatement(query);
				Svr.rs = Svr.stmt.executeQuery();
				while (Svr.rs.next()) {
					rsKanji = (Svr.rs.getString(1));
					rsHiragana = (Svr.rs.getString(2));
					rsMean = (Svr.rs.getString(3));
				}

				boolean bln = true;
				if (i > 0) {
					for (int j = 0; j < quizCount; j++) {
						if (rsHiragana.equals(strQuiz[j][2]) && rsKanji.equals(strQuiz[j][1])) {
							bln = false;
						}
					}
					if (bln == false) {
						bln = true;
						i -= 1;
						continue;
					}
				}

				strQuiz[i][1] = rsKanji;
				strQuiz[i][2] = rsHiragana;
				strQuiz[i][3] = rsMean;

				System.out.println(i + " / " + strQuiz[i][0] + " " + strQuiz[i][1] + " " + strQuiz[i][2] + " "
						+ strQuiz[i][3] + " " + strQuiz[i][4]);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		randExam();
		quizType();
	}

	public void randExam() {
		for (int j = 0; j < 3; j++) {
			strExam[3][j] = strQuiz[data.cntQuit - 1][j + 1];
		}
		System.out.println(strExam[3][0] + " " + strExam[3][1] + " " + strExam[3][2]);
		for (int i = 0; i < 3; i++) {
			try {
				String rsKanji = "NULL";
				String rsHiragana = "NULL";
				String rsMean = "NULL";
				String query = "SELECT KANJI, HIRAGANA, MEAN FROM (SELECT * FROM VOCA ORDER BY dbms_random.VALUE) WHERE ROWNUM = 1 AND SHAPE = '"
						+ format + "' AND USER_NUMBER = '" + data.userNumber + "'";
				Svr.stmt = Svr.con.prepareStatement(query);
				Svr.rs = Svr.stmt.executeQuery();
				while (Svr.rs.next()) {
					rsKanji = (Svr.rs.getString(1));
					rsHiragana = (Svr.rs.getString(2));
					rsMean = (Svr.rs.getString(3));
				}

				boolean bln = true;
				for (int j = 0; j < 4; j++) {
					if (rsHiragana.equals(strExam[j][1]) && rsKanji.equals(strExam[j][0])
							|| rsKanji.equals(strQuiz[j][1]) && rsHiragana.equals(strQuiz[j][2])) {
						bln = false;
					}
				}
				if (bln == false) {
					bln = true;
					i -= 1;
					continue;
				}

				strExam[i][0] = rsKanji;
				strExam[i][1] = rsHiragana;
				strExam[i][2] = rsMean;

			} catch (Exception e) {

			}
			System.out.println("");
			System.out.println("순서 : " + strExam[i][0] + " " + strExam[i][1] + " " + strExam[i][2]);
		}
		randomExam();
	}

	public void randomExam() {
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

			System.out.println("rand : " + strRanExam[i][0] + " " + strRanExam[i][1] + " " + strRanExam[i][2]);
		}
	}

	public void quizType() {
		// 한자 - > 의미
		if (strQuiz[data.cntQuit - 1][0].equals("1")) {
			f.lblQuiz.setText(strQuiz[data.cntQuit - 1][1]);
			f.radQuizzes[0].setText(strRanExam[0][2]);
			f.radQuizzes[1].setText(strRanExam[1][2]);
			f.radQuizzes[2].setText(strRanExam[2][2]);
			f.radQuizzes[3].setText(strRanExam[3][2]);

			// 의미 - > 한자
		} else if (strQuiz[data.cntQuit - 1][0].equals("2")) {
			f.lblQuiz.setText(strQuiz[data.cntQuit - 1][3]);
			f.radQuizzes[0].setText(strRanExam[0][0]);
			f.radQuizzes[1].setText(strRanExam[1][0]);
			f.radQuizzes[2].setText(strRanExam[2][0]);
			f.radQuizzes[3].setText(strRanExam[3][0]);
			// 한자 - > 히라가나
		} else if (strQuiz[data.cntQuit - 1][0].equals("3")) {
			f.lblQuiz.setText(strQuiz[data.cntQuit - 1][1]);
			f.radQuizzes[0].setText(strRanExam[0][1]);
			f.radQuizzes[1].setText(strRanExam[1][1]);
			f.radQuizzes[2].setText(strRanExam[2][1]);
			f.radQuizzes[3].setText(strRanExam[3][1]);
			// 히라가나 - > 한자
		} else if (strQuiz[data.cntQuit - 1][0].equals("4")) {
			f.lblQuiz.setText(strQuiz[data.cntQuit - 1][2]);
			f.radQuizzes[0].setText(strRanExam[0][0]);
			f.radQuizzes[1].setText(strRanExam[1][0]);
			f.radQuizzes[2].setText(strRanExam[2][0]);
			f.radQuizzes[3].setText(strRanExam[3][0]);
			// 히라가나 - > 의미
		} else if (strQuiz[data.cntQuit - 1][0].equals("5")) {
			f.lblQuiz.setText(strQuiz[data.cntQuit - 1][2]);
			f.radQuizzes[0].setText(strRanExam[0][2]);
			f.radQuizzes[1].setText(strRanExam[1][2]);
			f.radQuizzes[2].setText(strRanExam[2][2]);
			f.radQuizzes[3].setText(strRanExam[3][2]);
			// 의미 - > 히라가나
		} else if (strQuiz[data.cntQuit - 1][0].equals("6")) {
			f.lblQuiz.setText(strQuiz[data.cntQuit - 1][3]);
			f.radQuizzes[0].setText(strRanExam[0][1]);
			f.radQuizzes[1].setText(strRanExam[1][1]);
			f.radQuizzes[2].setText(strRanExam[2][1]);
			f.radQuizzes[3].setText(strRanExam[3][1]);
		}
	}

	public void checkCount() {
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
		} catch (Exception e) {

		}
	}

	public void nextQuestion() {
		if (data.cntQuit < quizCount) {
			showResult();
			randExam();
			quizType();

			f.radQuizzes[0].setSelected(true);

			f.lblQuizTime.setText(data.cntQuit + "/" + f.txtQuizNumber.getText());
			f.lblQuizNumber.setText("No." + data.cntQuit);

		} else if (data.cntQuit == quizCount) {

			showResult();
			f.btnNextQuiz.setText("Result");

		} else {
			JOptionPane.showMessageDialog(null, checkScore());
			System.out.println(quizCount);
			System.out.println(data.score);
			f.lblScore.setText("Score : " + (double) (data.score) / (double) (quizCount) * 100);
			f.btnNextQuiz.setText("Next");
		}
	}

	public void showResult() {
		for (int i = 0; i < 4; i++) {
			if (f.radQuizzes[i].isSelected() == true) {
				data.answer = f.radQuizzes[i].getText().toString();
			}
		}
		for (int i = 1; i < 4; i++) {
			if (data.answer.equals(strQuiz[data.cntQuit - 1][i])) {
				strQuiz[data.cntQuit - 1][4] = "1";
				data.score += 1;
				System.out.println("정답");
				break;
			}
		}
		data.cntQuit += 1;
	}

	public String checkScore() {
		String str = "";
		for (int i = 0; i < quizCount; i++) {
			if (strQuiz[i][4].equals("1")) {
				str += (i + 1) + "문제 " + strQuiz[i][1] + " / " + strQuiz[i][2] + " / " + strQuiz[i][3] + " 정답\n";
			} else {
				str += (i + 1) + "문제 " + strQuiz[i][1] + " / " + strQuiz[i][2] + " / " + strQuiz[i][3] + " 오답\n";
			}
		}
		return str;
	}
}
