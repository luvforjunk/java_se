package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class LoginResult extends JFrame implements WindowListener {
	private String id, pwd; // id와 pwd가 일찍 죽는 걸 방지하기 위해 필드에 생성

	public LoginResult(String id, String pwd) { // login으로 부터 id와 pwd를 전달 받는다
		this.id = id;
		this.pwd = pwd;

		setFont(new Font("돋움체", Font.BOLD, 20));
		this.setBounds(900, 120, 200, 200);
		this.setVisible(true);

		// 이벤트
		this.addWindowListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		// 부모 거를 강제로 불러버리면 투과가 안됨

		if (id.equals("hong") && pwd.equals("111")) {
			g.setColor(Color.BLUE);
			g.drawString("로그인 성공", 35, 100);
		} else {
			g.setColor(Color.RED);
			g.drawString("로그인 실패", 35, 100);
		}
	}

	// WindowListener Override
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false); // 로그인 눌렀을 시 뜨는 창만 닫기
		// system.exit 누르면 다 꺼지는 거
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}