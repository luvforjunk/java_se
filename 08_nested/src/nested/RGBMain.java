package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RGBMain extends Frame {
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas can;

	public RGBMain() { // 생성
		redBtn = new Button("빨강");
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		can = new DrCanvas();
		// 반드시 상속 받아서 써야 한다
		// 하지만 자바는 다중 상속이 안된다.

		Panel p = new Panel();
		p.add(redBtn); // 패널에 redBtn 넣어주기
		p.add(greenBtn);
		p.add(blueBtn);

		this.add("North", p); // 패널을 북쪽에
		this.add("Center", can);

		setBounds(900, 150, 300, 400);
		setVisible(true);

		// 이벤트
		// 기존에 WindowListener 7개의 메소드를 다 처리하던 걸 WindowAdapter하나로 다 클리어
		// WindowAdapter는 추상클래스라서 절대 뉴 할 수 없다
		// 따라서 흑기사 {}가 따라 붙은 거
		// WindowAdapter는 추상메소드가 1도 없다 ---> 반드시 override해야 할 메소드가 없다는 뜻
		this.addWindowListener(new WindowAdapter() { // 익명
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// MouseListener Override
		this.addMouseListener(new MouseAdapter() { // 익명
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("마우스 클릭");
			}
		});
		// ActionListener Override
		redBtn.addActionListener(new ActionListener() { // 일회성. 한번 쓰고 버림
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.RED);
			}
		});
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.GREEN);
			}
		});
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.BLUE);
			}
		});
	} // RGBMain() 생성자 끝

	class DrCanvas extends Canvas { 
		public DrCanvas() {
			this.setBackground(new Color(167, 250, 230)); // DrCanvas의 배경색
		}
	}

	public static void main(String[] args) {
		new RGBMain();
	}
}
