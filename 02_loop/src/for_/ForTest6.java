/*
 [����]
 ��� ���ϱ�.
 [���]
 ���� �Է� : 12		���� �Է� : 11
 1 2 3 4 6 12		1 11
12�� �Ҽ��� �ƴϴ�		11�� �Ҽ��̴�.
 */

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num, count = 0;

		System.out.print("���� �Է� : ");
		num = Integer.parseInt(br.readLine());

		for (int i = 1; i <= num; i++) {

			if (num % i == 0) {
				System.out.print(i + "  ");
				count++;
			}

		} // for
		System.out.println();

		if (count == 2)
			System.out.println(num + "�� �Ҽ��̴�");
		else
			System.out.println(num + "�� �Ҽ� �ƴϴ�");

	}

}
