package Project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {

	ImageIcon bgIMG = new ImageIcon("img/bgLogin.gif");
	ImageIcon backIMG = new ImageIcon("img/backLogin.png");

	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	CardLayout cardManager = new CardLayout();

	// mainPanel, loginPanel ÀÇ background Panel
	JPanel bgPanel = new JPanel();

	/*
	 * mainPanel ³»¿ë
	 * 
	 * 
	 * 
	 */

	JPanel mainPanel = new JPanel();

	/*
	 * loginPanel ³»¿ë imgLabel, componentPanel ·Î ³ª´²Áü imgLabel gif ÀÌ¹ÌÁö »ý¼º
	 * componentPanel ·Î±×ÀÎ¿¡ ÇÊ¿äÇÑ ÄÄÆÛ³ÍÆ® »ý¼º
	 */

	JPanel loginPanel = new JPanel();

	JLabel imgLabel = new JLabel();
	JPanel componentPanel = new JPanel();

	JPanel accessPanel[] = new JPanel[2];

	JLabel loginTitleLabel = new JLabel();
	JLabel idTextLabel = new JLabel();
	JLabel pwdTextLabel = new JLabel();
	JTextField idTextField = new JTextField();
	JPasswordField pwdTextField = new JPasswordField();
	JButton loginButton = new JButton();
	JButton newAccountButton = new JButton();

	JLabel accountTitleLabel = new JLabel();
	String labelName[] = { "Email", "Password", "UserName", "PhoneNumber" };
	JLabel[] inforLabel = new JLabel[4];
	JTextField[] inforTextField = new JTextField[4];
	JButton makeButton = new JButton();
	JButton backButton = new JButton();

	LoginClass lg;

	LoginFrame(LoginClass lg) {
		this.lg = lg;

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/titleIcon.png"));
		setTitle("Login & SignUP");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);

		add(bgPanel);
		bgPanel.setLayout(cardManager);
		bgPanel.add(loginPanel, "login");
		bgPanel.add(mainPanel, "main");
		loginPanel.setLayout(null);
		loginPanel.setBackground(new Color(39, 39, 39));
		mainPanel.setLayout(null);

		// ct_imgLabel
		imgLabel.setBounds(0, 0, 400, 564);
		imgLabel.setIcon(bgIMG);
		loginPanel.add(imgLabel);

		// ct_componentPanel
		componentPanel.setBounds(400, 0, 400, 564);
		componentPanel.setBackground(new Color(39, 39, 39));
		loginPanel.add(componentPanel);

		// ct_accessPanel
		componentPanel.setLayout(cardManager);
		for (int i = 0; i < accessPanel.length; i++) {
			accessPanel[i] = new JPanel();
			accessPanel[i].setLayout(null);
			accessPanel[i].setOpaque(false);
			componentPanel.add(accessPanel[i], i + "");
		}

		// ct_loginComponent
		loginTitleLabel.setBounds(115, 50, 200, 100);
		loginTitleLabel.setText("Vocabulary");
		loginTitleLabel.setFont(new Font("Bell MT", Font.PLAIN, 40));
		loginTitleLabel.setForeground(Color.white);
		accessPanel[0].add(loginTitleLabel);

		idTextLabel.setBounds(80, 180, 150, 30);
		idTextLabel.setText("User");
		idTextLabel.setForeground(Color.white);
		idTextLabel.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		accessPanel[0].add(idTextLabel);

		pwdTextLabel.setBounds(80, 280, 150, 30);
		pwdTextLabel.setText("Password");
		pwdTextLabel.setForeground(Color.white);
		pwdTextLabel.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		accessPanel[0].add(pwdTextLabel);

		accessPanel[0].add(idTextField);
		idTextField.setBounds(80, 210, 250, 40);
		idTextField.setOpaque(false);
		idTextField.setForeground(Color.white);
		idTextField.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		idTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		idTextField.setCaretColor(Color.white);

		accessPanel[0].add(pwdTextField);
		pwdTextField.setBounds(80, 310, 250, 40);
		pwdTextField.setOpaque(false);
		pwdTextField.setForeground(Color.white);
		pwdTextField.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		pwdTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		pwdTextField.setCaretColor(Color.white);

		accessPanel[0].add(loginButton);
		loginButton.setBounds(230, 380, 100, 35);
		loginButton.setText("Login");
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		loginButton.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.white));
		loginButton.setFocusPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setCursor(cursor);
		loginButton.addActionListener(this);
		loginButton.setName("loginButton");

		accessPanel[0].add(newAccountButton);
		newAccountButton.setBounds(80, 450, 250, 25);
		newAccountButton.setText("Select create new account");
		newAccountButton.setForeground(Color.white);
		newAccountButton.setFocusPainted(false);
		newAccountButton.setBorderPainted(false);
		newAccountButton.setContentAreaFilled(false);
		newAccountButton.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		newAccountButton.setCursor(cursor);
		newAccountButton.addActionListener(this);
		newAccountButton.setName("newAccountButton");

		// ct_newAccount
		accountTitleLabel.setBounds(150, 30, 200, 50);
		accountTitleLabel.setText("Sign UP");
		accountTitleLabel.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		accountTitleLabel.setForeground(Color.white);
		accessPanel[1].add(accountTitleLabel);

		for (int i = 0; i < labelName.length; i++) {
			inforLabel[i] = new JLabel(labelName[i]);
			inforLabel[i].setFont(new Font("±¼¸²", Font.PLAIN, 14));
			inforLabel[i].setForeground(Color.white);
			inforLabel[i].setBounds(80, 120 + i * 80, 100, 14);
			accessPanel[1].add(inforLabel[i]);

			inforTextField[i] = new JTextField();
			inforTextField[i].setBounds(80, 150 + i * 80, 250, 24);
			accessPanel[1].add(inforTextField[i]);
		}

		makeButton.setText("Create!");
		makeButton.setBounds(230, 450, 100, 35);
		makeButton.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		makeButton.setForeground(Color.WHITE);
		makeButton.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.white));
		makeButton.setFocusPainted(false);
		makeButton.setContentAreaFilled(false);
		makeButton.setCursor(cursor);
		makeButton.addActionListener(this);
		makeButton.setName("makeButton");
		accessPanel[1].add(makeButton);

		backButton.setBounds(50, 30, 50, 50);
		backButton.setIcon(backIMG);
		backButton.setFocusPainted(false);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.addActionListener(this);
		backButton.setName("backButton");
		accessPanel[1].add(backButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str = ((JButton) e.getSource()).getName();

		switch (str) {
		case "loginButton":
			lg.login(inforTextField[0].getText(), inforTextField[1].getText(),cardManager, bgPanel);
			break;

		case "newAccountButton":
			cardManager.show(componentPanel, "1");
			break;

		case "backButton":
			cardManager.show(componentPanel, "0");
			for (int i = 0; i < labelName.length; i++) {
				inforTextField[i].setText("");
			}
			lg.code = false;
			break;

		case "makeButton":
			lg.checkAcount(inforTextField[0].getText());
			
			if (lg.overlap == true) {
				GmailSend mail = new GmailSend();
				int randomNo = (int) (Math.random() * 8999 + 1000);
				mail.GmailSet(inforTextField[0].getText(), "Vocabulary", "input this code \n" + randomNo);

				String input = JOptionPane.showInputDialog("Sended Email\nCheck your email");

				if (input.equals(randomNo + "")) {
					JOptionPane.showMessageDialog(null, "Success", "Vocabulray", JOptionPane.INFORMATION_MESSAGE);
					lg.code = true;
				} else {
					JOptionPane.showMessageDialog(null, "Fail", "Vocabulray", JOptionPane.INFORMATION_MESSAGE);
				}

				if (lg.code == true) {
					cardManager.show(componentPanel, "0");
					lg.code = false;
					lg.newAcount(inforTextField[0].getText(), inforTextField[1].getText(), inforTextField[2].getText(),
							inforTextField[3].getText());
					for (int i = 0; i < labelName.length; i++) {
						inforTextField[i].setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please authenticate the code", "Vocabulray",
							JOptionPane.INFORMATION_MESSAGE);
				}
				lg.overlap = false;
			}

			break;
		default:
			break;
		}
	}

}
