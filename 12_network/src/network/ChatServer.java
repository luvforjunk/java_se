package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private ServerSocket serverSocket;
	private List<ChatHandler> list; // Generic에는 IO를 쥐고 있는 ChatHandler로

	public ChatServer() {
		try {
			serverSocket = new ServerSocket(9500);
			// 9500포트로 클라이언트가 들어오기만을 기다린다
			System.out.println("서버준비완료");

			// socket = serverSocket.accept(); - 낚아채는 걸 한번만 해준 격
			// ProtocolServer 참고 !

			list = new ArrayList<ChatHandler>();

			// 하지만 채팅은 언제까지 잡을 지 모르니 while문을 이용해 무한루프를 돌려준다
			while (true) {
				Socket socket = serverSocket.accept(); // 낚아채서 클라이언트와 연결할 소켓을 만들어준다

				// 그렇담 Server는 Client가 몇 명인지 알아야 하는데
				// 어떻게 알 수 있을까?
				// 소켓의 개수를 세주면 된다(클라이언트의 개수를 세는 것이 아니다)
				// List를 만들어 담는다
				// 이때 주의할 것 하나! ChatClient는 Thread로 움직인다.
				// Server에 있는 소켓(IO) 역시 Thread로 묶여야 한다
				// 안녕하고 보내는 데 순차적으로 보내는 것이 아니잖아?
				// Client가 Thread가 되면 맞부딪치는 Server소켓 역시 같은 Thread가 되어야 한다
				// 하지만 절대 서버는 Thread가 될 수 없다
				// ChatHandler를 만들어 Thread를 대신 해준다
				// 고로 Client와 채팅을 주고 받는 건 사실상 Server가 아닌 Handler이다
				// pw와 br을 갖고 있는 건 Handler가 되는 것

				ChatHandler handler = new ChatHandler(socket, list); // 스레드 생성
				handler.start(); // 스레드 시작 - 스레드 실행하기 위해 run메소드 찾아가라

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

// 먼저 생성을 하고
// 서버준비 완료 되면 list 잡고
// 소켓이 만들어짐과 동시에 list.add해서 Handler를 담아줘야 한다
// 그 전에 ChatHandler 생성해주고
// ChatHandler를 생성했으면 
