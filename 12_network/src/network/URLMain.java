package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("�������� = " + url.getProtocol()); // https
		System.out.println("ȣ��Ʈ = " + url.getHost()); // www.naver.com
		System.out.println("��Ʈ = " + url.getPort()); // ��Ʈ ��ȣ�� ���µ�? ...-1
		System.out.println("�⺻��Ʈ = " + url.getDefaultPort()); // 443
		System.out.println("���� = " + url.getFile()); // /index.html

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
