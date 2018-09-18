package Project_3;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	JPanel pnlBg = new JPanel();

	MainFrame() {

		new menubar();
		
		pnlBg.setLayout(null);
		add(pnlBg);
		pnlBg.setBackground(new Color(39, 39, 39));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/titleIcon.png"));
		setTitle("Login & SignUP");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);

	}
	
	public class menubar implements ActionListener{
		
		JPanel pnlMenu = new JPanel();
		JMenuBar mnbMenuBar = new JMenuBar();
		JMenu mnuSetup = new JMenu();
		JMenu mnuSwitch = new JMenu();
		JMenuItem mniHelp = new JMenuItem();
		JMenuItem mniLogout = new JMenuItem();
		JMenuItem mniSearch = new JMenuItem();
		JMenuItem mniVoca = new JMenuItem();
		JMenuItem mniQuiz = new JMenuItem();
		JMenuItem mniWidget = new JMenuItem();

		menubar(){
			pnlBg.add(pnlMenu);
			
			pnlMenu.setLayout(null);
			pnlMenu.setOpaque(false);
			pnlMenu.setBounds(0, 0, 800, 30);

			pnlMenu.add(mnbMenuBar);
			mnbMenuBar.setBounds(0, 0, 800, 30);

			// 메뉴
			mnbMenuBar.add(mnuSetup);
			mnuSetup.setText("Setup");
			mnuSetup.setEnabled(false);

			mnuSetup.add(mniHelp);
			mniHelp.setText("Help");

			mnuSetup.add(mniLogout);
			mniLogout.setText("Logout");

			// 메뉴
			mnbMenuBar.add(mnuSwitch);
			mnuSwitch.setText("Switch");
			mnuSwitch.setEnabled(false);

			mnuSwitch.add(mniSearch);
			mniSearch.setText("Search");

			mnuSwitch.add(mniVoca);
			mniVoca.setText("Voca");

			mnuSwitch.add(mniQuiz);
			mniQuiz.setText("Quiz");

			mnuSwitch.add(mniWidget);
			mniWidget.setText("Widget");

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}

}
