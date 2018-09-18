package Project_5;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class WidgetFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WidgetFrame frame = new WidgetFrame();
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
	public WidgetFrame() {
		setBounds(100, 100, 346, 500);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 39, 39));
		panel.setBounds(0, 0, 346, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWidget = new JLabel("Widget");
		lblWidget.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 32));
		lblWidget.setForeground(Color.WHITE);
		lblWidget.setBounds(14, 44, 105, 67);
		panel.add(lblWidget);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 24));
		lblNumber.setForeground(Color.WHITE);
		lblNumber.setBounds(14, 123, 318, 43);
		panel.add(lblNumber);
		
		JLabel lblKanji = new JLabel("Kanji");
		lblKanji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKanji.setForeground(Color.WHITE);
		lblKanji.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 24));
		lblKanji.setBounds(14, 178, 318, 43);
		panel.add(lblKanji);
		
		JLabel lblHiragana = new JLabel("Hiragana");
		lblHiragana.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiragana.setForeground(Color.WHITE);
		lblHiragana.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 24));
		lblHiragana.setBounds(14, 233, 318, 43);
		panel.add(lblHiragana);
		
		JLabel lblMean = new JLabel("Mean");
		lblMean.setHorizontalAlignment(SwingConstants.CENTER);
		lblMean.setForeground(Color.WHITE);
		lblMean.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 24));
		lblMean.setBounds(14, 288, 318, 43);
		panel.add(lblMean);
		
		JButton btnNewButton = new JButton("Pre");
		btnNewButton.setBounds(14, 461, 105, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setBounds(227, 461, 105, 27);
		panel.add(btnNewButton_1);
		
		JCheckBox chckbxKanji = new JCheckBox("Kanji");
		chckbxKanji.setForeground(Color.LIGHT_GRAY);
		chckbxKanji.setOpaque(false);
		chckbxKanji.setBounds(14, 339, 131, 27);
		panel.add(chckbxKanji);
		
		JCheckBox chckbxHiragana = new JCheckBox("Hiragana");
		chckbxHiragana.setForeground(Color.LIGHT_GRAY);
		chckbxHiragana.setOpaque(false);
		chckbxHiragana.setBounds(14, 370, 131, 27);
		panel.add(chckbxHiragana);
		
		JCheckBox chckbxMean = new JCheckBox("Mean");
		chckbxMean.setForeground(Color.LIGHT_GRAY);
		chckbxMean.setOpaque(false);
		chckbxMean.setBounds(14, 401, 131, 27);
		panel.add(chckbxMean);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(201, 402, 131, 24);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 346, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.WHITE);
		slider.setBounds(35, 6, 92, 26);
		panel_1.add(slider);
		
		JLabel lblTr = new JLabel("tr");
		lblTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblTr.setBounds(313, 0, 32, 32);
		panel_1.add(lblTr);
		
		JLabel lblSm = new JLabel("sm");
		lblSm.setHorizontalAlignment(SwingConstants.CENTER);
		lblSm.setBounds(274, 0, 32, 32);
		panel_1.add(lblSm);
		
		JLabel label = new JLabel("sm");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 32, 32);
		panel_1.add(label);
	}
}
