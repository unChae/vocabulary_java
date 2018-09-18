package Project_4;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	JPanel pnlBg = new JPanel();

	JPanel pnlComponent = new JPanel();

	JPanel pnlMenu = new JPanel();
	JMenuBar mnbMenuBar = new JMenuBar();
	JLabel lblUserName = new JLabel();
	JMenu mnuSetup = new JMenu();
	JMenu mnuSwitch = new JMenu();
	JMenuItem mniHelp = new JMenuItem();
	JMenuItem mniLogout = new JMenuItem();
	JMenuItem mniSearch = new JMenuItem();
	JMenuItem mniVoca = new JMenuItem();
	JMenuItem mniQuiz = new JMenuItem();
	JMenuItem mniWidget = new JMenuItem();
	ImageIcon imgSetup = new ImageIcon("img/setup.png");
	ImageIcon imgChange = new ImageIcon("img/change.png");
	ImageIcon imgSearch = new ImageIcon("img/search.png");
	ImageIcon imgVoca = new ImageIcon("img/voca.png");
	ImageIcon imgQuiz = new ImageIcon("img/quiz.png");
	ImageIcon imgWidget = new ImageIcon("img/widget.png");
	ImageIcon imgHelp = new ImageIcon("img/help.png");
	ImageIcon imgLogout = new ImageIcon("img/logout.png");
	ImageIcon imgUser = new ImageIcon("img/user.png");
	
	
	
	
	// create another variable
	CardLayout cardManager = new CardLayout();
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	// create sub panel
	JPanel pnlSub = new JPanel();

	// create gif image label
	// calling up Image Files
	JLabel lblGif = new JLabel();
	ImageIcon imgBg = new ImageIcon("img/bgLogin.gif");

	// create background panel for login components
	JPanel pnlLogin = new JPanel();

	// create access components
	// panel, label, textfield, passwordfield, button
	JPanel pnlAccess = new JPanel();
	JLabel lblMainTitle = new JLabel();
	JLabel lblId = new JLabel();
	JLabel lblPwd = new JLabel();
	JTextField txtId = new JTextField();
	JPasswordField txtPwd = new JPasswordField();
	JButton btnLogin = new JButton();
	JButton btnNewAccount = new JButton();

	// create new account panel
	// create new account components
	JPanel pnlAccount = new JPanel();
	JLabel lblTitle = new JLabel();
	String strName[] = { "Email", "Password", "Name", "Phone Number" };
	JLabel lblInfor[] = new JLabel[4];
	JTextField txtInfor[] = new JTextField[4];
	JButton btnCreate = new JButton();
	JButton btnBack = new JButton();
	ImageIcon imgBack = new ImageIcon("img/backLogin.png");
	JComboBox<String> cmdEmail = new JComboBox<String>();
	String strEmail[] = { "naver.com", "gmail.com", "daum.net", "hanmail.net" };
	DefaultComboBoxModel<String> mdlEmail = new DefaultComboBoxModel<String>(strEmail);

	// main panel
	JPanel pnlMain = new JPanel();
	
	JPanel pnlSearch = new JPanel();
	JPanel pnlVoca = new JPanel();
	JPanel pnlQuiz = new JPanel();
	
	MainFrame() {

		pnlBg.setLayout(null);
		pnlBg.setBackground(new Color(39, 39, 39));
		add(pnlBg);

		pnlBg.add(pnlComponent);
		pnlComponent.setLayout(cardManager);
		pnlComponent.setBounds(0, 30, 800, 534);
		pnlComponent.setBackground(new Color(39, 39, 39));
		pnlComponent.add(pnlSub, "sub");
		pnlComponent.add(pnlMain, "main");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/titleIcon.png"));
		setTitle("Login & SignUP");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);

	}
}
