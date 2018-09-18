package Project_9;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class EditorFrame extends JFrame implements ActionListener{

	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	ImageIcon imgKanji = new ImageIcon("img/kanji.png");
	ImageIcon imgHiragana = new ImageIcon("img/hiragana.png");
	ImageIcon imgMean = new ImageIcon("img/mean.png");
	ImageIcon imgEdit = new ImageIcon("img/edit.png");

	JPanel contentPane = new JPanel();

	JPanel pnlBg = new JPanel();

	String strName[] = { "Chinese character", "Hiragana", "Mean" };
	JLabel lblImage[] = new JLabel[strName.length];
	JLabel lblText[] = new JLabel[strName.length];
	JTextField txtArticle[] = new JTextField[strName.length];
	JLabel lblFormat = new JLabel();
	String strFormat[] = { "명사", "동사", "형용사" };
	JComboBox cmdFormat = new JComboBox(strFormat);
	JButton btnEdit = new JButton();

	EditClass edit;
	DataClass data;
	EditorFrame(DataClass data) {
		
		this.data = data;
		EditClass edit = new EditClass(data);
		this.edit = edit;
		
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		contentPane.add(pnlBg);
		pnlBg.setBackground(new Color(39, 39, 39));
		pnlBg.setBounds(0, 0, 353, 399);
		pnlBg.setLayout(null);

		for (int i = 0; i < strName.length; i++) {
			lblText[i] = new JLabel(strName[i]);
			pnlBg.add(lblText[i]);
			lblText[i].setForeground(Color.LIGHT_GRAY);
			lblText[i].setBounds(73, 18 + i * 72, 266, 18);

			lblImage[i] = new JLabel();
			pnlBg.add(lblImage[i]);
			lblImage[i].setBounds(14, 12 + i * 72, 45, 60);

			txtArticle[i] = new JTextField();
			pnlBg.add(txtArticle[i]);
			txtArticle[i].setForeground(Color.LIGHT_GRAY);
			txtArticle[i].setCaretColor(Color.LIGHT_GRAY);
			txtArticle[i].setOpaque(false);
			txtArticle[i].setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
			txtArticle[i].setBounds(73, 48 + i * 72, 266, 24);
		}
		lblImage[0].setIcon(imgKanji);
		lblImage[1].setIcon(imgHiragana);
		lblImage[2].setIcon(imgMean);

		pnlBg.add(lblFormat);
		lblFormat.setText("Format");
		lblFormat.setForeground(Color.LIGHT_GRAY);
		lblFormat.setBounds(138, 232, 45, 18);

		pnlBg.add(cmdFormat);
		cmdFormat.setFont(new Font("", Font.PLAIN, 12));
		cmdFormat.setBounds(204, 229, 135, 24);

		pnlBg.add(btnEdit);
		btnEdit.setForeground(Color.LIGHT_GRAY);
		btnEdit.setIcon(imgEdit);
		btnEdit.setFocusPainted(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setCursor(cursor);
		btnEdit.addActionListener(this);
		btnEdit.setBounds(269, 347, 70, 40);

		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Editor");
		setBounds(100, 100, 358, 433);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		edit.insertData(txtArticle[0].getText(),txtArticle[1].getText(),txtArticle[2].getText(),cmdFormat.getSelectedItem().toString());
	}
}
