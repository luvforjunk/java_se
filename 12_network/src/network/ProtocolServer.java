package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;

	public ProtocolServer() { // �׻� ���� ����
		try {
			// �Ͽ����� 9500�� ���� ���鼭 Client�� ������ ��ٸ���
			serverSocket = new ServerSocket(9500);
			System.out.print("�����غ�Ϸ�");

			// Ŭ���̾�Ʈ�� ������ ����ä�� Ŭ���̾�Ʈ�� ������ ������ ������ش�
			// ServerSocket�� ����. �׷��� ��ȭ�� �������� �ʰ� ������ ����
			socket = serverSocket.accept();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������ �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		String line = null;
		while (true) {
			try {
				// �޴� ��
				line = br.readLine(); // 100:angel or 200:angel or 300:angel:�ȳ�

				// ������ ��
				String[] ar = line.split(":"); // �ݷ��� �������� �����ּ���
				if (ar[0].equals("100")) { // 0��° ���� 100���� ���Խ��ϱ�
					bw.write(ar[1] + "�� ����\n"); // Ŭ���̾�Ʈ���� �������� ���⼭�� ���Ͱ�
					bw.flush();

				} else if (ar[0].equals("200")) {
					bw.write(ar[1] + "�� ����\n");
					bw.flush();
					
					br.close();
					bw.close();
					socket.close();
					
					System.exit(0);
					
				} else if (ar[0].equals("300")) {
					bw.write("[" + ar[1] + "]" + ar[2] + "\n");
					bw.flush();

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} // while
	} // ProtocolServer

	public static void main(String[] args) {
		new ProtocolServer();
	}
}
