package Project_4;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarFrame implements ActionListener {

	MainFrame f;

	MenuBarFrame(MainFrame f) {
		this.f = f;

		f.pnlBg.add(f.pnlMenu);

		f.pnlMenu.setLayout(null);
		f.pnlMenu.setOpaque(false);
		f.pnlMenu.setBounds(0, 0, 800, 30);
		f.pnlMenu.setVisible(false);

		f.pnlMenu.add(f.mnbMenuBar);
		f.mnbMenuBar.setBounds(0, 0, 800, 30);
		f.mnbMenuBar.setLayout(null);

		f.mnbMenuBar.add(f.lblUserName);
		f.lblUserName.setBounds(700, 0, 150, 30);
		f.lblUserName.setIcon(f.imgUser);
		f.lblUserName.setFont(new Font("", Font.PLAIN, 14));
		
		// 메뉴
		f.mnbMenuBar.add(f.mnuSetup);
		f.mnuSetup.setText("Setup");
		f.mnuSetup.setIcon(f.imgSetup);
		f.mnuSetup.setBounds(0, 0, 100, 30);

		f.mnuSetup.add(f.mniHelp);
		f.mniHelp.setText("Help");
		f.mniHelp.setIcon(f.imgHelp);

		f.mnuSetup.add(f.mniLogout);
		f.mniLogout.setText("Logout");
		f.mniLogout.setIcon(f.imgLogout);
		f.mniLogout.addActionListener(this);

		// 메뉴
		f.mnbMenuBar.add(f.mnuSwitch);
		f.mnuSwitch.setText("Switch");
		f.mnuSwitch.setIcon(f.imgChange);
		f.mnuSwitch.setBounds(100, 0, 100, 30);

		f.mnuSwitch.add(f.mniSearch);
		f.mniSearch.setText("Search");
		f.mniSearch.setIcon(f.imgSearch);
		f.mniSearch.addActionListener(this);

		f.mnuSwitch.add(f.mniVoca);
		f.mniVoca.setText("Voca");
		f.mniVoca.setIcon(f.imgVoca);
		f.mniVoca.addActionListener(this);

		f.mnuSwitch.add(f.mniQuiz);
		f.mniQuiz.setText("Quiz");
		f.mniQuiz.setIcon(f.imgQuiz);
		f.mniQuiz.addActionListener(this);

		f.mnuSwitch.add(f.mniWidget);
		f.mniWidget.setText("Widget");
		f.mniWidget.setIcon(f.imgWidget);
		f.mniWidget.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Logout":
			f.pnlMenu.setVisible(false);
			f.cardManager.show(f.pnlComponent, "sub");
			break;
		case "Search":
			f.cardManager.show(f.pnlMain, "search");
			break;
		case "Voca":
			f.cardManager.show(f.pnlMain, "voca");
			break;
		case "Quiz":
			f.cardManager.show(f.pnlMain, "quiz");
			break;
		case "Widget":
			break;

		default:
			break;
		}
	}
}
