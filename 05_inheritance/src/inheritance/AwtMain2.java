package inheritance;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

//�ڹٿ����� Layout�� BorderLayout�� FlowLayout�� �ִ�
//Frame�� BorderLayout(��������) - �������Ͽ��� 1���� ��ư�� ���� �� �ִ�
public class AwtMain2 extends Frame {
	private Button newBtn, exitBtn; // �ʵ�

	public void init() {
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");

		Panel p = new Panel(); // ��ݿ� ����
		// �ѹ� ���� ���� �ű� ������ �������� �����Ѵ�
		// FlowLayout - ����� �߽����� ������� ��ġ
		p.setLayout(new GridLayout(1, 2, 2, 0));// �յ��ϰ� �迭�ϱ�
		//���⼭ 2, 0�� ���ο��� ���ο���. 
		p.setBackground(new Color(243, 150, 147));
		p.add(newBtn);
		p.add(exitBtn);

		add("North", p);

		// super("â"); //�θ�����ڸ� ȣ���Ϸ��� �� �ڽŵ� �����ڿ��� �Ѵ�. ���⼭ ���� init�̹Ƿ� super�� ����� �θ�����ڸ�
		// ȣ���� �� �� ����
		setTitle("â");
		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AwtMain2().init();

	}

}

//�� �� �κк��� Frame -> Panel -> button
