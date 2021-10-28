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
		label.setFont(new Font("���ü", Font.BOLD, 70));
		label.setForeground(Color.RED);
		btn = new JButton("������");

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);

		add("Center", label);
		add("South", p);

		setBounds(700, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// �̺�Ʈ
		btn.addMouseListener(new MouseAdapter() {
			Thread t;

			@Override
			public void mousePressed(MouseEvent e) {
				Thread t = new Thread(ThreadOnOff.this); // ������ ����
				t.start(); // ������ ����
				System.out.println("������ t = " + t);
				
				onoff = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				t = null;
				System.out.println("�ն��� t = " + t);
				
				onoff = false; // while���� �� ���� �ϱ� ����
			}
		});
	} // ThreadOnOff()

	@Override
	public void run() {
		while (true) {
			count++;
			label.setText(count + " ");
			
			//if(onoff = false) - �̷������δ� �Ⱦ�
			if(!onoff) break; // while���� �����

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count >= 50) count = 0; // 50�̻��� ������ �ʰ�
		} // while
	}

	public static void main(String[] args) {
		new ThreadOnOff();
	}
}

// �� ������ ������ ��� ��ȣ�� �ö󰡰Բ�
// - MouseListener ���

//������ ����
// 1�� - implements ����
// 2�� - run Override ���