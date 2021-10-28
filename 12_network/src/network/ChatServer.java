package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private ServerSocket serverSocket;
	private List<ChatHandler> list; // Generic���� IO�� ��� �ִ� ChatHandler��

	public ChatServer() {
		try {
			serverSocket = new ServerSocket(9500);
			// 9500��Ʈ�� Ŭ���̾�Ʈ�� �����⸸�� ��ٸ���
			System.out.println("�����غ�Ϸ�");

			// socket = serverSocket.accept(); - ����ä�� �� �ѹ��� ���� ��
			// ProtocolServer ���� !

			list = new ArrayList<ChatHandler>();

			// ������ ä���� �������� ���� �� �𸣴� while���� �̿��� ���ѷ����� �����ش�
			while (true) {
				Socket socket = serverSocket.accept(); // ����ä�� Ŭ���̾�Ʈ�� ������ ������ ������ش�

				// �׷��� Server�� Client�� �� ������ �˾ƾ� �ϴµ�
				// ��� �� �� ������?
				// ������ ������ ���ָ� �ȴ�(Ŭ���̾�Ʈ�� ������ ���� ���� �ƴϴ�)
				// List�� ����� ��´�
				// �̶� ������ �� �ϳ�! ChatClient�� Thread�� �����δ�.
				// Server�� �ִ� ����(IO) ���� Thread�� ������ �Ѵ�
				// �ȳ��ϰ� ������ �� ���������� ������ ���� �ƴ��ݾ�?
				// Client�� Thread�� �Ǹ� �ºε�ġ�� Server���� ���� ���� Thread�� �Ǿ�� �Ѵ�
				// ������ ���� ������ Thread�� �� �� ����
				// ChatHandler�� ����� Thread�� ��� ���ش�
				// ��� Client�� ä���� �ְ� �޴� �� ��ǻ� Server�� �ƴ� Handler�̴�
				// pw�� br�� ���� �ִ� �� Handler�� �Ǵ� ��

				ChatHandler handler = new ChatHandler(socket, list); // ������ ����
				handler.start(); // ������ ���� - ������ �����ϱ� ���� run�޼ҵ� ã�ư���

				list.add(handler);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}

// ���� ������ �ϰ�
// �����غ� �Ϸ� �Ǹ� list ���
// ������ ��������� ���ÿ� list.add�ؼ� Handler�� ������ �Ѵ�
// �� ���� ChatHandler �������ְ�
// ChatHandler�� ���������� 
