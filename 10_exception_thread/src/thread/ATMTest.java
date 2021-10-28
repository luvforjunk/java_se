package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.text.DecimalFormat;

public class ATMTest implements Runnable {
	// Runnable�̶� interface�� �����ٴ� �� ATMTest�� Thread�ϰ� �ʹٴ� ��
	private long depositeMoney = 100000; // �ܾ�
	private long balance; // ã���� �ϴ� �ݾ�

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm, "����"); // ������ ���� - �Ʒ� setName ��� �̸��� ��������� �ȴ�
		Thread son = new Thread(atm, "�Ƶ�"); // ������ ����

//		mom.setName("����"); // �����忡 �̸� ���
//		son.setName("�Ƶ�");
		mom.start(); // ������ ����
		son.start(); // ������ ����
	}

	@Override
	public synchronized void run() {
		System.out.println("�ȳ��ϼ��� " + Thread.currentThread().getName() + "��"); // ���� �������� ������ ����

		// Thread[����,5,main]
		// Thread[�Ƶ�,5,main]
		// �ȳ��ϼ��� ������ ------ getName�� ���� �̸��� ������ ���� �����
		// �ȳ��ϼ��� �Ƶ��

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("ã���� �ϴ� �ݾ� �Է� : ");
		// balance = Integer.parseInt(br.readLine()); ---error
		// balance�� longŸ���ε�, 8����Ʈ�� 4����Ʈ�� Integer.parseInt�� �ٲ�� �ȵǴ�,
		try {
			balance = Long.parseLong(br.readLine()); // Override �������� throw ���� �ȵ�
		} catch (IOException e) { // IO�� NumberFormat Exception�� ��ƹ���
			e.printStackTrace();
		}

		// �ܾ� ���
		if (depositeMoney > balance) {
			depositeMoney -= balance;
			System.out.println("�ܾ��� " + depositeMoney + "�Դϴ�");
		} else if (depositeMoney < balance) {
			System.out.println("�ܾ��� �����մϴ�.");
		} else if (depositeMoney % 10000 != 0) {
			System.out.println("���� ������ �Է��ϼ���");

		}
	}
}

// ������ �Ƶ��� ���ÿ� ������ ã���� �ϴ� �ݾ� �Է� : ã���� �ϴ� �ݾ� �Է� : 
// 0.1�ʶ� ���� ������ ����� �����Բ�
// ��ġ�� �ʰ� synchronized�� �ɾ��ش�. �� ���, �ȳ��ϼ��� ������ ã���� �ϴ� �ݾ� �Է� : 
