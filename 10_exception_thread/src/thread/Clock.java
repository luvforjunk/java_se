package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame implements Runnable {
	private JLabel timeL;

	public Clock() {
		timeL = new JLabel("", JLabel.CENTER);
		timeL.setFont(new Font("Arial", Font.BOLD, 36));
		timeL.setForeground(Color.RED);

		add("Center", timeL);

		setBounds(900, 200, 400, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void WindowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});

		Thread t = new Thread(this);// ������ ����
		t.start();// ������ ���� - ������ ����(run()) ... �����Ϸ� run�޼ҵ� ã�ư���!

	}

	@Override
	public void run() {
		while (true) {
			repaint();// paint() ȣ��
			try {
				Thread.sleep(1000); // ���� 1/1000��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // while
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // ������ �ִ� �� ����� ���Ӱ� ä��� ��

		// Calendar�� �߻�Ŭ������ ��ü ������ �ƿ� ���Ѵ�. new�� ���Ѵٴ� ��.
		// ��� �ڽ�Ŭ����(GregorianCalendar)�� �̿��Ѵ�
		// Calendar cal = new GregorianCalendar();���� ���ų�~
		Calendar cal = Calendar.getInstance();

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		String time = String.format("%02d : %02d : %02d", hour, minute, second);
		// %2d���� 01, 05,, �̷������� ������ �ϰ� ������ %02d�� ���� �ȴ�
		timeL.setText(time);
	}

	public static void main(String[] args) {
		Clock c = new Clock();
	}
}

// �ý����� ��¥�� �ð�
// 1. SimpleDateFormat
// 2. Calendar
