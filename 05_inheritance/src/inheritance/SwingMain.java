package inheritance;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; //java Ȯ����Ű�� - javax

public class SwingMain extends JFrame {
	private JButton northBtn = null, southBtn, eastBtn, westBtn, centerBtn;
	private int a = 0;

	public void init() {
		// ��ư ����
		northBtn = new JButton("����");
		southBtn = new JButton("����");
		eastBtn = new JButton("����");
		westBtn = new JButton("����");
		centerBtn = new JButton(new ImageIcon("�����ϱ�.jpg"));

		// ��ġ
		add("North", northBtn);
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);

		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SwingMain().init();
	}
}
