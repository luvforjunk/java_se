package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");
		int size = (int) file.length(); // ���� ũ�� - Ÿ���� ũ�� ���� ������ int�� ��ȯ

		byte[] b = new byte[size]; // �迭 ����

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		bis.read(b, 0, size); // byte�� ��� �ִ� b, 0������ �о��, �迭�� �����ŭ �о��

		// �迭�� ������ ���� for���� ������
		// �����ϰ� ������~~ byte���·� ���� �迭�� ���ڿ��� ��ȯ�ؼ� ����
		System.out.println(new String(b)); // byte[] -> String ��ȯ
		bis.close(); // ���������� ����� ���� Ʋ� ���� ���������� �ٽ� ��ž� �ϴϱ�
	}
}

// ByteStream�� �ѱ��ھ� ���� ������ �о������....?
// �Ѳ����� �о �迭�� ����
// �� ���ھ� ���� �ִ��� ���� �׷� �迭�� ���� ���� ���ݾ�?
// �׷� ������ ũ�⸦ �˾ƾ߰���
// �ٵ� �߿��Ѱ� ���� �˰� �ִ� �� ������ �ƴ� ������ �̸��� �˰� �ִ� �׷� ������ ũ�⸦ �𸣴°���
// ���Ϸ� ����������! File file = new File("data.txt");
