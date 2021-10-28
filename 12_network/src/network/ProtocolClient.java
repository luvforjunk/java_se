package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	private Socket socket; // �ڵ���
	private BufferedReader br, keyboard;
	private BufferedWriter bw;

	ProtocolClient() {

		// ���� ����(�ڵ��� ����)
		try {
			socket = new Socket("172.16.11.203", 9500);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// Ű����� ���� �Է¹޾Ƽ�
			keyboard = new BufferedReader(new InputStreamReader(System.in));

		} catch (UnknownHostException e) { // ���� ��ȣ�Դϴ�
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);

		} catch (IOException e) {
			System.out.println("������ ������ �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}

		String msg = null;
		String line = null;
		while (true) { // ��ȭ ���� ������ ���ѷ���

			try {
				// ������ ������ ��
				System.out.print("�Է� : ");
				msg = keyboard.readLine(); // ���� �ٷ� ������ ������ ������
				bw.write(msg + "\n"); // ���͸� ���� �����ش�. �ȱ׷��� �����渶�� ���ٷ� �޿� ���´�
				// ������ ������(100:angel or 200:angel or 300:angel:�ȳ�)
				bw.flush(); // ���۸� ������ �� ���� �����͸� ���� �� �ֱ� ������

				// �����κ��� �޴� ��
				line = br.readLine(); // "angel�� ����", "angel�� ����", "[angel] �ȳ�"
				System.out.println(line);

				String[] ar = msg.split(":"); // "100", "angel" or "200", "angel"
				if (ar[0].equals("200")) { // ��ȭ ����~~
					br.close(); // �� �˰ھ�~~
					bw.close();
					socket.close();

					keyboard.close();

					System.exit(0);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // ProtocolClient()

	public static void main(String[] args) {
		new ProtocolClient();
	}
}
