package if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ù��° ���� ���� �Է� : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� ���� �Է� : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("����° ���� ���� �Է� : ");
		int c = Integer.parseInt(br.readLine());

		double avg = (double) (a + b + c) / 3;

		if (avg >= 60)
			if (a >= 40 && b >= 40 && c >= 40)
				System.out.println("�հ�");
			else
				System.out.println("�������� ���հ�");
		else
			System.out.println("���հ�");
	}
}
