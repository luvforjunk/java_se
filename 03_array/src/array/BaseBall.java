/*
�߱� ���� - ���� ���߱� ����
- ũ�Ⱑ 3���� ������ �迭�� ��� 1~9������ ������ �߻��Ѵ�
- ������ �ߺ��� ������� �ʴ´�

[������]
������ �����Ͻðڽ��ϱ�(Y/N) : w
������ �����Ͻðڽ��ϱ�(Y/N) : q
������ �����Ͻðڽ��ϱ�(Y/N) : y

������ �����մϴ�

�����Է� : 123
1��Ʈ����ũ 0��

�����Է� : 182
0��Ʈ����ũ 2��

...

�����Է� : 428
3��Ʈ����ũ 0��

�����մϴ�...��x������ ���߼̽��ϴ�.
 */

package array;

import java.io.IOException;

public class BaseBall {

	public static void main(String[] args) throws IOException {
		int[] com = new int[3];
		int[] user = new int[3];
		int yn;
		int strike, ball;
		int count = 0;
		//user�� �����͸� �ܺο��� �����Ŷ� �ʱⰪ�� ���൵ ������
		//count�� �ƴϴ�. �ʱⰪ 0�� �ݵ�� ��� �Ѵ�.

		do {
			System.out.print("������ �����Ͻðڽ��ϱ�(Y/N) : ");
			yn = System.in.read();
			System.in.read();
			System.in.read();
		} while (yn != 'Y' && yn != 'y' && yn != 'N' && yn != 'n');

		if (yn == 'Y' || yn == 'y') {
			System.out.println("������ �����մϴ�");

			// ���� �߻�
			for (int i = 0; i < com.length; i++) {
				com[i] = (int) (Math.random() * 9) + 1;

				// �ߺ�üũ
				for (int j = 0; j < i; j++) {
					if (com[i] == com[j]) {
						i--;
						break;
					}
				} // for j
			} // for i
				// System.out.println(com[0]+","+com[1]+","+com[2]);

			// ���� ���߱�
			while (true) { //�ѹ��� ���� �� ����, ���� ������ ��������ϴ� While���� ��.
				System.out.print("�����Է� : ");

				count++; //count = count + 1 - count�� 0�̾��
				for (int i = 0; i < user.length; i++) {
					user[i] = System.in.read() - '0';
				} // for i
				System.in.read();
				System.in.read();
				// System.out.println(user[0]+","+user[1]+","+user[2]);

				// ��
				strike = ball = 0;
				for (int i = 0; i < com.length; i++) {
					for (int j = 0; j < user.length; j++) {
						if (com[i] == user[j]) {// �����Ͱ� ������
							if (i == j) // ��ġ�� ������
								strike++;
							else
								ball++;
						}
					}
				} // for i

				System.out.println(strike + "��Ʈ����ũ     " + ball + "��");
				if (strike == 3) {
					System.out.println("\n �����մϴ�..." + count + "������ ���߼̽��ϴ�.");
					break;
				}

			} // while

		} // if
		System.out.println("���α׷��� �����մϴ�");
	}

}