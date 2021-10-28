package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardMain {
	private Frame frame;
	private CardLayout card;

	public CardMain() {
		frame = new Frame(); // ***�׻� Frame�� ��ӹ޾Ƽ� ���� �� �ƴ϶�
		card = new CardLayout();

		frame.setLayout(card);

		// Panel 7�� - �迭��
		Panel[] p = new Panel[7];
		Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.YELLOW, Color.ORANGE,
				Color.LIGHT_GRAY };

		String[] title = { "����", "�ʷ�", "�Ķ�", "����Ÿ", "���", "������", "�׷���" };
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel(); // Panel ����
			p[i].setBackground(color[i]); // ������

			frame.add(p[i], title[i]);
		} // for

		// �̺�Ʈ
		for (int i = 0; i < p.length; i++) {
			p[i].addMouseListener(new MouseAdapter() { // �͸�
				@Override
				public void mouseClicked(MouseEvent e) {
					// card.show(frame, "����");
					card.next(frame);
				}
			});
		} // for
		frame.setBounds(900, 300, 200, 200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() { // â �ݱ�
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new CardMain();
	}
}

/*
 * Frame / JFrame - BorderLayout (��������) Panel - FlowLayout (�߾�, ���� ��ġ) -
 * GridLayout (�࿭��ġ) Canvas null : ���̾ƿ� ��ü�� ����. CardLayout() : Ŭ���Ҷ����� ���� �ö��
 */
