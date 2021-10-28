package inheritance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { // WindowTest is a Frame
	// 이제부터 WindowTest(자식) Window창(Frame창)이 된다
	public WindowTest() { // Frame클래스의 생성자를 호출
		// new Frame("내가 만든 그림판").setVisible(true); - 창이 두개 띄워짐

		super("내가 만든 그림판"); // 부모생성자 호출
		// WindowTest도 생성자고, Frame도 생성자이기 때문에 강제로 부모생성자를 호출할 수 있다

		setFont(new Font("궁서체", Font.BOLD, 32)); // 0(기본), 1(굵게), 2(기울여서)라고 써도 되지만 상수화시키면 쉽게 알아볼 수 있다

		System.out.println("도형");
		setForeground(Color.PINK);
		// 바탕색은 항상 흰색, 글자색은 검정으로 기본을 갖고 있다
		// 바꾸고 싶으면
		// setBackground(Color.PINK);
		// setBackground(Color클래스의 생성자에 R, G, B 숫자를 넣으면 된다)
		setBackground(new Color(243, 251, 147)); // 생성자 호출
		//누군가에게 주소값을 준 게 아니기 때문에 일회성이다. 한번 쓰고 버리는 애들.

		// setSize(300, 400);
		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	@Override //자바가 만들어 놓은 걸 Override하면 무조건 내꺼 처리
	public void paint(Graphics g) { // 구현, 어떠한 조건을 만족하면 JVM이 호출하는 메소드(콜백 메소드)
		// paint는 setVisible이 뜰 때 자동으로 처리가 된다.
		g.drawString("도형", 110, 250); // 글씨
		g.drawLine(70, 100, 150, 150); // 선 x, y - > x2, y2
		g.drawRect(70, 70, 150, 150); // 사각형 x, y, 너비, 높이
		// g.drawOval(100, 100, 80, 80); //원
		g.fillOval(100, 100, 80, 80); // 원 색깔 채우기
	}

	public static void main(String[] args) {
		WindowTest wt = new WindowTest(); // 창 띄우기
		// 똑같은 창을 띄우는데 생성자를 잡아서 뉴 해도 되고~~~(*다른 예제 AwtMain)
	}

}
