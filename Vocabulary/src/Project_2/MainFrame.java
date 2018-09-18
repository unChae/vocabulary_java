package Project_2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	// create another variable
	static CardLayout mainCard = new CardLayout();
	
	JPanel pnlBg = new JPanel();
	static JPanel pnlMain = new JPanel();
	static JPanel pnlSub = new JPanel();
	
	MainFrame() {
		pnlBg.setLayout(mainCard);
		pnlBg.setBackground(new Color(39, 39, 39));
		
		pnlBg.add(pnlSub, "sub");
		pnlBg.add(pnlMain, "main");
		
		CreatePnlSub sub = new CreatePnlSub(pnlBg);
		
		add(pnlBg);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/titleIcon.png"));
		setTitle("Login & SignUP");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);

	}
}
