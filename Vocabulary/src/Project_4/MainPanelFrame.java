package Project_4;

import java.awt.Color;

public class MainPanelFrame {
	MainFrame f;

	MainPanelFrame(MainFrame f) {
		this.f = f;
		f.pnlMain.setLayout(f.cardManager);
		
		f.pnlMain.add(f.pnlSearch, "search");
		f.pnlMain.add(f.pnlVoca, "voca");
		f.pnlMain.add(f.pnlQuiz, "quiz");
		
		f.pnlSearch.setBackground(Color.CYAN);
		f.pnlVoca.setBackground(Color.GREEN);
		f.pnlQuiz.setBackground(Color.LIGHT_GRAY);
	}
}
