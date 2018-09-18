package Project_10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class SubPanelFrame implements ActionListener, KeyListener {

	LoginClass login;
	UserInforClass userInfor;
	DataClass data;
	MainFrame f;

	SubPanelFrame(DataClass data, MainFrame f) {
		this.f = f;

		// Object generation
		LoginClass login = new LoginClass();
		this.login = login;
		this.data = data;
		UserInforClass userInfor = new UserInforClass(data);
		this.userInfor = userInfor;

		// insert sub panel
		// set layout
		// set opaque

		f.pnlSub.setBounds(0, 0, 891, 529);
		f.pnlSub.setLayout(null);
		f.pnlSub.setOpaque(false);

		// insert gif image
		// add lblGif to the pnlComponent
		f.pnlSub.add(f.lblGif);
		f.lblGif.setBounds(0, 0, 439, 529);
		f.lblGif.setIcon(f.imgBg);

		// cardLayout configuration
		f.pnlSub.add(f.pnlLogin);
		f.pnlLogin.setBounds(439, 0, 452, 529);
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

		// add btnExitLogin to the pnlAccess
		// set image
		// set name
		// set position
		f.pnlAccess.add(f.btnExitLogin);
		f.btnExitLogin.setIcon(f.imgExitLogin);
		f.btnExitLogin.setCursor(f.cursor);
		f.btnExitLogin.setFocusPainted(false);
		f.btnExitLogin.setBorderPainted(false);
		f.btnExitLogin.setContentAreaFilled(false);
		f.btnExitLogin.addActionListener(this);
		f.btnExitLogin.setName("ExitLogin");
		f.btnExitLogin.setBounds(413, 12, 25, 25);

		// add lblMainTitle to the pnlAccess
		// set font
		// set position
		f.pnlAccess.add(f.lblMainTitle);
		f.lblMainTitle.setIcon(f.imgTitleLogin);
		f.lblMainTitle.setBounds(72, 59, 320, 75);

		// add lblId to the pnlAccess
		// set font
		// set position
		f.pnlAccess.add(f.lblId);
		f.lblId.setIcon(f.imgUserLogin);
		f.lblId.setBounds(47, 263, 40, 40);

		// add lblPwd to the pnlAccess
		// set font
		// set position
		f.pnlAccess.add(f.lblPwd);
		f.lblPwd.setIcon(f.imgLockLogin);
		f.lblPwd.setBounds(47, 350, 40, 40);

		// add txtId to the pnlAccess
		// set font
		// set border
		// set position
		f.pnlAccess.add(f.txtId);
		f.txtId.setOpaque(false);
		f.txtId.setForeground(Color.LIGHT_GRAY);
		f.txtId.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		f.txtId.setCaretColor(Color.LIGHT_GRAY);
		f.txtId.setBounds(120, 279, 291, 24);

		// add txtPwd to the pnlAccess
		// set font
		// set border
		// set position
		f.pnlAccess.add(f.txtPwd);
		f.txtPwd.setOpaque(false);
		f.txtPwd.setForeground(Color.LIGHT_GRAY);
		f.txtPwd.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
		f.txtPwd.addKeyListener(this);
		f.txtPwd.setCaretColor(Color.LIGHT_GRAY);
		f.txtPwd.setBounds(120, 366, 291, 24);

		// add btnLogin to the pnlAccess
		// set image
		// set cursor
		// set name
		// set position
		f.pnlAccess.add(f.btnLogin);
		f.btnLogin.setIcon(f.imgBtnLogin);
		f.btnLogin.setFocusPainted(false);
		f.btnLogin.setBorderPainted(false);
		f.btnLogin.setContentAreaFilled(false);
		f.btnLogin.setCursor(f.cursor);
		f.btnLogin.addActionListener(this);
		f.btnLogin.setName("Login");
		f.btnLogin.setBounds(355, 446, 56, 40);

		// add btnNewAccount to the pnlAccess
		// set font
		// set border
		// set cursor
		// set name
		// set position
		f.pnlAccess.add(f.btnNewAccount);
		f.btnNewAccount.setText("Select create new account");
		f.btnNewAccount.setForeground(Color.LIGHT_GRAY);
		f.btnNewAccount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		f.btnNewAccount.setFocusPainted(false);
		f.btnNewAccount.setBorderPainted(false);
		f.btnNewAccount.setContentAreaFilled(false);
		f.btnNewAccount.setCursor(f.cursor);
		f.btnNewAccount.addActionListener(this);
		f.btnNewAccount.setName("NewAccount");
		f.btnNewAccount.setBounds(50, 454, 291, 27);

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
		f.lblTitle.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		f.lblTitle.setBounds(328, 30, 150, 50);

		// add lblInfor to the pnlAccount
		// set font
		// set position
		// add txtInfor to the pnlAccount
		// set position
		for (int i = 0; i < f.strName.length; i++) {
			f.lblInfor[i] = new JLabel(f.strName[i]);
			f.pnlAccount.add(f.lblInfor[i]);
			f.lblInfor[i].setForeground(Color.WHITE);
			f.lblInfor[i].setBounds(14, 120 + i * 80, 100, 14);

			f.txtInfor[i] = new JTextField();
			f.pnlAccount.add(f.txtInfor[i]);
			f.txtInfor[i].setBounds(14, 150 + i * 80, 424, 24);
		}
		f.txtInfor[0].setBounds(14, 150, 300, 24);

		// add btnCreate to the pnlAccount
		// set font
		// set border
		// set cursor
		// set name
		// set position
		f.pnlAccount.add(f.btnCreate);
		f.btnCreate.setText("Create");
		f.btnCreate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		f.btnCreate.setForeground(Color.WHITE);
		f.btnCreate.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		f.btnCreate.setFocusPainted(false);
		f.btnCreate.setBorderPainted(false);
		f.btnCreate.setContentAreaFilled(false);
		f.btnCreate.setCursor(f.cursor);
		f.btnCreate.addActionListener(this);
		f.btnCreate.setName("Create");
		f.btnCreate.setBounds(180, 456, 92, 27);

		// add btnBack to the pnlAccount
		// set border
		// set cursor
		// set name
		// set position
		f.pnlAccount.add(f.btnBack);
		f.btnBack.setIcon(f.imgBack);
		f.btnBack.setFocusPainted(false);
		f.btnBack.setBorderPainted(false);
		f.btnBack.setContentAreaFilled(false);
		f.btnBack.setCursor(f.cursor);
		f.btnBack.addActionListener(this);
		f.btnBack.setName("Back");
		f.btnBack.setBounds(14, 30, 50, 50);

		// add cmdEmail to the pnlAccount
		// set model
		// set font
		// set position
		f.pnlAccount.add(f.cmdEmail);
		f.cmdEmail.setModel(f.mdlEmail);
		f.cmdEmail.setBackground(Color.WHITE);
		f.cmdEmail.setBounds(316, 150, 122, 24);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str = ((JButton) e.getSource()).getName();
		switch (str) {
		case "ExitLogin":
			System.exit(0);
			break;
		case "Login":
			login.login(f.txtId.getText(), f.txtPwd.getText());
			if (login.success == true) {
				f.cardManager.show(f.pnlComponent, "main");
				userInfor.setUserInfor(f.txtId.getText());
				new MainPanelFrame(f, data);
				data.setTable();
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			login.login(f.txtId.getText(), f.txtPwd.getText());
			if (login.success == true) {
				f.cardManager.show(f.pnlComponent, "main");
				userInfor.setUserInfor(f.txtId.getText());
				new MainPanelFrame(f, data);
				data.setTable();
				login.success = false;
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
