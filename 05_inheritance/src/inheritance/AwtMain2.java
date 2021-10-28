package inheritance;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

//자바에서의 Layout은 BorderLayout과 FlowLayout이 있다
//Frame은 BorderLayout(동서남북) - 동서남북에는 1개의 버튼만 넣을 수 있다
public class AwtMain2 extends Frame {
	private Button newBtn, exitBtn; // 필드

	public void init() {
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");

		Panel p = new Panel(); // 쟁반에 비유
		// 한번 쓰고 버릴 거기 때문에 지역으로 설명한다
		// FlowLayout - 가운데를 중심으로 순서대로 배치
		p.setLayout(new GridLayout(1, 2, 2, 0));// 균등하게 배열하기
		//여기서 2, 0은 가로여백 세로여백. 
		p.setBackground(new Color(243, 150, 147));
		p.add(newBtn);
		p.add(exitBtn);

		add("North", p);

		// super("창"); //부모생성자를 호출하려면 나 자신도 생성자여야 한다. 여기서 나는 init이므로 super를 사용해 부모생성자를
		// 호출해 올 수 없다
		setTitle("창");
		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AwtMain2().init();

	}

}

//맨 밑 부분부터 Frame -> Panel -> button
