package inheritance;

import java.awt.Button;
import java.awt.Frame;

public class AwtMain3 extends Frame {
	private Button newBtn, exitBtn; // �ʵ�

	public void init() {
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");

		setLayout(null);// ��ư�� ũ��
		newBtn.setBounds(100, 100, 120, 50);
		exitBtn.setBounds(100, 160, 120, 50);

		add(newBtn);// ��ư�� �־��
		add(exitBtn);

		setTitle("â");// â�� ũ��
		setBounds(900, 200, 300, 400);
		setVisible(true);// â�� ������

	}

	public static void main(String[] args) {
		new AwtMain3().init();

	}

}
