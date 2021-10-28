package abstract_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class WindowMain extends Frame {
	private Button initBtn, upBtn, downBtn, leftBtn, rightBtn;

	public WindowMain() {
		setTitle("이미지");
		setSize(400, 400);
		setVisible(true);
		// setVisible(false);로 다음창으로 넘어가며 더이상 안쓰는 창을 닫기도 함

		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 5, 5, 5));
		Button initBtn = new Button("초기화");
		p.add(initBtn);
		Button leftBtn = new Button("왼쪽");
		p.add(leftBtn);
		Button upBtn = new Button("위");
		p.add(upBtn);
		Button downBtn = new Button("아래");
		p.add(downBtn);
		Button rightBtn = new Button("오른쪽");
		p.add(rightBtn);
		p.setBounds(0, 0, 400, 70);
		add("North", p);

	}

	@Override
	public void paint(Graphics g) {

		g.drawString("갓연경 이미지", 50, 80);

		Toolkit t = Toolkit.getDefaultToolkit(); // 클래스 생성
		Image img = t.getImage("갓연경.jpg"); // 이미지 불러오기
		// g.drawImage(img, 30, 120, this); // 이미지 그리기
		// 나한테 그려. 내가 바로 윈도우창이야

		// 이미지 크기 조절
		g.drawImage(img, 30, 120, 380, 380, 0, 0, 773, 649, this);
		// (이미지 객체, 화면 크기 좌표, 이미지 크기 좌표, 어디에?);

	}

	public static void main(String[] args) {
		new WindowMain();

	}

}
