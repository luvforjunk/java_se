package network;

public class Protocol {
	public static final String ENTER = "100";
	public static final String EXIT = "200";
	public static final String SEND_MESSAGE = "300";
}

// 1. 서버를 먼저 실행해야 한다
// - 서버 소켓(소켓과는 다르다) : 기다려주는 역할만 한다.
// - 클라이언트가 접속하기를 기다린다
// - Accept해서 클라이언트와 대화 할 소켓을 만든다
// 클라이언트의 개수만큼 소켓을 만들어주는 거지.
// 2. 클라이언트(서비스 요청하는 사람)가 준비되어야 한다. - port번호, 서버 IP, 소켓
