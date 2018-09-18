package Project_11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WidgetFrame extends JFrame implements MouseListener, MouseMotionListener, ChangeListener, ActionListener {

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();

	JPanel contentPane = new JPanel();

	JPanel pnlMain = new JPanel();
	JLabel lblWidget = new JLabel();
	JLabel lblNumber = new JLabel();
	JLabel lblKanji = new JLabel();
	JLabel lblHiragana = new JLabel();
	JLabel lblMean = new JLabel();
	JCheckBox chkKanji = new JCheckBox();
	JCheckBox chkHiragana = new JCheckBox();
	JCheckBox chkMean = new JCheckBox();
	String strFormat[] = { "명사", "동사", "형용사" };
	JComboBox cmbFormat = new JComboBox(strFormat);
	JButton btnPre = new JButton();
	ImageIcon imgPre = new ImageIcon("img/pre.png");
	JButton btnNext = new JButton();
	ImageIcon imgNext = new ImageIcon("img/next.png");

	JPanel pnlMenu = new JPanel();
	JSlider sldOpacity = new JSlider();
	JButton btnTrans = new JButton();
	ImageIcon imgMini = new ImageIcon("img/mini.png");
	JButton btnMini = new JButton();
	ImageIcon imgTrans = new ImageIcon("img/trans.png");

	MainFrame f;
	DataClass data;
	WidgetClass widget;

	WidgetFrame(MainFrame f, DataClass data) {
		this.f = f;
		this.data = data;
		WidgetClass widget = new WidgetClass(this.data, lblNumber, lblKanji, lblHiragana, lblMean, cmbFormat);
		this.widget = widget;

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/title.png"));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// create pnlMenu
		contentPane.add(pnlMenu);
		pnlMenu.setBackground(new Color(39, 39, 39));
		pnlMenu.setLayout(null);
		pnlMenu.setBounds(0, 0, 346, 35);
		pnlMenu.addMouseListener(this);
		pnlMenu.addMouseMotionListener(this);

		pnlMenu.add(sldOpacity);
		sldOpacity.setMinimum(10);
		sldOpacity.setMaximum(100);
		sldOpacity.setValue(100);
		sldOpacity.addChangeListener(this);
		sldOpacity.setOpaque(false);
		sldOpacity.setBounds(0, 0, 92, 26);

		pnlMenu.add(btnTrans);
		btnTrans.setIcon(imgTrans);
		btnTrans.setHorizontalAlignment(SwingConstants.CENTER);
		btnTrans.setCursor(f.cursor);
		btnTrans.setFocusPainted(false);
		btnTrans.setBorderPainted(false);
		btnTrans.setContentAreaFilled(false);
		btnTrans.addActionListener(this);
		btnTrans.setBounds(311, 2, 32, 32);

		pnlMenu.add(btnMini);
		btnMini.setIcon(imgMini);
		btnMini.setHorizontalAlignment(SwingConstants.CENTER);
		btnMini.setCursor(f.cursor);
		btnMini.setFocusPainted(false);
		btnMini.setBorderPainted(false);
		btnMini.setContentAreaFilled(false);
		btnMini.addActionListener(this);
		btnMini.setBounds(272, 2, 32, 32);

		// create pnlMain
		pnlMain.setBackground(new Color(39, 39, 39));
		pnlMain.setBounds(0, 0, 346, 500);
		contentPane.add(pnlMain);
		pnlMain.setLayout(null);

		pnlMain.add(lblWidget);
		lblWidget.setText("Widget");
		lblWidget.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 32));
		lblWidget.setForeground(Color.WHITE);
		lblWidget.setBounds(14, 44, 105, 67);

		pnlMain.add(lblNumber);
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("", Font.PLAIN, 24));
		lblNumber.setForeground(Color.WHITE);
		lblNumber.setBounds(14, 123, 318, 43);

		pnlMain.add(lblKanji);
		lblKanji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKanji.setForeground(Color.WHITE);
		lblKanji.setFont(new Font("", Font.PLAIN, 24));
		lblKanji.setBounds(14, 178, 318, 43);

		pnlMain.add(lblHiragana);
		lblHiragana.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiragana.setForeground(Color.WHITE);
		lblHiragana.setFont(new Font("", Font.PLAIN, 24));
		lblHiragana.setBounds(14, 233, 318, 43);

		pnlMain.add(lblMean);
		lblMean.setHorizontalAlignment(SwingConstants.CENTER);
		lblMean.setForeground(Color.WHITE);
		lblMean.setFont(new Font("", Font.PLAIN, 24));
		lblMean.setBounds(14, 288, 318, 43);

		pnlMain.add(chkKanji);
		chkKanji.setText("Kanji");
		chkKanji.setForeground(Color.LIGHT_GRAY);
		chkKanji.setSelected(true);
		chkKanji.setOpaque(false);
		chkKanji.addActionListener(this);
		chkKanji.setBounds(14, 339, 131, 27);

		pnlMain.add(chkHiragana);
		chkHiragana.setText("Hiragana");
		chkHiragana.setForeground(Color.LIGHT_GRAY);
		chkHiragana.setSelected(true);
		chkHiragana.setOpaque(false);
		chkHiragana.addActionListener(this);
		chkHiragana.setBounds(14, 370, 131, 27);

		pnlMain.add(chkMean);
		chkMean.setText("Mean");
		chkMean.setForeground(Color.LIGHT_GRAY);
		chkMean.setSelected(true);
		chkMean.setOpaque(false);
		chkMean.addActionListener(this);
		chkMean.setBounds(14, 401, 131, 27);

		pnlMain.add(btnPre);
		btnPre.setIcon(imgPre);
		btnPre.setCursor(f.cursor);
		btnPre.setFocusPainted(false);
		btnPre.setBorderPainted(false);
		btnPre.setContentAreaFilled(false);
		btnPre.addActionListener(this);
		btnPre.setBounds(14, 461, 105, 27);

		pnlMain.add(btnNext);
		btnNext.setIcon(imgNext);
		btnNext.setCursor(f.cursor);
		btnNext.setFocusPainted(false);
		btnNext.setBorderPainted(false);
		btnNext.setContentAreaFilled(false);
		btnNext.addActionListener(this);
		btnNext.setBounds(227, 461, 105, 27);

		pnlMain.add(cmbFormat);
		cmbFormat.setFont(new Font("", Font.PLAIN, 12));
		cmbFormat.addActionListener(this);
		cmbFormat.setBounds(201, 402, 131, 24);

		widget.openData();

		setBounds(100, 100, 346, 500);
		setLocation(screenSize.width - 346, 0);
		setUndecorated(true);
		setVisible(true);
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
		xx = e.getX();
		xy = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		setOpacity((float) source.getValue() / 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnTrans) {
			setVisible(false);
			f.setVisible(true);
		} else if (obj == btnMini) {
			setState(JFrame.ICONIFIED);
		} else if (obj == btnPre) {
			widget.pre();
		} else if (obj == btnNext) {
			widget.next();
		} else if (obj == cmbFormat) {
			widget.count = 1;
			widget.openData();
		} else if (obj == chkKanji) {
			if (chkKanji.isSelected() == false) {
				lblKanji.setVisible(false);
			} else {
				lblKanji.setVisible(true);
			}
		} else if (obj == chkHiragana) {
			if (chkHiragana.isSelected() == false) {
				lblHiragana.setVisible(false);
			} else {
				lblHiragana.setVisible(true);
			}
		} else if (obj == chkMean) {
			if (chkMean.isSelected() == false) {
				lblMean.setVisible(false);
			} else {
				lblMean.setVisible(true);
			}
		}
	}
}
