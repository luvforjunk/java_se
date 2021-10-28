package inheritance;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; //java 확장패키지 - javax

public class SwingMain extends JFrame {
	private JButton northBtn = null, southBtn, eastBtn, westBtn, centerBtn;
	private int a = 0;

	public void init() {
		// 버튼 생성
		northBtn = new JButton("북쪽");
		southBtn = new JButton("남쪽");
		eastBtn = new JButton("동쪽");
		westBtn = new JButton("서쪽");
		centerBtn = new JButton(new ImageIcon("대학일기.jpg"));

		// 배치
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
