/*
[����]
�������� - PlusGame.java
- 2�ڸ��� ���ڷ� �����Ѵ� (10 ~ 99)
- �������� �� 5������ �����Ѵ�
- 1������ 20���� �����ȴ�

[������]

[���� 1] 12 + 95 = ���� �Է�
Ʋ�ȴ�...���� : 113

[���� 2 ]


[���� 5] 10 + 90 = ���� �Է�
������...�� ���߾��

����� �� x������ ���߾ xx�� �Դϴ�
 */

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		int rand1, rand2;
		rand1 = (int) (Math.random() * 90) + 10;
		rand2 = (int) (Math.random() * 90) + 10;
		int sum = rand1 + rand2;
		int q = 0;
		int num = q *= 20;
		int user = 0;

		for (i = 1; i <= 5; i++) {

			System.out.print("[" + "����" + i + "]" + rand1 + "+" + rand2 + "=");
			i = Integer.parseInt(br.readLine());

			System.out.print(" = ");
			user = Integer.parseInt(br.readLine()); //String�� int�� �ٲٴ� �� = Integer.parseInt(
		}

		if (user == sum)
			System.out.println("������");
		else
			System.out.print("Ʋ�Ⱦ�...���� : " + sum);
		System.out.println();

		System.out.print("����� ��" + q + "������ ���߾" + num + "�� �Դϴ�");

	}
}
