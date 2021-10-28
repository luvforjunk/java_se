package thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

// �� 1����

public class Racer extends Canvas implements Runnable { // Canvas�� ���ε��� ��� ���� ��
	private Image img;
	private String horseName;
	int pos;

	public Racer(String horseName) {
		img = Toolkit.getDefaultToolkit().getImage("image/��.gif");
		this.horseName = horseName;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, pos, 0, 25, this.getSize().height, this);
		// this.getSize().height���� this�� Canvas
		g.drawLine(0, this.getSize().height - 1, this.getSize().width, this.getSize().height - 1); // ���� �׸���
	}

	@Override
	public void run() {
		for (int i = 0; i < 600; i += ((int) (Math.random() * 10) + 1)) {
			// 0���� 600 �������� �������� 1~10��ŭ ������ ��ġ�� ��ġ���ϰԲ�
			pos = i; // �������� ��� �ٸ��� ���� �ϱ� ���� g.drawImage�� x���� ������
			repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for

		// ���
		RunRace r = new RunRace();
		System.out.println(r.rank + "�� " + horseName);
		r.rank++;
	}

}