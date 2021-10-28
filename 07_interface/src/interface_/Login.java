package interface_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener, WindowListener {

	private JLabel idL, pwdL;
	private JTextField idT;
	private JPasswordField pwdT; // 비밀번호를 감춰주는 역할(***)
	private JButton loginBtn, resetBtn;

	public Login() {
		this.setLayout(null);

		// 생성
		idL = new JLabel("아이디");
		pwdL = new JLabel("패스워드");

		idT = new JTextField(); // 숫자로 들어오는 것이 아닌 문자로 들어옴
		pwdT = new JPasswordField();

		loginBtn = new JButton("로그인");
		resetBtn = new JButton("다시작성");

		// 배치
//		idL.setLocation(20, 20);
//		idL.setSize(100, 40);
		idL.setBounds(20, 20, 100, 40);
		pwdL.setBounds(20, 70, 100, 40);

		idT.setBounds(110, 20, 200, 40);
		pwdT.setBounds(110, 70, 200, 40);

		loginBtn.setBounds(70, 130, 90, 50);
		resetBtn.setBounds(170, 130, 90, 50);

		this.add(idL);
		this.add(pwdL);

		add(idT);
		add(pwdT);

		add(loginBtn);
		add(resetBtn);

		setBounds(700, 100, 350, 250);
		setVisible(true);

		// 이벤트
		resetBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		this.addWindowListener(this);

	} // Login()

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == resetBtn) {
			idT.setText(""); // 초기화
			pwdT.setText("");
		} else if (e.getSource() == loginBtn) {
			String id = idT.getText();
			String pwd = pwdT.getText(); // 품절되었으니 다른 거로 바꿔써라 하지만 무시
			System.out.println(id + "," + pwd);

			LoginResult result = new LoginResult(id, pwd);
		}

	}

	// WindowListener Override
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) { // X를 누르면 이쪽으로 온다
		System.out.println("프로그램 종료");
		System.exit(0);// 프로그램 강제 종료
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

	public static void main(String[] args) {
		new Login();
	}
}
