package thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Packman extends JFrame implements KeyListener, Runnable {
	private Image img, foodImg;
	int select = 0; // 오른쪽 방향으로 뜨게 하려면 int select = 2;
	int x = 225, y = 255, mx, my;
	private int[] foodX, foodY;

	public Packman() {
		img = Toolkit.getDefaultToolkit().getImage("image/Packman.png");
		foodImg = Toolkit.getDefaultToolkit().getImage("image/food.gif");

		foodX = new int[5];
		foodY = new int[5];

		for (int i = 0; i < foodX.length; i++) {
			foodX[i] = (int) (Math.random() * 461) + 20; // 20 ~ 480
			foodY[i] = (int) (Math.random() * 461) + 20; // 20 ~ 480
		} // for

		setBounds(900, 200, 500, 500);
		setResizable(false); // 창 고정
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// 이벤트
		this.addKeyListener(this);
		Thread t = new Thread(this);
		t.start();// 스레드 시작 - 스레드 실행(run())
	}

	public void paint(Graphics g) {

		super.paint(g); // 뒷배경 불투명효과
		// Toolkit t = Toolkit.getDefaultToolkit(); - 메소드 이용 생성자 생성
		// img = t.getImage("image/Packman.png");

		System.out.println(x + ", " + y);
		g.drawImage(img, x, y, x + 50, y + 50, // 화면 위치
				select * 50, 0, select * 50 + 50, 50, this); // 이미지 위치

		// 먹이
		for (int i = 0; i < foodX.length; i++) {
			g.drawImage(foodImg, foodX[i], foodY[i], this);
		}
	}

	@Override
	public void run() {
		while (true) {
			repaint(); // 계속 그림을 그려줘야 한다

			if (select % 2 == 0)
				select++;
			else
				select--;

			// 좌표 이동
			x = x + mx;
			y = y + my;

			if (x > 500)
				x = 0;
			else if (x < 0)
				x = 500;
			else if (y > 500)
				y = 0;
			else if (y < 0)
				y = 500;

			try {
				Thread.sleep(100); // 단위 : 1/1000초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 먹이 먹는 방법
			for (int i = 0; i < foodX.length; i++) {
				if (x + 25 >= foodX[i] - 10 && y + 25 >= foodY[i] - 10 && x + 25 <= foodX[i] + 30
						&& y + 25 <= foodY[i] + 30)
					foodX[i] = foodY[i] = -10;
				// System.out.println(foodX[i] + ", " + foodY[i]);
			} // for
				// System.out.println("-------------");
		} // while
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// 대문자로 써있는 필드값은 상수화인 값으로 keyEvent에 바로 접근한다
			select = 0;
			mx = -10;
			my = 0;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			select = 2;
			mx = 10;
			my = 0;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			select = 4;
			mx = 0;
			my = -10;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			select = 6;
			mx = 0;
			my = 10;
		}
		// repaint(); - 키보드 누를 때마다 그림을 그리는 게 아니라
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new Packman();
	}
}