package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain { // �ڹٰ� �����ϴ� Ŭ���� InetAddress
	// �߻��� �ƴϴ� ���������� new�ؼ� �ᵵ �������

	public static void main(String[] args) throws UnknownHostException {
		// ���̹� IP
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("NAVER IP = " + naver.getHostAddress());
		System.out.println();

		// �� ��ǻ�� IP
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("localhost IP = " + local.getHostAddress());
		System.out.println();

		// ���� - IP�� ���� ��� ���� ��
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		for (InetAddress ia : daum) {
			System.out.println("DAUM IP = " + ia.getHostAddress());
		} // for
		System.out.println();
	}
}

// The constructor InetAddress() is not visible - ������ �� ����?
// �߻�Ŭ������ �ƴϰ� �⺻ �����ڸ� ���� ���� �ʴ�
// ��� �޼ҵ带 �̿��ؼ� �����Ѵ� - getByName(String host)
// host �̸��� �ָ� IP�� �˷��ְڴٴ� �ǹ�
// Unhandled exception type UnknownHostException - ������ ����?
// UnknownHostException - ���ܸ� �ɾ��ش�