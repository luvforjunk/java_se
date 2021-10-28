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

		Thread t = new Thread(this);// 스레드 생성
		t.start();// 스레드 시작 - 스레드 실행(run()) ... 실행하러 run메소드 찾아가자!

	}

	@Override
	public void run() {
		while (true) {
			repaint();// paint() 호출
			try {
				Thread.sleep(1000); // 단위 1/1000초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // while
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // 기존에 있는 걸 지우고 새롭게 채우는 것

		// Calendar는 추상클래스로 자체 생성을 아예 못한다. new를 못한다는 거.
		// 고로 자식클래스(GregorianCalendar)를 이용한다
		// Calendar cal = new GregorianCalendar();으로 쓰거나~
		Calendar cal = Calendar.getInstance();

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		String time = String.format("%02d : %02d : %02d", hour, minute, second);
		// %2d에서 01, 05,, 이런식으로 나오게 하고 싶으면 %02d로 쓰면 된다
		timeL.setText(time);
	}

	public static void main(String[] args) {
		Clock c = new Clock();
	}
}

// 시스템의 날짜와 시간
// 1. SimpleDateFormat
// 2. Calendar
