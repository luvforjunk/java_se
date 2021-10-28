package thread;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunRace extends JFrame implements ActionListener {
	public static int rank = 1;
	private int count;
	private JButton btn;
	private Racer[] racer; // Canvas

	public RunRace(int count) {

		this.count = count;
		btn = new JButton("시작");
		JPanel southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		southP.add(btn);
		Scanner scan = new Scanner(System.in);

		JPanel centerP = new JPanel(new GridLayout(count, 1)); // FlowLayout
		racer = new Racer[count]; // 말 개수만큼 필요하다
		String horseName = null;

		for (int i = 0; i < count; i++) {
			System.out.print("말 이름 입력 : ");
			horseName = scan.next();
			racer[i] = new Racer(horseName);
			centerP.add(racer[i]);
		}
		this.add("Center", centerP);
		this.add("South", southP);

		setBounds(900, 200, 600, 400);
		setResizable(false); // 창 고정
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료

		// 이벤트
		btn.addActionListener(this);
	}
	public RunRace() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false);
		// 시작버튼을 눌렀을 때 Thread !
		Thread[] t = new Thread[count]; // 배열 생성
		for (int i = 0; i < count; i++) {
			t[i] = new Thread(racer[i]); // 스레드 생성

			// ***Thread가 되고 싶은 건 Racer/
			// Racer를 new해서 생성해주는 곳은 Racer.java가 아닌 RunRace.java이다
			// 따라서 생성자가 있는 곳에서 Thread만들어 주는 것이 맞다
			
			// Thread에 우선 순위 부여 1~10
			int num = (int) (Math.random() * 10) + 1;
			t[i].setPriority(num);
			t[i].start();// 스레드 시작
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("말 마리 수 입력 : ");
		int count = scan.nextInt();
		new RunRace(count);
	}
}