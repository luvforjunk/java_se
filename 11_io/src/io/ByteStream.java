package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data;

		while ((data = bis.read()) != -1) { // -1�� �ƴ� ������ while���� ������
			System.out.print((char) data); // ����ȯ
		} // while
		bis.close();
	}
}
// ����Ʈ ������ ���� �ȿ� �ִ� ������ �ѱ��ھ� �о���� ��
// ���̻� ���� ���ڰ� ������ null�� �ƴ� -1�� �����´�