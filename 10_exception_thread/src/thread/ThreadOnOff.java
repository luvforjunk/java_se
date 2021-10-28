package thread;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadOnOff extends JFrame implements Runnable {
	private JLabel label;
	private JButton btn;
	private int count;
	private boolean onoff;

	public ThreadOnOff() {
		label = new JLabel("0", JLabel.CENTER);
		label.setFont(new Font("고딕체", Font.BOLD, 70));
		label.setForeground(Color.RED);
		btn = new JButton("누르기");

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);

		add("Center", label);
		add("South", p);

		setBounds(700, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트
		btn.addMouseListener(new MouseAdapter() {
			Thread t;

			@Override
			public void mousePressed(MouseEvent e) {
				Thread t = new Thread(ThreadOnOff.this); // 스레드 생성
				t.start(); // 스레드 시작
				System.out.println("누르기 t = " + t);
				
				onoff = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				t = null;
				System.out.println("손떼기 t = " + t);
				
				onoff = false; // while문을 못 돌게 하기 위해
			}
		});
	} // ThreadOnOff()

	@Override
	public void run() {
		while (true) {
			count++;
			label.setText(count + " ");
			
			//if(onoff = false) - 이런식으로는 안씀
			if(!onoff) break; // while문을 벗어나라

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count >= 50) count = 0; // 50이상은 나오지 않게
		} // while
	}

	public static void main(String[] args) {
		new ThreadOnOff();
	}
}

// 꾹 누르고 있으면 계속 번호가 올라가게끔
// - MouseListener 사용

//스레드 생성
// 1번 - implements 생성
// 2번 - run Override 잡기