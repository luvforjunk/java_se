package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	public static void main(String[] args) throws FileNotFoundException, IOException { // �θ��� IOException�� ���൵ ��
		// �����͸� ���Ͽ� ����ִ� ���
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		dos.writeUTF("ȫ�浿"); // �ѱ�ó���� UTF���� �������� �������Ŵ�~
		dos.writeInt(25); // ���̴ϱ� ������
		dos.writeFloat(185.3f);
		// dos.writeFloat(185.3); ��� ���� �� error�� �ߴ� ������ Double���ε� Float�� �޾Ƽ��̴�
		// Double�� �ٲ��� �ʰ� Float������ ������ �ڿ� f�� ���ָ� �ȴ�! ���ܾ�~~
		dos.close();

		// ���� �ȿ��� �����͸� �������� ���
		DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
		System.out.println("�̸� = " + dis.readUTF());
		System.out.println("���� = " + dis.readInt());
		System.out.println("Ű = " + dis.readFloat());
		dis.close();
	}
}

// BufferedOutputStream�� ������ �޼ҵ尡 � �ȵȴ�. ������ Ȥ�� byte.
// ���� ���ڿ� Ȥ�� �Ǽ��� �����Ⱑ �ʹ� �����ϴϱ� DataOutputStream�� ���ش�
// File�� �������� ���� ���� FileOutputStream

