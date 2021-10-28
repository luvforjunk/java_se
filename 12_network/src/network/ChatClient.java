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
		output.setFont(new Font("����ü", Font.BOLD, 16));
		output.setEditable(false); // ��ȭâ�� �۾��� �� �� ����
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		input = new JTextField();
		sendBtn = new JButton("������");

		JPanel p = new JPanel(); // FlowLayout - �������, ����� �ֵ��� ���
		p.setLayout(new BorderLayout()); // â�� Ŀ���鼭 TextField�� ���� Ŀ���� �ϱ� ���� Panel�� ���̾ƿ��� �ٲ�����
		p.add("Center", input);
		p.add("East", sendBtn);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);

		setBounds(900, 200, 300, 300);
		setVisible(true);

		// setDefaultCloseOperation(EXIT_ON_CLOSE); - �������� ��⵵ ���ϰ� ���������
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("exit"); // �������� �׸� ���ڰ� ����ϴ� ��
				pw.flush();
			}
		});

		// �̺�Ʈ
		sendBtn.addActionListener(this);
		input.addActionListener(this); // JTextField���� enterĥ ��

	} // ChatClient()

	public void service() { // ������ IP�� ����
//		String serverIP = JOptionPane.showInputDialog(this, 
//				"����IP�� �Է��ϼ���", // Ÿ��Ʋ
//				"����IP", // ����
//				JOptionPane.INFORMATION_MESSAGE); // i

		String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "192.168.0.");
		if (serverIP == null || serverIP.length() == 0) { // null�� ������ ��? ��ҹ�ư�� ���� ��
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���", "�г���", JOptionPane.INFORMATION_MESSAGE);
		if (nickName == null || nickName.length() == 0) { // �г��ӿ��� ��Ҹ� ������
			nickName = "guest";
		}

		try {
			// ���ϻ���
			socket = new Socket(serverIP, 9500);

			// IO
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			// �г����� ������ ������
			pw.println(nickName);
			pw.flush();

		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("������ ������ �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		Thread t = new Thread(this); // ������ ����
		t.start(); // ������ ���� - ������ ����(run�޼ҵ� ã����~)

	} // service()

	@Override
	public void run() {
		// �����κ��� �޴� ��
		String line = null;

		while (true) { // ��� �޽����� ������ ������ while������ ���ѷ���
			try {
				line = br.readLine();

				if (line == null || line.toLowerCase().equals("exit")) {
					// exit �ҹ��ڷ� ���´µ� Server���� EXIT�빮�ڷ� ������ �Ȳ������Ƿ� toLowerCase() �ٿ��ش�
					br.close();
					pw.close();
					socket.close();
					System.exit(0);
				}
				// null�� �ƴϸ�?
				// TextArea���ٰ� �ȳ��� ���´ٴ� �� �ѷ��ش�
				// ��� ������ ��� �߰� �Ǿ�� �ϴϱ� setText�� �ƴ� append�� ����
				// readLine�� ���͸� ���� ������ + "\n"����
				output.append(line + "\n");
				int pos = output.getText().length();
				output.setCaretPosition(pos); // ��ũ�ѹ� �ڵ����� ��������

			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ������ ������ ��
		String line = input.getText(); // JTextField�ȿ� ������ ��������
		pw.println(line);// ������ ������ - ln�� �ֱ� ������ Enter�� �Ⱥ����� �ȴ�
		pw.flush();// ���� ����
		input.setText("");// �۾� ���� (JTextField�ʱ�ȭ)
	}

	public static void main(String[] args) {
		new ChatClient().service();
	}

}

// Java�� �����(��û�� �ϸ� �ݵ�� ������ �ؾ��Ѵ�)
// �񵿱��(��û�� �ϸ� ������ �� ������ ��ٸ��� �ʰ� �� ���� �Ѵ�) - AJax, jQuery
