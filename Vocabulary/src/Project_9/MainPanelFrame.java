package Project_9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.JTableHeader;

public class MainPanelFrame implements ActionListener, MouseListener, KeyListener {
	MainFrame f;
	DataClass data;
	QuizClass quiz;

	MainPanelFrame(DataClass data, MainFrame f, QuizClass quiz) {
		this.f = f;
		this.data = data;
		this.quiz = quiz;

		f.pnlMain.setLayout(null);

		// create pnlMenu
		f.pnlMain.add(f.pnlMenu);
		f.pnlMenu.setLayout(null);
		f.pnlMenu.setBounds(286, 0, 605, 35);
		f.pnlMenu.setBackground(Color.WHITE);

		// menu title
		f.pnlMenu.add(f.lblMenuTitle);
		f.lblMenuTitle.setIcon(f.imgTitleMenu);
		f.lblMenuTitle.setBounds(14, 0, 250, 35);

		// menu minimize button
		f.pnlMenu.add(f.btnMenuMini);
		f.btnMenuMini.setIcon(f.imgMiniMenu);
		f.btnMenuMini.setFocusPainted(false);
		f.btnMenuMini.setBorderPainted(false);
		f.btnMenuMini.setContentAreaFilled(false);
		f.btnMenuMini.setCursor(f.cursor);
		f.btnMenuMini.addActionListener(this);
		f.btnMenuMini.setName("menuMini");
		f.btnMenuMini.setBounds(535, 1, 35, 35);

		// menu exit button
		f.pnlMenu.add(f.btnMenuExit);
		f.btnMenuExit.setIcon(f.imgExitMenu);
		f.btnMenuExit.setFocusPainted(false);
		f.btnMenuExit.setBorderPainted(false);
		f.btnMenuExit.setContentAreaFilled(false);
		f.btnMenuExit.setCursor(f.cursor);
		f.btnMenuExit.addActionListener(this);
		f.btnMenuExit.setName("menuExit");
		f.btnMenuExit.setBounds(565, 0, 35, 35);

		// create pnlSide
		f.pnlMain.add(f.pnlSide);
		f.pnlSide.setLayout(null);
		f.pnlSide.setBounds(0, 0, 286, 529);
		f.pnlSide.setBackground(new Color(39, 39, 39));

		f.pnlSide.add(f.btnLogout);
		f.btnLogout.setIcon(f.imgLogoutSide);
		f.btnLogout.setFocusPainted(false);
		f.btnLogout.setBorderPainted(false);
		f.btnLogout.setContentAreaFilled(false);
		f.btnLogout.setCursor(f.cursor);
		f.btnLogout.addActionListener(this);
		f.btnLogout.setName("sideLogout");
		f.btnLogout.setBounds(14, 12, 50, 50);

		f.pnlSide.add(f.lblTitleSide);
		f.lblTitleSide.setText("User Infor");
		f.lblTitleSide.setForeground(Color.WHITE);
		f.lblTitleSide.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 27));
		f.lblTitleSide.setBounds(78, 12, 194, 50);

		for (int i = 0; i < 4; i++) {
			f.lblInforSide[i] = new JLabel(f.strInforSide[i]);
			f.pnlSide.add(f.lblInforSide[i]);
			f.lblInforSide[i].setForeground(Color.LIGHT_GRAY);
			f.lblInforSide[i].setBounds(14, 85 + i * 25, 100, 18);

			f.lblUserData[i] = new JLabel();
			f.pnlSide.add(f.lblUserData[i]);
			f.lblUserData[i].setHorizontalAlignment(SwingConstants.CENTER);
			f.lblUserData[i].setForeground(Color.LIGHT_GRAY);
			f.lblUserData[i].setBounds(100, 85 + i * 25, 158, 18);
		}

		f.pnlSide.add(f.scrMemo);

		f.scrMemo.setBounds(14, 180, 258, 117);
		f.scrMemo.setViewportView(f.txaMeno);

		for (int i = 0; i < 3; i++) {
			f.btnChange[i] = new JButton();
			f.pnlSide.add(f.btnChange[i]);
			f.btnChange[i].setLayout(null);
			f.btnChange[i].setFocusPainted(false);
			f.btnChange[i].setBorderPainted(false);
			f.btnChange[i].setBackground(new Color(39, 39, 39));
			f.btnChange[i].addMouseListener(this);
			f.btnChange[i].addActionListener(this);
			f.btnChange[i].setName(f.strNameSide[i]);
			f.btnChange[i].setBounds(0, 323 + i * 50, 286, 40);
		}

		for (int i = 0; i < 3; i++) {
			f.lblImgSide[i] = new JLabel();
			f.btnChange[i].add(f.lblImgSide[i]);
			f.lblImgSide[i].setBounds(40, 5, 25, 25);

			f.lblNameSide[i] = new JLabel(f.strNameSide[i]);
			f.btnChange[i].add(f.lblNameSide[i]);
			f.lblNameSide[i].setForeground(Color.LIGHT_GRAY);
			f.lblNameSide[i].setBounds(80, 10, 200, 20);
		}

		f.lblImgSide[0].setIcon(f.imgEditorSide);
		f.lblImgSide[1].setIcon(f.imgQuizSide);
		f.lblImgSide[2].setIcon(f.imgWidgetSide);

		// create pnlMainCard
		f.pnlMain.add(f.pnlMainCard);
		f.pnlMainCard.setLayout(f.cardManager);
		f.pnlMainCard.setBounds(286, 35, 605, 495);

		f.pnlMainCard.add(f.pnlVoca, "editor");

		f.pnlVoca.setLayout(null);
		f.pnlVoca.setBackground(Color.WHITE);

		f.pnlVoca.add(f.lblTitleEdit);
		f.lblTitleEdit.setText("Editor");
		f.lblTitleEdit.setFont(new Font("", Font.PLAIN, 28));
		f.lblTitleEdit.setHorizontalAlignment(SwingConstants.CENTER);
		f.lblTitleEdit.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(39, 39, 39)));
		f.lblTitleEdit.setBounds(10, 12, 581, 52);

		f.pnlVoca.add(f.lblExplorer);
		f.lblExplorer.setText("Explorer");
		f.lblExplorer.setIcon(f.imgSearch);
		f.lblExplorer.setBounds(14, 80, 80, 18);

		f.pnlVoca.add(f.txtSearch);
		f.txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(39, 39, 39)));
		f.txtSearch.addKeyListener(this);
		f.txtSearch.setBounds(100, 76, 175, 24);

		f.pnlVoca.add(f.btnEditor);
		f.btnEditor.setText("Edit");
		f.btnEditor.setFocusPainted(false);
		f.btnEditor.setBorderPainted(false);
		f.btnEditor.setContentAreaFilled(false);
		f.btnEditor.setCursor(f.cursor);
		f.btnEditor.addActionListener(this);
		f.btnEditor.setName("edit");
		f.btnEditor.setBounds(439, 76, 69, 24);

		f.pnlVoca.add(f.btnDel);
		f.btnDel.setText("Del");
		f.btnDel.setFocusPainted(false);
		f.btnDel.setBorderPainted(false);
		f.btnDel.setContentAreaFilled(false);
		f.btnDel.setCursor(f.cursor);
		f.btnDel.addActionListener(this);
		f.btnDel.setName("del");
		f.btnDel.setBounds(522, 77, 69, 24);

		f.pnlVoca.add(f.pnlTable);
		f.pnlTable.setBounds(0, 113, 605, 382);
		f.pnlTable.setLayout(new BorderLayout());

		f.listColumn.addElement("Kanji");
		f.listColumn.addElement("Hiragana");
		f.listColumn.addElement("Mean");
		f.listColumn.addElement("Format");

		f.tblVoca.setModel(f.model);
		f.pnlTable.add(f.listSp, BorderLayout.CENTER);
		f.listSp.getViewport().setBackground(Color.WHITE);
		JTableHeader header = f.tblVoca.getTableHeader();
		header.setBackground(Color.WHITE);

		// Quiz
		f.pnlMainCard.add(f.pnlQuiz, "quiz");

		f.pnlQuiz.setLayout(null);
		f.pnlQuiz.setBackground(Color.WHITE);

		f.pnlQuiz.add(f.lblTitleQuiz);
		f.lblTitleQuiz.setText("Quiz");
		f.lblTitleQuiz.setFont(new Font("", Font.PLAIN, 28));
		f.lblTitleQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		f.lblTitleQuiz.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(39, 39, 39)));
		f.lblTitleQuiz.setBounds(10, 12, 581, 52);

		f.pnlQuiz.add(f.cmdFormat);
		f.cmdFormat.setFont(new Font("", Font.PLAIN, 12));
		f.cmdFormat.setBounds(10, 76, 124, 24);

		f.pnlQuiz.add(f.txtQuizNumber);
		f.txtQuizNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(39, 39, 39)));
		f.txtQuizNumber.setBounds(137, 76, 62, 24);

		f.pnlQuiz.add(f.lblQs);
		f.lblQs.setText("Qs");
		f.lblQs.setBounds(202, 79, 20, 18);

		f.pnlQuiz.add(f.lblScore);
		f.lblScore.setText("Score");
		f.lblScore.setBounds(365, 79, 107, 18);

		f.pnlQuiz.add(f.btnSubmit);
		f.btnSubmit.setText("Submit");
		f.btnSubmit.setFocusPainted(false);
		f.btnSubmit.setBorderPainted(false);
		f.btnSubmit.setContentAreaFilled(false);
		f.btnSubmit.setCursor(f.cursor);
		f.btnSubmit.addActionListener(this);
		f.btnSubmit.setName("submit");
		f.btnSubmit.setBounds(486, 75, 105, 27);

		f.pnlQuiz.add(f.lblQuizNumber);
		f.lblQuizNumber.setVisible(false);
		f.lblQuizNumber.setBounds(10, 144, 107, 18);

		f.pnlQuiz.add(f.lblQuizTime);
		f.lblQuizTime.setVisible(false);
		f.lblQuizTime.setBounds(529, 114, 62, 18);

		f.pnlQuiz.add(f.lblQuiz);
		f.lblQuiz.setFont(new Font("", Font.PLAIN, 34));
		f.lblQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		f.lblQuiz.setVisible(false);
		f.lblQuiz.setBounds(10, 174, 581, 106);

		for (int i = 0; i < 4; i++) {
			f.radQuizzes[i] = new JRadioButton();
			f.pnlQuiz.add(f.radQuizzes[i]);
			f.btnGroup.add(f.radQuizzes[i]);
			f.radQuizzes[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
			f.radQuizzes[i].setOpaque(false);
			f.radQuizzes[i].setVisible(false);
			f.radQuizzes[i].setBounds(10, 307 + i * 32, 581, 27);
		}

		f.pnlQuiz.add(f.btnNextQuiz);
		f.btnNextQuiz.setText("Next");
		f.btnNextQuiz.setVisible(false);
		f.btnNextQuiz.setFocusPainted(false);
		f.btnNextQuiz.setBorderPainted(false);
		f.btnNextQuiz.setContentAreaFilled(false);
		f.btnNextQuiz.setCursor(f.cursor);
		f.btnNextQuiz.addActionListener(this);
		f.btnNextQuiz.setName("nextQuiz");
		f.btnNextQuiz.setBounds(500, 450, 91, 27);

	}

	public void removeColor() {
		for (int i = 0; i < 3; i++) {
			f.btnChange[i].setBackground(new Color(39, 39, 39));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = ((JButton) e.getSource()).getName();
		switch (str) {
		case "menuMini":
			f.setState(JFrame.ICONIFIED);
			break;
		case "menuExit":
			System.exit(0);
			break;
		case "sideLogout":
			f.cardManager.show(f.pnlComponent, "sub");
			break;
		case "Editor":
			f.cardManager.show(f.pnlMainCard, "editor");
			break;
		case "edit":
			new EditorFrame(data);
			break;
		case "del":
			data.delVoca();
			break;
		case "Quiz":
			f.cardManager.show(f.pnlMainCard, "quiz");
			break;
		case "submit":
			f.lblScore.setText("Score");
			quiz.setQuiz();
			break;
		case "nextQuiz":
			quiz.nextQuestion();
			break;
		case "Widget":
			new WidgetFrame();
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			f.btnChange[i].setBackground(new Color(39, 39, 39));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String str = ((JButton) e.getSource()).getName();
		switch (str) {
		case "Editor":
			f.btnChange[0].setBackground(new Color(90, 90, 90));
			break;
		case "Quiz":
			f.btnChange[1].setBackground(new Color(90, 90, 90));
			break;
		case "Widget":
			f.btnChange[2].setBackground(new Color(90, 90, 90));
			break;
		}
	}

	MainPanelFrame(MainFrame f, DataClass d) {
		f.lblUserData[0].setText(d.userID);
		f.lblUserData[1].setText(d.userName);
		f.lblUserData[2].setText("No." + d.userNumber);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		removeColor();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		String query = f.txtSearch.getText().toLowerCase();
		data.filter(query);
	}
}
