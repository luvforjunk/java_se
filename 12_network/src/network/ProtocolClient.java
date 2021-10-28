package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	private Socket socket; // 핸드폰
	private BufferedReader br, keyboard;
	private BufferedWriter bw;

	ProtocolClient() {

		// 소켓 생성(핸드폰 구입)
		try {
			socket = new Socket("172.16.11.203", 9500);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 키보드로 부터 입력받아서
			keyboard = new BufferedReader(new InputStreamReader(System.in));

		} catch (UnknownHostException e) { // 없는 번호입니다
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);

		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		}

		String msg = null;
		String line = null;
		while (true) { // 전화 끊을 때까지 무한루프

			try {
				// 서버로 보내는 쪽
				System.out.print("입력 : ");
				msg = keyboard.readLine(); // 엔터 바로 전까지 보내기 때문에
				bw.write(msg + "\n"); // 엔터를 같이 보내준다. 안그러면 기찻길마냥 한줄로 쭈욱 나온다
				// 서버로 보내기(100:angel or 200:angel or 300:angel:안녕)
				bw.flush(); // 버퍼를 비워줘야 그 다음 데이터를 받을 수 있기 때문에

				// 서버로부터 받는 쪽
				line = br.readLine(); // "angel님 입장", "angel님 퇴장", "[angel] 안녕"
				System.out.println(line);

				String[] ar = msg.split(":"); // "100", "angel" or "200", "angel"
				if (ar[0].equals("200")) { // 전화 끊자~~
					br.close(); // 응 알겠어~~
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
