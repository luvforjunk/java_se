package miniproject1;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AmasvinService extends Frame implements ActionListener {
	private Button writeBtn, loginBtn;
	private CardLayout card;
	private Panel centerP;

	public AmasvinService() { // 생성자
		setBackground(new Color(195, 219, 242));
		writeBtn = new Button("회원가입");
		loginBtn = new Button("로그인");

		Panel southP = new Panel(); // Panel-FlowLayout(순서배치)
		southP.setBackground(new Color(195, 250, 242));
		southP.add(writeBtn);
		southP.add(loginBtn);

		card = new CardLayout();

		centerP = new Panel();
		centerP.setLayout(card);
		centerP.add("login", new LoginFrame());
		centerP.add("write", new WriteFrame());

		add("South", southP);
		add("Center", centerP);

		this.setBounds(800, 100, 500, 650); // 창크기
		this.setResizable(false); // 창 고정
		this.setVisible(true);
		setBackground(new Color(195, 219, 242));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// 버튼 이벤트
		writeBtn.addActionListener(this);
		loginBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
if (e.getSource() == writeBtn) {
			card.show(centerP, "write");
		} else if (e.getSource() == loginBtn) {
			card.show(centerP, "login");
		}
	}

	public static void main(String[] args) {
		new AmasvinService();

	}

}