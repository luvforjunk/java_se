package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("프로토콜 = " + url.getProtocol()); // https
		System.out.println("호스트 = " + url.getHost()); // www.naver.com
		System.out.println("포트 = " + url.getPort()); // 포트 번호가 없는뎅? ...-1
		System.out.println("기본포트 = " + url.getDefaultPort()); // 443
		System.out.println("파일 = " + url.getFile()); // /index.html

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
