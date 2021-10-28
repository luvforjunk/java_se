package inheritance;

import java.awt.Button;
import java.awt.Frame;

public class AwtMain3 extends Frame {
	private Button newBtn, exitBtn; // 필드

	public void init() {
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");

		setLayout(null);// 버튼의 크기
		newBtn.setBounds(100, 100, 120, 50);
		exitBtn.setBounds(100, 160, 120, 50);

		add(newBtn);// 버튼을 넣어라
		add(exitBtn);

		setTitle("창");// 창의 크기
		setBounds(900, 200, 300, 400);
		setVisible(true);// 창을 보여줘

	}

	public static void main(String[] args) {
		new AwtMain3().init();

	}

}
