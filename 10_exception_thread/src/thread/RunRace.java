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
		btn = new JButton("����");
		JPanel southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		southP.add(btn);
		Scanner scan = new Scanner(System.in);

		JPanel centerP = new JPanel(new GridLayout(count, 1)); // FlowLayout
		racer = new Racer[count]; // �� ������ŭ �ʿ��ϴ�
		String horseName = null;

		for (int i = 0; i < count; i++) {
			System.out.print("�� �̸� �Է� : ");
			horseName = scan.next();
			racer[i] = new Racer(horseName);
			centerP.add(racer[i]);
		}
		this.add("Center", centerP);
		this.add("South", southP);

		setBounds(900, 200, 600, 400);
		setResizable(false); // â ����
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE); // ����

		// �̺�Ʈ
		btn.addActionListener(this);
	}
	public RunRace() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false);
		// ���۹�ư�� ������ �� Thread !
		Thread[] t = new Thread[count]; // �迭 ����
		for (int i = 0; i < count; i++) {
			t[i] = new Thread(racer[i]); // ������ ����

			// ***Thread�� �ǰ� ���� �� Racer/
			// Racer�� new�ؼ� �������ִ� ���� Racer.java�� �ƴ� RunRace.java�̴�
			// ���� �����ڰ� �ִ� ������ Thread����� �ִ� ���� �´�
			
			// Thread�� �켱 ���� �ο� 1~10
			int num = (int) (Math.random() * 10) + 1;
			t[i].setPriority(num);
			t[i].start();// ������ ����
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�� ���� �� �Է� : ");
		int count = scan.nextInt();
		new RunRace(count);
	}
}