package inheritance;

import java.util.Scanner;

public class Examination {
	public static final String JUNG = "11111"; // ����, ���ȭ
	// final - ���� �̰��� �ٲ��� ����
	// static�� Ŭ������ ���� �����ϰ� ���ִ� ��. final�̶� ���� ���� ���δ�
	// ���ȭ ��ų ���� private���ٴ� public�� ���� ��

	private String name = null;
	private String dap;
	private char[] ox = null; // �迭�� - ���ڷ� ��Ҵٴ� ��
	// ���ڿ��� ���� ���� ���ڷ� ���� �� �ִµ�, ���ڿ��� ������ �׳� String���� ��� ���ڷ� ������ �迭�� ��ƾ�
	private int score;

	public Examination() { // ������
		Scanner scan = new Scanner(System.in);

		System.out.print("�̸� �Է� : ");
		name = scan.next();
		System.out.print("�� �Է� : ");
		dap = scan.next();

		ox = new char[5]; // char�� ���� 5�� ��ڴ�
	}

	public void compare() {
		for (int i = 0; i < ox.length; i++) {
			if (JUNG.charAt(i) == dap.charAt(i)) {
				ox[i] = 'O'; // ������
				score += 20;
			} else {
				ox[i] = 'X';
			}
		} // for
	}

	public String getName() {
		return name;
	}

	public char[] getOx() {
		return ox;
	}

	public int getScore() {
		return score;
	}
}