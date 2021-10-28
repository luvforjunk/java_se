package thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

// 말 1마리

public class Racer extends Canvas implements Runnable { // Canvas를 따로따로 잡고 들어가는 거
	private Image img;
	private String horseName;
	int pos;

	public Racer(String horseName) {
		img = Toolkit.getDefaultToolkit().getImage("image/말.gif");
		this.horseName = horseName;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, pos, 0, 25, this.getSize().height, this);
		// this.getSize().height에서 this는 Canvas
		g.drawLine(0, this.getSize().height - 1, this.getSize().width, this.getSize().height - 1); // 라인 그리기
	}

	@Override
	public void run() {
		for (int i = 0; i < 600; i += ((int) (Math.random() * 10) + 1)) {
			// 0부터 600 이전까지 랜덤으로 1~10만큼 움직여 엎치락 뒤치락하게끔
			pos = i; // 움직임이 계속 다르게 들어가게 하기 위해 g.drawImage에 x값을 고쳐줌
			repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for

		// 등수
		RunRace r = new RunRace();
		System.out.println(r.rank + "등 " + horseName);
		r.rank++;
	}

}