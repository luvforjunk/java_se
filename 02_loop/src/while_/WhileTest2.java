/*
���� ���߱� ����

1 ~ 100 ������ ���ڸ� ���߸� ���� �˴ϴ�

[������]
���ڸ� �߻��߽��ϴ�...(75)
���� �Է� : 50
50���� Ů�ϴ�

���� �Է� : 80
80���� �۽��ϴ�.

...

���� �Է� : 75
������...xx������ ���߼̽��ϴ�.
 */

package while_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhileTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com, user, count;
		int yn;

		while (true) {
			com = (int) (Math.random() * 100) + 1; // 1~100

			System.out.println();
			System.out.println("���ڸ� �߻��߽��ϴ�..." + com);
			count = 0; // �ʱ�ȭ
			while (true) {
				System.out.print("���� �Է� : ");
				user = Integer.parseInt(br.readLine());
				count++; // count = count + 1

				if (com == user)
					break;

				if (com > user) {
					System.out.println(user + "���� Ů�ϴ�");
				} else {
					System.out.println(user + "���� �۽��ϴ�");
				}
			} // while

			System.out.println("������..." + count + "������ ���߼̽��ϴ�");

			while (true) {
				System.out.print("1�� �� (Y/N) ? ");
				yn = br.read();
				br.read();
				br.read();

				if (yn == 'Y' || yn == 'y' || yn == 'N' || yn == 'n')
					break;
			} // while

			if (yn == 'N' || yn == 'n')
				break;
		} // while
		System.out.println("���α׷��� �����մϴ�");
	}
}
