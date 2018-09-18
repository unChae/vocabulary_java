package Project_7;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainPanelFrame implements ActionListener, MouseListener {
	MainFrame f;

	MainPanelFrame(MainFrame f) {
		this.f = f;
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

		for (int i = 0; i < 4; i++) {
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

		for (int i = 0; i < 4; i++) {
			f.lblImgSide[i] = new JLabel();
			f.btnChange[i].add(f.lblImgSide[i]);
			f.lblImgSide[i].setBounds(40, 5, 25, 25);

			f.lblNameSide[i] = new JLabel(f.strNameSide[i]);
			f.btnChange[i].add(f.lblNameSide[i]);
			f.lblNameSide[i].setForeground(Color.LIGHT_GRAY);
			f.lblNameSide[i].setBounds(80, 10, 200, 20);
		}

		f.lblImgSide[0].setIcon(f.imgSearchSide);
		f.lblImgSide[1].setIcon(f.imgEditorSide);
		f.lblImgSide[2].setIcon(f.imgQuizSide);
		f.lblImgSide[3].setIcon(f.imgWidgetSide);

		// create pnlMainCard
		f.pnlMain.add(f.pnlMainCard);
		f.pnlMainCard.setLayout(f.cardManager);
		f.pnlMainCard.setBounds(286, 35, 605, 495);

		
		
		f.pnlMainCard.add(f.pnlSearch, "search");
		f.pnlMainCard.add(f.pnlVoca, "editor");
		f.pnlMainCard.add(f.pnlQuiz, "quiz");

		f.pnlSearch.setBackground(Color.WHITE);
		f.pnlVoca.setBackground(Color.WHITE);
		f.pnlQuiz.setBackground(Color.WHITE);
	}

	public void removeColor() {
		for (int i = 0; i < 4; i++) {
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
		case "Search":
			f.cardManager.show(f.pnlMainCard, "search");
			break;
		case "Editor":
			f.cardManager.show(f.pnlMainCard, "editor");
			break;
		case "Quiz":
			f.cardManager.show(f.pnlMainCard, "quiz");
			break;
		case "Widget":

			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 4; i++) {
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
		case "Search":
			f.btnChange[0].setBackground(new Color(90, 90, 90));
			break;
		case "Editor":
			f.btnChange[1].setBackground(new Color(90, 90, 90));
			break;
		case "Quiz":
			f.btnChange[2].setBackground(new Color(90, 90, 90));
			break;
		case "Widget":
			f.btnChange[3].setBackground(new Color(90, 90, 90));
			break;
		}
	}

	MainPanelFrame(MainFrame f, DataClass d){
		f.lblUserData[0].setText(d.userID);
		f.lblUserData[1].setText(d.userName);
		f.lblUserData[2].setText("No." + d.userNumber);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		removeColor();
	}
}
