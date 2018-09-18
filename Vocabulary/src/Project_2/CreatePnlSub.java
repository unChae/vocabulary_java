package Project_2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreatePnlSub extends JFrame implements ActionListener {

	// create another variable
	CardLayout cardManager = new CardLayout();
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	// create sub panel

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

	// take over background panel
	JPanel pnlBg;
	LoginClass login;

	CreatePnlSub(JPanel pnlBg) {
		this.pnlBg = pnlBg;

		// Object generation
		LoginClass login = new LoginClass();
		this.login = login;

		// insert sub panel
		// set layout
		// set opaque
		MainFrame.pnlSub.setLayout(null);
		MainFrame.pnlSub.setOpaque(false);

		// insert gif image
		// add lblGif to the pnlBG
		MainFrame.pnlSub.add(lblGif);
		lblGif.setBounds(0, 0, 400, 564);
		lblGif.setIcon(imgBg);

		// cardLayout configuration
		MainFrame.pnlSub.add(pnlLogin);
		pnlLogin.setBounds(400, 0, 400, 564);
		pnlLogin.setOpaque(false);
		pnlLogin.setLayout(cardManager);
		pnlLogin.add(pnlAccess, "Access");
		pnlLogin.add(pnlAccount, "Account");

		// pnlAccess
		// JPanel pnlAccess = new JPanel();
		// JLabel lblMainTitle = new JLabel();
		// JLabel lblId = new JLabel();
		// JLabel lblPwd = new JLabel();
		// JTextField txtId = new JTextField();
		// JPasswordField txtPwd = new JPasswordField();
		// JButton btnLogin = new JButton();
		// JButton btnNewAccount = new JButton();

		pnlAccess.setOpaque(false);
		pnlAccess.setLayout(null);

		// add lblMainTitle to the pnlAccess
		// set font
		// set position
		pnlAccess.add(lblMainTitle);
		lblMainTitle.setText("Voca Store");
		lblMainTitle.setForeground(Color.WHITE);
		lblMainTitle.setFont(new Font("Bell MT", Font.PLAIN, 40));
		lblMainTitle.setBounds(115, 50, 200, 100);

		// add lblId to the pnlAccess
		// set font
		// set position
		pnlAccess.add(lblId);
		lblId.setText("User");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblId.setBounds(80, 180, 150, 30);

		// add lblPwd to the pnlAccess
		// set font
		// set position
		pnlAccess.add(lblPwd);
		lblPwd.setText("Password");
		lblPwd.setForeground(Color.WHITE);
		lblPwd.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblPwd.setBounds(80, 280, 150, 30);

		// add txtId to the pnlAccess
		// set font
		// set border
		// set position
		pnlAccess.add(txtId);
		txtId.setOpaque(false);
		txtId.setForeground(Color.WHITE);
		txtId.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		txtId.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		txtId.setCaretColor(Color.white);
		txtId.setBounds(80, 210, 250, 40);

		// add txtPwd to the pnlAccess
		// set font
		// set border
		// set position
		pnlAccess.add(txtPwd);
		txtPwd.setOpaque(false);
		txtPwd.setForeground(Color.WHITE);
		txtPwd.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		txtPwd.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		txtPwd.setCaretColor(Color.white);
		txtPwd.setBounds(80, 310, 250, 40);

		// add btnLogin to the pnlAccess
		// set font
		// set border
		// set cursor
		// set name
		// set position
		pnlAccess.add(btnLogin);
		btnLogin.setText("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		btnLogin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setCursor(cursor);
		btnLogin.addActionListener(this);
		btnLogin.setName("Login");
		btnLogin.setBounds(230, 380, 100, 35);

		// add btnNewAccount to the pnlAccess
		// set font
		// set border
		// set cursor
		// set name
		// set position
		pnlAccess.add(btnNewAccount);
		btnNewAccount.setText("Select create new account");
		btnNewAccount.setForeground(Color.WHITE);
		btnNewAccount.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		btnNewAccount.setFocusPainted(false);
		btnNewAccount.setBorderPainted(false);
		btnNewAccount.setContentAreaFilled(false);
		btnNewAccount.setCursor(cursor);
		btnNewAccount.addActionListener(this);
		btnNewAccount.setName("NewAccount");
		btnNewAccount.setBounds(80, 450, 250, 25);

		// pnlAccount
		// JPanel pnlAccount = new JPanel();
		// JLabel lblTitle = new JLabel();
		// String strName[] = {};
		// JLabel lblInfor[] = new JLabel[4];
		// JTextField txtInfor[] = new JTextField[4];
		// JButton btnCreate = new JButton();
		// JButton btnBack = new JButton();
		// ImageIcon imgBack = new ImageIcon("img/backLogin.gif");
		// JComboBox cmdEmail = new JComboBox();
		// String strEmail[] = {};

		pnlAccount.setOpaque(false);
		pnlAccount.setLayout(null);

		// add lblMainTitle to the pnlAccount
		// set font
		// set position
		pnlAccount.add(lblTitle);
		lblTitle.setText("Sign UP");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		lblTitle.setBounds(150, 30, 200, 50);

		// add lblInfor to the pnlAccount
		// set font
		// set position
		// add txtInfor to the pnlAccount
		// set position
		for (int i = 0; i < strName.length; i++) {
			lblInfor[i] = new JLabel(strName[i]);
			pnlAccount.add(lblInfor[i]);
			lblInfor[i].setForeground(Color.WHITE);
			lblInfor[i].setFont(new Font("±¼¸²", Font.PLAIN, 14));
			lblInfor[i].setBounds(80, 120 + i * 80, 100, 14);

			txtInfor[i] = new JTextField();
			pnlAccount.add(txtInfor[i]);
			txtInfor[i].setBounds(80, 150 + i * 80, 250, 24);
		}
		txtInfor[0].setBounds(80, 150, 148, 24);

		// add btnCreate to the pnlAccount
		// set font
		// set border
		// set cursor
		// set name
		// set position
		pnlAccount.add(btnCreate);
		btnCreate.setText("Create!");
		btnCreate.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		btnCreate.setFocusPainted(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setCursor(cursor);
		btnCreate.addActionListener(this);
		btnCreate.setName("Create");
		btnCreate.setBounds(230, 450, 100, 35);

		// add btnBack to the pnlAccount
		// set border
		// set cursor
		// set name
		// set position
		pnlAccount.add(btnBack);
		btnBack.setBounds(50, 30, 50, 50);
		btnBack.setIcon(imgBack);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(cursor);
		btnBack.addActionListener(this);
		btnBack.setName("Back");

		// add cmdEmail to the pnlAccount
		// set model
		// set font
		// set position
		pnlAccount.add(cmdEmail);
		cmdEmail.setModel(mdlEmail);
		cmdEmail.setBackground(Color.WHITE);
		cmdEmail.setFont(new Font("", Font.PLAIN, 12));
		cmdEmail.setBounds(230, 150, 100, 24);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str = ((JButton) e.getSource()).getName();
		switch (str) {
		case "Login":
			login.login(txtId.getText(), txtPwd.getText());
			System.out.println(login.success);
			if (login.success == true) {
				MainFrame.mainCard.show(pnlBg, MainFrame.pnlMain.getName());
			}
			break;
		case "NewAccount":
			cardManager.show(pnlLogin, "Account");
			break;
		case "Create":
			login.createAccount(txtInfor[0].getText(), (String) cmdEmail.getSelectedItem(), txtInfor[1].getText(),
					txtInfor[2].getText(), txtInfor[3].getText());
			break;
		case "Back":
			cardManager.show(pnlLogin, "Access");
			for (int i = 0; i < txtInfor.length; i++) {
				txtInfor[i].setText("");
			}
			cmdEmail.setSelectedIndex(0);
			break;
		default:
			break;
		}
	}
}
