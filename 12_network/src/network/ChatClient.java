package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	public ChatClient() {
		output = new JTextArea();
		output.setFont(new Font("돋움체", Font.BOLD, 16));
		output.setEditable(false); // 대화창에 글씨를 쓸 수 없게
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		input = new JTextField();
		sendBtn = new JButton("보내기");

		JPanel p = new JPanel(); // FlowLayout - 순서대로, 가운데로 애들을 모아
		p.setLayout(new BorderLayout()); // 창이 커지면서 TextField가 같이 커지게 하기 위해 Panel의 레이아웃을 바꿔주자
		p.add("Center", input);
		p.add("East", sendBtn);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);

		setBounds(900, 200, 300, 300);
		setVisible(true);

		// setDefaultCloseOperation(EXIT_ON_CLOSE); - 서버한테 얘기도 안하고 끊어버린거
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("exit"); // 서버에게 그만 끊자고 얘기하는 것
				pw.flush();
			}
		});

		// 이벤트
		sendBtn.addActionListener(this);
		input.addActionListener(this); // JTextField에서 enter칠 때

	} // ChatClient()

	public void service() { // 서버의 IP를 받자
//		String serverIP = JOptionPane.showInputDialog(this, 
//				"서버IP를 입력하세요", // 타이틀
//				"서버IP", // 제목
//				JOptionPane.INFORMATION_MESSAGE); // i

		String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "192.168.0.");
		if (serverIP == null || serverIP.length() == 0) { // null이 들어오는 때? 취소버튼을 누를 때
			System.out.println("서버IP가 입력되지 않았습니다");
			System.exit(0);
		}
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if (nickName == null || nickName.length() == 0) { // 닉네임에서 취소를 누르면
			nickName = "guest";
		}

		try {
			// 소켓생성
			socket = new Socket(serverIP, 9500);

			// IO
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 닉네임을 서버로 보내기
			pw.println(nickName);
			pw.flush();

		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		}
		Thread t = new Thread(this); // 스레드 생성
		t.start(); // 스레드 시작 - 스레드 실행(run메소드 찾으러~)

	} // service()

	@Override
	public void run() {
		// 서버로부터 받는 쪽
		String line = null;

		while (true) { // 계속 메시지가 들어오기 때문에 while문으로 무한루프
			try {
				line = br.readLine();

				if (line == null || line.toLowerCase().equals("exit")) {
					// exit 소문자로 보냈는데 Server에서 EXIT대문자로 보내면 안끊어지므로 toLowerCase() 붙여준다
					br.close();
					pw.close();
					socket.close();
					System.exit(0);
				}
				// null이 아니면?
				// TextArea에다가 안녕을 보냈다는 걸 뿌려준다
				// 대신 내용이 계속 추가 되어야 하니까 setText가 아닌 append를 써줌
				// readLine은 엔터를 읽지 않으니 + "\n"까지
				output.append(line + "\n");
				int pos = output.getText().length();
				output.setCaretPosition(pos); // 스크롤바 자동으로 내려가게

			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 서버로 보내는 쪽
		String line = input.getText(); // JTextField안에 내용을 가져오기
		pw.println(line);// 서버로 보내기 - ln이 있기 때문에 Enter값 안보내도 된다
		pw.flush();// 버퍼 비우기
		input.setText("");// 글씨 삭제 (JTextField초기화)
	}

	public static void main(String[] args) {
		new ChatClient().service();
	}

}

// Java는 동기식(요청을 하면 반드시 응답을 해야한다)
// 비동기식(요청을 하면 응답을 할 때까지 기다리지 않고 내 할일 한다) - AJax, jQuery
