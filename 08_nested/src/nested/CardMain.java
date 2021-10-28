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
		frame = new Frame(); // ***항상 Frame은 상속받아서 쓰는 게 아니라
		card = new CardLayout();

		frame.setLayout(card);

		// Panel 7개 - 배열로
		Panel[] p = new Panel[7];
		Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.YELLOW, Color.ORANGE,
				Color.LIGHT_GRAY };

		String[] title = { "빨강", "초록", "파랑", "마젠타", "노랑", "오렌지", "그레이" };
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel(); // Panel 생성
			p[i].setBackground(color[i]); // 바탕색

			frame.add(p[i], title[i]);
		} // for

		// 이벤트
		for (int i = 0; i < p.length; i++) {
			p[i].addMouseListener(new MouseAdapter() { // 익명
				@Override
				public void mouseClicked(MouseEvent e) {
					// card.show(frame, "보라");
					card.next(frame);
				}
			});
		} // for
		frame.setBounds(900, 300, 200, 200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() { // 창 닫기
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
 * Frame / JFrame - BorderLayout (동서남북) Panel - FlowLayout (중앙, 순서 배치) -
 * GridLayout (행열배치) Canvas null : 레이아웃 자체가 없음. CardLayout() : 클릭할때마다 위로 올라옴
 */
