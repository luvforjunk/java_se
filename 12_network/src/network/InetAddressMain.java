package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain { // 자바가 제공하는 클래스 InetAddress
	// 추상이 아니다 직접적으로 new해서 써도 상관없다

	public static void main(String[] args) throws UnknownHostException {
		// 네이버 IP
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("NAVER IP = " + naver.getHostAddress());
		System.out.println();

		// 내 컴퓨터 IP
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("localhost IP = " + local.getHostAddress());
		System.out.println();

		// 다음 - IP를 많이 얻고 싶을 때
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		for (InetAddress ia : daum) {
			System.out.println("DAUM IP = " + ia.getHostAddress());
		} // for
		System.out.println();
	}
}

// The constructor InetAddress() is not visible - 오류가 난 이유?
// 추상클래스도 아니고 기본 생성자를 갖고 있지 않다
// 고로 메소드를 이용해서 생성한다 - getByName(String host)
// host 이름을 주면 IP를 알려주겠다는 의미
// Unhandled exception type UnknownHostException - 에러가 나네?
// UnknownHostException - 예외를 걸어준다