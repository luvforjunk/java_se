package interface_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ImageMove extends Frame implements ActionListener, KeyListener, WindowListener {
	private Button initBtn, leftBtn, upBtn, downBtn, rightBtn;
	private int x = 100, y = 100; // 기본값

	public ImageMove() {
		initBtn = new Button("초기화");
		leftBtn = new Button(" ← ");
		upBtn = new Button(" ↑ ");
		downBtn = new Button(" ↓ ");
		rightBtn = new Button(" → ");

		Panel p = new Panel();
		p.add(initBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);

		this.add("North", p); // this = Frame. 북쪽방향에 panel을 돌려라~

		this.setBounds(900, 100, 500, 500);
		this.setVisible(true);

		// 이벤트
		this.addWindowListener(this); // JVM 호출하여 WindowClosing으로 연결 - X키

		// Btn을 누르면 ActionListener한테 가서 원하는 걸 처리해!
		// actionPerformed로~
		initBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);

		// 이벤트를 생성안하면 안움직이니까 KeyListener도~~
		initBtn.addKeyListener(this);
		leftBtn.addKeyListener(this);
		upBtn.addKeyListener(this);
		downBtn.addKeyListener(this);
		rightBtn.addKeyListener(this);

	}// ImageMove()

	@Override
	// paint가 불려지는 건 setVisible이 호출됐을 때
	public void paint(Graphics g) { // 메소드
		// Toolkit은 추상클래스라 뉴가 안되며 자식 클래스를 잡아야 하는데
		// 자식도 없음 고로 메소드를 이용해서 생성해야 한다
		Toolkit t = Toolkit.getDefaultToolkit(); // 메소드 이용하여 생성
		Image img = t.getImage("image/게.gif"); // 이미지 불러오기
		g.drawImage(img, x, y, this); // 이미지 그리기. 위치(x, y)가 고정이 아님.
	}

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) { // 메소드
		System.out.println("x=" + x + ", y=" + y);

		if (e.getSource() == initBtn) {
		} else if (e.getSource() == leftBtn) {
			x -= 10;
			if (x < -50)
				x = 470;
		} else if (e.getSource() == upBtn) {
			y -= 10;
			if (y < 30)
				y = 470;
		} else if (e.getSource() == downBtn) {
			y += 10;
			if (y > 470)
				y = 30;
		} else if (e.getSource() == rightBtn) {
			x += 10;
			if (x > 470)
				x = -50;
		}
		repaint(); // JVM에 의해 paint() 호출 - 값이 바뀌었다가 다시 원상복구 해야하니
	}

	// WindowListener Override
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료");
		System.exit(0);// 프로그램 강제 종료
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	// KeyListener Override
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { // 눌린 키가 KeyEvent의 ESC키냐
			System.exit(0);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
			if (x < -250)
				x = 550;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
			if (y < -280)
				y = 550;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
			if (y > 550)
				y = -280;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
			if (x > 550)
				x = -250;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

//------------------------
public class WindowMain2 {

	public static void main(String[] args) {
		new ImageMove();

	}

}
