package inheritance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { // WindowTest is a Frame
	// �������� WindowTest(�ڽ�) Windowâ(Frameâ)�� �ȴ�
	public WindowTest() { // FrameŬ������ �����ڸ� ȣ��
		// new Frame("���� ���� �׸���").setVisible(true); - â�� �ΰ� �����

		super("���� ���� �׸���"); // �θ������ ȣ��
		// WindowTest�� �����ڰ�, Frame�� �������̱� ������ ������ �θ�����ڸ� ȣ���� �� �ִ�

		setFont(new Font("�ü�ü", Font.BOLD, 32)); // 0(�⺻), 1(����), 2(��￩��)��� �ᵵ ������ ���ȭ��Ű�� ���� �˾ƺ� �� �ִ�

		System.out.println("����");
		setForeground(Color.PINK);
		// �������� �׻� ���, ���ڻ��� �������� �⺻�� ���� �ִ�
		// �ٲٰ� ������
		// setBackground(Color.PINK);
		// setBackground(ColorŬ������ �����ڿ� R, G, B ���ڸ� ������ �ȴ�)
		setBackground(new Color(243, 251, 147)); // ������ ȣ��
		//���������� �ּҰ��� �� �� �ƴϱ� ������ ��ȸ���̴�. �ѹ� ���� ������ �ֵ�.

		// setSize(300, 400);
		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	@Override //�ڹٰ� ����� ���� �� Override�ϸ� ������ ���� ó��
	public void paint(Graphics g) { // ����, ��� ������ �����ϸ� JVM�� ȣ���ϴ� �޼ҵ�(�ݹ� �޼ҵ�)
		// paint�� setVisible�� �� �� �ڵ����� ó���� �ȴ�.
		g.drawString("����", 110, 250); // �۾�
		g.drawLine(70, 100, 150, 150); // �� x, y - > x2, y2
		g.drawRect(70, 70, 150, 150); // �簢�� x, y, �ʺ�, ����
		// g.drawOval(100, 100, 80, 80); //��
		g.fillOval(100, 100, 80, 80); // �� ���� ä���
	}

	public static void main(String[] args) {
		WindowTest wt = new WindowTest(); // â ����
		// �Ȱ��� â�� ���µ� �����ڸ� ��Ƽ� �� �ص� �ǰ�~~~(*�ٸ� ���� AwtMain)
	}

}
