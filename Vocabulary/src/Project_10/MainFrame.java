package Project_10;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame implements MouseListener, MouseMotionListener {

	JPanel pnlBg = new JPanel();

	JPanel pnlComponent = new JPanel();

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
	ImageIcon imgTitleLogin = new ImageIcon("img/titleLogin.png");
	ImageIcon imgUserLogin = new ImageIcon("img/userLogin.png");
	ImageIcon imgLockLogin = new ImageIcon("img/lockLogin.png");
	ImageIcon imgBtnLogin = new ImageIcon("img/btnLogin.png");
	ImageIcon imgExitLogin = new ImageIcon("img/exitLogin.png");
	JPanel pnlAccess = new JPanel();
	JButton btnExitLogin = new JButton();
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

	// create pnlMenu
	JPanel pnlMenu = new JPanel();
	JLabel lblMenuTitle = new JLabel();
	ImageIcon imgTitleMenu = new ImageIcon("img/titleMenu.png");
	JButton btnMenuExit = new JButton();
	ImageIcon imgExitMenu = new ImageIcon("img/exitMenu.png");
	JButton btnMenuMini = new JButton();
	ImageIcon imgMiniMenu = new ImageIcon("img/minimizeMenu.png");

	// create pnlSide
	JPanel pnlSide = new JPanel();
	JButton btnLogout = new JButton();
	ImageIcon imgLogoutSide = new ImageIcon("img/logoutSide.png");
	JLabel lblTitleSide = new JLabel();
	JLabel lblInforSide[] = new JLabel[4];
	String strInforSide[] = { "ID", "Name", "Number", "Memo" };
	JLabel lblUserData[] = new JLabel[4];
	JTextArea txaMeno = new JTextArea();
	JScrollPane scrMemo = new JScrollPane();
	JButton btnChange[] = new JButton[3];
	JLabel lblImgSide[] = new JLabel[3];
	ImageIcon imgEditorSide = new ImageIcon("img/editor.png");
	ImageIcon imgQuizSide = new ImageIcon("img/quiz.png");
	ImageIcon imgWidgetSide = new ImageIcon("img/widget.png");
	JLabel lblNameSide[] = new JLabel[4];
	String strNameSide[] = { "Editor", "Quiz", "Widget" };

	// create pnlMainCard
	JPanel pnlMainCard = new JPanel();

	// create pnlVoca
	JPanel pnlVoca = new JPanel();
	JLabel lblTitleEdit = new JLabel();
	JLabel lblExplorer = new JLabel();
	ImageIcon imgSearch = new ImageIcon("img/search.png");
	JTextField txtSearch = new JTextField();
	JButton btnEditor = new JButton();
	JButton btnDel = new JButton();
	JPanel pnlTable = new JPanel();

	Vector<String> listColumn = new Vector<String>();
	Vector<String> listRow = new Vector<String>();
	DefaultTableModel model = new DefaultTableModel(listColumn, 0);
	JTable tblVoca = new JTable();
    JScrollPane listSp = new JScrollPane(tblVoca);

    // create pnlQuiz
	JPanel pnlQuiz = new JPanel();
	JLabel lblTitleQuiz = new JLabel();
	String strFormat[] = { "명사", "동사", "형용사" };
	JComboBox cmdFormat = new JComboBox(strFormat);
	JTextField txtQuizNumber = new JTextField();
	JLabel lblQs = new JLabel();
	JLabel lblScore = new JLabel();
	JButton btnSubmit = new JButton();
	JLabel lblQuizNumber = new JLabel();
	JLabel lblQuizTime = new JLabel();
	JLabel lblQuiz = new JLabel();
	JRadioButton radQuizzes[] = new JRadioButton[4];
	ButtonGroup btnGroup = new ButtonGroup();
	JButton btnNextQuiz = new JButton();

	MainFrame() {

		pnlBg.setLayout(null);
		pnlBg.addMouseListener(this);
		pnlBg.addMouseMotionListener(this);
		pnlBg.setBackground(new Color(39, 39, 39));
		add(pnlBg);

		pnlBg.add(pnlComponent);
		pnlComponent.setLayout(cardManager);
		pnlComponent.setBounds(0, 0, 891, 529);
		pnlComponent.setBackground(new Color(39, 39, 39));
		pnlComponent.add(pnlSub, "sub");
		pnlComponent.add(pnlMain, "main");

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/title.png"));
		setUndecorated(true);
		setTitle("Login & SignUP");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 891, 529);
		setLocationRelativeTo(null);

	}

	int xx, xy;

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x - xx, y - xy);

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		setOpacity((float) 0.8);
		xx = e.getX();
		xy = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setOpacity((float) 1.0);

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
