package Project_4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SubPanelFrame implements ActionListener {

	LoginClass login;

	MainFrame f;

	SubPanelFrame(MainFrame f) {
		this.f = f;

		// Object generation
		LoginClass login = new LoginClass();
		this.login = login;

		// insert sub panel
		// set layout
		// set opaque

		f.pnlSub.setBounds(0, 30, 800, 534);
		f.pnlSub.setLayout(null);
		f.pnlSub.setOpaque(false);

		// insert gif image
		// add lblGif to the pnlComponent
		f.pnlSub.add(f.lblGif);
		f.lblGif.setBounds(0, 0, 400, 564);
		f.lblGif.setIcon(f.imgBg);

		// cardLayout configuration
		f.pnlSub.add(f.pnlLogin);
		f.pnlLogin.setBounds(400, 0, 400, 564);
		f.pnlLogin.setOpaque(false);
		f.pnlLogin.setLayout(f.cardManager);
		f.pnlLogin.add(f.pnlAccess, "Access");
		f.pnlLogin.add(f.pnlAccount, "Account");

		// pnlAccess
		// JPanel pnlAccess = new JPanel();
		// JLabel lblMainTitle = new JLabel();
		// JLabel lblId = new JLabel();
		// JLabel lblPwd = new JLabel();
		// JTextField txtId = new JTextField();
		// JPasswordField txtPwd = new JPasswordField();
		// JButton btnLogin = new JButton();
		// JButton btnNewAccount = new JButton();

		f.pnlAccess.setOpaque(false);
		f.pnlAccess.setLayout(null);

		// add lblMainTitle to the pnlAccess
		// set font
		// set position
		f.pnlAccess.add(f.lblMainTitle);
		f.lblMainTitle.setText("Voca Store");
		f.lblMainTitle.setForeground(Color.WHITE);
		f.lblMainTitle.setFont(new Font("Bell MT", Font.PLAIN, 40));
		f.lblMainTitle.setBounds(115, 50, 200, 100);

		// add lblId to the pnlAccess
		// set font
		// set position
		f.pnlAccess.add(f.lblId);
		f.lblId.setText("User");
		f.lblId.setForeground(Color.WHITE);
		f.lblId.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		f.lblId.setBounds(80, 180, 150, 30);

		// add lblPwd to the pnlAccess
		// set font
		// set position
		f.pnlAccess.add(f.lblPwd);
		f.lblPwd.setText("Password");
		f.lblPwd.setForeground(Color.WHITE);
		f.lblPwd.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		f.lblPwd.setBounds(80, 280, 150, 30);

		// add txtId to the pnlAccess
		// set font
		// set border
		// set position
		f.pnlAccess.add(f.txtId);
		f.txtId.setOpaque(false);
		f.txtId.setForeground(Color.WHITE);
		f.txtId.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		f.txtId.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		f.txtId.setCaretColor(Color.white);
		f.txtId.setBounds(80, 210, 250, 40);

		// add txtPwd to the pnlAccess
		// set font
		// set border
		// set position
		f.pnlAccess.add(f.txtPwd);
		f.txtPwd.setOpaque(false);
		f.txtPwd.setForeground(Color.WHITE);
		f.txtPwd.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		f.txtPwd.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		f.txtPwd.setCaretColor(Color.white);
		f.txtPwd.setBounds(80, 310, 250, 40);

		// add btnLogin to the pnlAccess
		// set font
		// set border
		// set cursor
		// set name
		// set position
		f.pnlAccess.add(f.btnLogin);
		f.btnLogin.setText("Login");
		f.btnLogin.setForeground(Color.WHITE);
		f.btnLogin.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		f.btnLogin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		f.btnLogin.setFocusPainted(false);
		f.btnLogin.setContentAreaFilled(false);
		f.btnLogin.setCursor(f.cursor);
		f.btnLogin.addActionListener(this);
		f.btnLogin.setName("Login");
		f.btnLogin.setBounds(230, 380, 100, 35);

		// add btnNewAccount to the pnlAccess
		// set font
		// set border
		// set cursor
		// set name
		// set position
		f.pnlAccess.add(f.btnNewAccount);
		f.btnNewAccount.setText("Select create new account");
		f.btnNewAccount.setForeground(Color.WHITE);
		f.btnNewAccount.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		f.btnNewAccount.setFocusPainted(false);
		f.btnNewAccount.setBorderPainted(false);
		f.btnNewAccount.setContentAreaFilled(false);
		f.btnNewAccount.setCursor(f.cursor);
		f.btnNewAccount.addActionListener(this);
		f.btnNewAccount.setName("NewAccount");
		f.btnNewAccount.setBounds(80, 450, 250, 25);

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

		f.pnlAccount.setOpaque(false);
		f.pnlAccount.setLayout(null);

		// add lblMainTitle to the pnlAccount
		// set font
		// set position
		f.pnlAccount.add(f.lblTitle);
		f.lblTitle.setText("Sign UP");
		f.lblTitle.setForeground(Color.WHITE);
		f.lblTitle.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		f.lblTitle.setBounds(150, 30, 200, 50);

		// add lblInfor to the pnlAccount
		// set font
		// set position
		// add txtInfor to the pnlAccount
		// set position
		for (int i = 0; i < f.strName.length; i++) {
			f.lblInfor[i] = new JLabel(f.strName[i]);
			f.pnlAccount.add(f.lblInfor[i]);
			f.lblInfor[i].setForeground(Color.WHITE);
			f.lblInfor[i].setFont(new Font("±¼¸²", Font.PLAIN, 14));
			f.lblInfor[i].setBounds(80, 120 + i * 80, 100, 14);

			f.txtInfor[i] = new JTextField();
			f.pnlAccount.add(f.txtInfor[i]);
			f.txtInfor[i].setBounds(80, 150 + i * 80, 250, 24);
		}
		f.txtInfor[0].setBounds(80, 150, 148, 24);

		// add btnCreate to the pnlAccount
		// set font
		// set border
		// set cursor
		// set name
		// set position
		f.pnlAccount.add(f.btnCreate);
		f.btnCreate.setText("Create!");
		f.btnCreate.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		f.btnCreate.setForeground(Color.WHITE);
		f.btnCreate.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		f.btnCreate.setFocusPainted(false);
		f.btnCreate.setContentAreaFilled(false);
		f.btnCreate.setCursor(f.cursor);
		f.btnCreate.addActionListener(this);
		f.btnCreate.setName("Create");
		f.btnCreate.setBounds(230, 450, 100, 35);

		// add btnBack to the pnlAccount
		// set border
		// set cursor
		// set name
		// set position
		f.pnlAccount.add(f.btnBack);
		f.btnBack.setBounds(50, 30, 50, 50);
		f.btnBack.setIcon(f.imgBack);
		f.btnBack.setFocusPainted(false);
		f.btnBack.setBorderPainted(false);
		f.btnBack.setContentAreaFilled(false);
		f.btnBack.setCursor(f.cursor);
		f.btnBack.addActionListener(this);
		f.btnBack.setName("Back");

		// add cmdEmail to the pnlAccount
		// set model
		// set font
		// set position
		f.pnlAccount.add(f.cmdEmail);
		f.cmdEmail.setModel(f.mdlEmail);
		f.cmdEmail.setBackground(Color.WHITE);
		f.cmdEmail.setFont(new Font("", Font.PLAIN, 12));
		f.cmdEmail.setBounds(230, 150, 100, 24);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str = ((JButton) e.getSource()).getName();
		switch (str) {
		case "Login":
			login.login(f.txtId.getText(), f.txtPwd.getText());
			if (login.success == true) {
				f.setTitle("Voca Store");
				f.lblUserName.setText(login.userName);
				f.cardManager.show(f.pnlComponent, "main");
				f.pnlMenu.setVisible(true);
				login.success = false;
			}
			break;
		case "NewAccount":
			f.cardManager.show(f.pnlLogin, "Account");
			break;
		case "Create":
			login.createAccount(f.txtInfor[0].getText(), (String) f.cmdEmail.getSelectedItem(), f.txtInfor[1].getText(),
					f.txtInfor[2].getText(), f.txtInfor[3].getText());
			if (login.code == true) {
				login.code = false;
				f.cardManager.show(f.pnlLogin, "Access");
			}
			break;
		case "Back":
			f.cardManager.show(f.pnlLogin, "Access");
			for (int i = 0; i < f.txtInfor.length; i++) {
				f.txtInfor[i].setText("");
			}
			f.cmdEmail.setSelectedIndex(0);
			break;
		default:
			break;
		}
	}
}
