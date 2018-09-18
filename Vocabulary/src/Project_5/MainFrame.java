package Project_5;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class MainFrame extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

	private JPanel contentPane;

	ImageIcon imgExit = new ImageIcon("img/exit.png");
	ImageIcon imgTitle = new ImageIcon("img/titleIcon.png");
	ImageIcon imgGif = new ImageIcon("img/bgLogin.gif");
	ImageIcon imgUserLogin = new ImageIcon("img/userLogin.png");
	ImageIcon imgLockLogin = new ImageIcon("img/lockLogin.png");
	ImageIcon imgBtnLogin = new ImageIcon("img/btnLogin.png");
	ImageIcon imgTitleLogin = new ImageIcon("img/titleLogin.png");
	ImageIcon imgBackLogin = new ImageIcon("img/backLogin.png");
	

	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	private JTextField txtId = new JTextField();
	private JPasswordField txtPwd = new JPasswordField();

	JPanel pnlMain = new JPanel();
	JPanel pnlLogin = new JPanel();
	JLabel lblGIF = new JLabel("");
	JPanel pnlLgComponent = new JPanel();
	JPanel pnlAccess = new JPanel();
	JLabel lblId = new JLabel("");
	JLabel lblPwd = new JLabel("");
	JButton btnLogin = new JButton("Login");
	JButton btnAccount = new JButton("Select create new Account");
	JButton btnExit = new JButton("");
	JLabel lblVocaLibrary = new JLabel("");
	JPanel pnlAccount = new JPanel();
	JPanel pnlComponent = new JPanel();
	JTextField txtSetEmail = new JTextField();
	JTextField txtSetPwd;
	JTextField txtSetName;
	JTextField txtSetPhone;
	JButton btnCreate = new JButton();
	String[] emailName = {"naver.com","gamil.com","daum.net"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/title.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 529);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseListener(this);
		contentPane.addMouseMotionListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlMain.setBounds(0, 0, 891, 529);
		contentPane.add(pnlMain);
		pnlMain.setLayout(new CardLayout());

		pnlLogin.setBackground(new Color(39, 39, 39));
		pnlMain.add(pnlLogin, "Login");
		pnlLogin.setLayout(null);

		lblGIF.setIcon(imgGif);
		lblGIF.setBounds(0, 0, 439, 529);
		pnlLogin.add(lblGIF);

		pnlLgComponent.setBackground(new Color(39, 39, 39));
		pnlLgComponent.setBounds(439, 0, 452, 529);
		pnlLogin.add(pnlLgComponent);
		pnlLgComponent.setLayout(new CardLayout());

		pnlAccess.setOpaque(false);
		pnlLgComponent.add(pnlAccess, "Access");
		pnlAccess.setLayout(null);

		lblId.setIcon(imgUserLogin);
		lblId.setBounds(47, 263, 40, 40);
		pnlAccess.add(lblId);

		lblPwd.setIcon(imgLockLogin);
		lblPwd.setBounds(47, 350, 40, 40);
		pnlAccess.add(lblPwd);

		txtId.setForeground(Color.LIGHT_GRAY);
		txtId.setOpaque(false);
		txtId.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		txtId.setCaretColor(Color.LIGHT_GRAY);
		txtId.setBounds(120, 279, 291, 24);
		pnlAccess.add(txtId);
		txtId.setColumns(10);

		txtPwd.setForeground(Color.LIGHT_GRAY);
		txtPwd.setOpaque(false);
		txtPwd.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
		txtPwd.setCaretColor(Color.LIGHT_GRAY);
		txtPwd.setColumns(10);
		txtPwd.setBounds(120, 366, 291, 24);
		pnlAccess.add(txtPwd);

		btnLogin.setIcon(imgBtnLogin);
		btnLogin.setCursor(cursor);
		btnLogin.addActionListener(this);
		btnLogin.setForeground(new Color(39, 39, 39));
		btnLogin.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBounds(355, 446, 56, 40);
		pnlAccess.add(btnLogin);

		btnAccount.setForeground(Color.LIGHT_GRAY);
		btnAccount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		btnAccount.addActionListener(this);
		btnAccount.setFocusPainted(false);
		btnAccount.setBorderPainted(false);
		btnAccount.setContentAreaFilled(false);
		btnAccount.setCursor(cursor);
		btnAccount.setBounds(50, 454, 291, 27);
		pnlAccess.add(btnAccount);

		btnExit.setBounds(413, 12, 25, 25);
		pnlAccess.add(btnExit);
		btnExit.setIcon(imgExit);
		btnExit.setCursor(cursor);
		btnExit.setFocusPainted(false);
		btnExit.setBorderPainted(false);
		btnExit.setContentAreaFilled(false);

		lblVocaLibrary.setIcon(imgTitleLogin);
		lblVocaLibrary.setBounds(72, 59, 320, 75);
		pnlAccess.add(lblVocaLibrary);
		btnExit.addActionListener(this);

		pnlAccount.setOpaque(false);
		pnlLgComponent.add(pnlAccount, "Account");
		pnlAccount.setLayout(null);
		
		JLabel lblSetEmail = new JLabel("Email");
		lblSetEmail.setForeground(Color.WHITE);
		lblSetEmail.setBounds(14, 114, 62, 18);
		pnlAccount.add(lblSetEmail);
		
		JLabel lblSetPwd = new JLabel("Password");
		lblSetPwd.setForeground(Color.WHITE);
		lblSetPwd.setBounds(14, 194, 75, 18);
		pnlAccount.add(lblSetPwd);
		
		JLabel lblSetName = new JLabel("Name");
		lblSetName.setForeground(Color.WHITE);
		lblSetName.setBounds(14, 274, 62, 18);
		pnlAccount.add(lblSetName);
		
		JLabel lblSetPhone = new JLabel("Phone Number");
		lblSetPhone.setForeground(Color.WHITE);
		lblSetPhone.setBounds(14, 354, 104, 18);
		pnlAccount.add(lblSetPhone);
		
		txtSetEmail.setBounds(14, 144, 300, 24);
		txtSetEmail.setColumns(10);
		pnlAccount.add(txtSetEmail);
		
		txtSetPwd = new JTextField();
		txtSetPwd.setColumns(10);
		txtSetPwd.setBounds(14, 224, 424, 24);
		pnlAccount.add(txtSetPwd);
		
		txtSetName = new JTextField();
		txtSetName.setColumns(10);
		txtSetName.setBounds(14, 304, 424, 24);
		pnlAccount.add(txtSetName);
		
		txtSetPhone = new JTextField();
		txtSetPhone.setColumns(10);
		txtSetPhone.setBounds(14, 384, 424, 24);
		pnlAccount.add(txtSetPhone);
		
		JComboBox cmdSetEmail = new JComboBox();
		cmdSetEmail.setBounds(316, 144, 122, 24);
		pnlAccount.add(cmdSetEmail);
		
		btnBack.setBounds(14, 12, 50, 50);
		btnBack.setIcon(imgBackLogin);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(this);
		pnlAccount.add(btnBack);
		btnCreate.setText("Create");
		
		btnCreate.setBounds(180, 456, 92, 27);
		pnlAccount.add(btnCreate);

		pnlMain.add(pnlComponent, "Component");
		pnlComponent.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(Color.DARK_GRAY);
		pnlMenu.setForeground(Color.BLACK);
		pnlMenu.setBounds(0, 0, 286, 529);
		pnlComponent.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBounds(14, 12, 50, 50);
		pnlMenu.add(btnNewButton);
		
		JLabel lblUserName = new JLabel("Name");
		lblUserName.setBounds(14, 74, 258, 18);
		pnlMenu.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("User Infor");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 27));
		lblNewLabel.setBounds(78, 12, 194, 50);
		pnlMenu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(14, 105, 258, 18);
		pnlMenu.add(lblNewLabel_1);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(14, 135, 258, 18);
		pnlMenu.add(lblCount);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 184, 258, 117);
		pnlMenu.add(textArea);
		
		JLabel lblMemo = new JLabel("Memo");
		lblMemo.setBounds(14, 165, 258, 18);
		pnlMenu.add(lblMemo);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 313, 286, 40);
		pnlMenu.add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 365, 286, 40);
		pnlMenu.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(0, 417, 286, 40);
		pnlMenu.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(0, 469, 286, 40);
		pnlMenu.add(button_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(251, 184, 21, 117);
		pnlMenu.add(scrollBar);
		
		JPanel pnlMenubar = new JPanel();
		pnlMenubar.setBackground(Color.WHITE);
		pnlMenubar.setBounds(286, 0, 605, 52);
		pnlComponent.add(pnlMenubar);
		pnlMenubar.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(539, 0, 52, 52);
		pnlMenubar.add(btnNewButton_2);
		
		JLabel lblVocaLibrary_1 = new JLabel("Voca Library");
		lblVocaLibrary_1.setBounds(14, 0, 250, 52);
		pnlMenubar.add(lblVocaLibrary_1);
		
		JPanel pnlMainCard = new JPanel();
		pnlMainCard.setBounds(286, 51, 605, 478);
		pnlComponent.add(pnlMainCard);
		pnlMainCard.setLayout(new CardLayout(0, 0));
		
		JPanel pnlSearch = new JPanel();
		pnlSearch.setBackground(Color.WHITE);
		pnlSearch.setForeground(Color.WHITE);
		pnlMainCard.add(pnlSearch, "name_27749135228924");
		pnlSearch.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 12, 605, 94);
		pnlSearch.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(14, 12, 121, 64);
		panel_1.add(lblSearch);
		lblSearch.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 42));
		
		textField = new JTextField();
		textField.setBounds(149, 45, 237, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel pnlInput = new JPanel();
		pnlInput.setBackground(Color.WHITE);
		pnlMainCard.add(pnlInput, "name_27751169664213");
		pnlInput.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 113, 605, 365);
		pnlInput.add(table);
		
		JButton btnNewButton_3 = new JButton("Del");
		btnNewButton_3.setBounds(522, 77, 69, 24);
		pnlInput.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Explorer");
		lblNewLabel_2.setBounds(14, 80, 62, 18);
		pnlInput.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(81, 76, 175, 24);
		pnlInput.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEditor = new JLabel("Editor");
		lblEditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditor.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(39,39,39)));
		lblEditor.setFont(new Font("±¼¸²", Font.PLAIN, 28));
		lblEditor.setBounds(10, 12, 581, 52);
		pnlInput.add(lblEditor);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(439, 76, 69, 24);
		pnlInput.add(btnEdit);
		
		JPanel pnlQuiz = new JPanel();
		pnlQuiz.setBackground(Color.WHITE);
		pnlMainCard.add(pnlQuiz, "name_27753032651310");
		pnlQuiz.setLayout(null);
		
		JLabel lblQuiz = new JLabel("Quiz");
		lblQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuiz.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(39,39,39)));
		lblQuiz.setFont(new Font("±¼¸²", Font.PLAIN, 28));
		lblQuiz.setBounds(10, 12, 581, 52);
		pnlQuiz.add(lblQuiz);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 76, 124, 24);
		pnlQuiz.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Qs");
		lblNewLabel_4.setBounds(202, 79, 20, 18);
		pnlQuiz.add(lblNewLabel_4);
		
		JLabel lblScore = new JLabel("Score :");
		lblScore.setBounds(365, 79, 107, 18);
		pnlQuiz.add(lblScore);
		
		JButton btnNewButton_4 = new JButton("submit");
		btnNewButton_4.setBounds(486, 75, 105, 27);
		pnlQuiz.add(btnNewButton_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 76, 62, 24);
		pnlQuiz.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question.1");
		lblQuestion.setBounds(10, 144, 107, 18);
		pnlQuiz.add(lblQuestion);
		
		JLabel lblM = new JLabel("M");
		lblM.setFont(new Font("±¼¸²", Font.PLAIN, 34));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(39,39,39)));
		lblM.setBounds(10, 174, 581, 106);
		pnlQuiz.add(lblM);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(500, 439, 91, 27);
		pnlQuiz.add(btnNext);
		
		JLabel label_4 = new JLabel("? / ?");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(529, 114, 62, 18);
		pnlQuiz.add(label_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(10, 307, 581, 27);
		pnlQuiz.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(10, 338, 581, 27);
		pnlQuiz.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(10, 369, 581, 27);
		pnlQuiz.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setBounds(10, 400, 581, 27);
		pnlQuiz.add(radioButton_2);
	}

	int xx = 0;
	int xy = 0;
	JButton btnBack = new JButton();
	private JTextField textField;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_1;
	
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btnAccount) {
			CardLayout cardManager = (CardLayout)(pnlLgComponent.getLayout());
			cardManager.show(pnlLgComponent, "Account");
		} else if (e.getSource() == btnBack) {
			CardLayout cardManager = (CardLayout)(pnlLgComponent.getLayout());
			cardManager.show(pnlLgComponent, "Access");
		}
	}
}
