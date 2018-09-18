package Project_5;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class InputFrame extends JFrame {

	private JPanel contentPane;
	ImageIcon imgKanji = new ImageIcon("img/kanji.png");
	ImageIcon imgHiragana = new ImageIcon("img/hiragana.png");
	ImageIcon imgMean = new ImageIcon("img/mean.png");
	ImageIcon imgEdit = new ImageIcon("img/edit.png");
	
	
	private JTextField txtKanji;
	private JTextField txtHiragana;
	private JTextField txtMean;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFrame frame = new InputFrame();
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
	public InputFrame() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 39, 39));
		panel.setBounds(0, 0, 353, 399);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImgKanji = new JLabel("");
		lblImgKanji.setIcon(imgKanji);
		lblImgKanji.setBounds(14, 12, 45, 60);
		panel.add(lblImgKanji);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(imgHiragana);
		label_1.setBounds(14, 84, 45, 60);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(imgMean);
		label_2.setBounds(14, 156, 45, 60);
		panel.add(label_2);
		
		txtKanji = new JTextField();
		txtKanji.setForeground(Color.LIGHT_GRAY);
		txtKanji.setOpaque(false);
		txtKanji.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		txtKanji.setCaretColor(Color.LIGHT_GRAY);
		txtKanji.setBounds(73, 48, 266, 24);
		panel.add(txtKanji);
		txtKanji.setColumns(10);
		
		txtHiragana = new JTextField();
		txtHiragana.setForeground(Color.LIGHT_GRAY);
		txtHiragana.setColumns(10);
		txtHiragana.setOpaque(false);
		txtHiragana.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		txtHiragana.setCaretColor(Color.LIGHT_GRAY);
		txtHiragana.setBounds(73, 120, 266, 24);
		panel.add(txtHiragana);
		
		txtMean = new JTextField();
		txtMean.setForeground(Color.LIGHT_GRAY);
		txtMean.setColumns(10);
		txtMean.setOpaque(false);
		txtMean.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		txtMean.setCaretColor(Color.LIGHT_GRAY);
		txtMean.setBounds(73, 193, 266, 24);
		panel.add(txtMean);
		
		JComboBox cmbFormat = new JComboBox();
		cmbFormat.setBounds(204, 229, 135, 24);
		panel.add(cmbFormat);
		
		JButton btnEdit = new JButton("");
		btnEdit.setForeground(Color.LIGHT_GRAY);
		btnEdit.setIcon(imgEdit);
		btnEdit.setFocusPainted(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBounds(269, 347, 70, 40);
		panel.add(btnEdit);
		
		JLabel lblKanji = new JLabel("Chinese character");
		lblKanji.setForeground(Color.LIGHT_GRAY);
		lblKanji.setBounds(73, 18, 266, 18);
		panel.add(lblKanji);
		
		JLabel lblHiragana = new JLabel("Hiragana");
		lblHiragana.setForeground(Color.LIGHT_GRAY);
		lblHiragana.setBounds(73, 90, 266, 18);
		panel.add(lblHiragana);
		
		JLabel lblMean = new JLabel("Mean");
		lblMean.setForeground(Color.LIGHT_GRAY);
		lblMean.setBounds(73, 163, 266, 18);
		panel.add(lblMean);
		
		JLabel lblFormat = new JLabel("Format");
		lblFormat.setForeground(Color.LIGHT_GRAY);
		lblFormat.setBounds(138, 232, 45, 18);
		panel.add(lblFormat);
	}
}
