/*�ο����� �Է��Ͽ� �ο�����ŭ �����͸� �Է¹ް� ������ ����� ���Ͻÿ�
����� �Ҽ����� 2°�ڸ����� ���

[������]
�ο��� : 2 (cnt)

�̸��Է� : ȫ�浿 (name)
����� �Է� : 2   (subjectCnt)
����� �Է� : ���� (subject)
����� �Է� : ����
���� ���� �Է� : 95 (jumsu)
���� ���� �Է� : 100
----------------------
�̸��Է� : �̱��� (name)
����� �Է� : 3   (subjectCnt)
����� �Է� : ���� (subject)
����� �Է� : ����
����� �Է� : �ڹ�
���� ���� �Է� : 95 (jumsu)
���� ���� �Է� : 100
�ڹ� ���� �Է� : 100

�̸�     ����     ����   ����     ���
ȫ�浿    95     100   xxx     xx.xx

�̸�      ����  ����   �ڹ�    ����      ���
�̱���     95  100  100     xxx      xx.xx
*/

package multiArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJuk2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("�ο��� �Է� : ");
		int cnt = Integer.parseInt(br.readLine()); //Integer.parseInt : ���ڿ��� ���ڷ�

		String[] name = new String[cnt];
		int subjectCnt;
		String[][] subject = new String[cnt][]; //�����迭
		int[][] jumsu = new int[cnt][];
		double[] avg = new double[cnt];

		// �Է�, ó��
		for (int i = 0; i < cnt; i++) {// �ο��� ��ŭ �ݺ�
			System.out.print("�̸� �Է� : ");
			name[i] = br.readLine(); //�Էµ� ���� ���ڿ��� �о��

			System.out.print("����� �Է� : ");
			subjectCnt = Integer.parseInt(br.readLine());

			subject[i] = new String[subjectCnt]; // ����
			for (int j = 0; j < subjectCnt; j++) {
				System.out.print("����� �Է� : ");
				subject[i][j] = br.readLine();
			} // for j

			jumsu[i] = new int[subjectCnt + 1]; // �����+����
			for (int j = 0; j < subjectCnt; j++) {
				System.out.print(subject[i][j] + "���� �Է� : "); //����� + ���� �Է� :
				jumsu[i][j] = Integer.parseInt(br.readLine());

				jumsu[i][subjectCnt] += jumsu[i][j]; // ����
			} // for j

			avg[i] = (double) jumsu[i][subjectCnt] / subjectCnt; // ���

		} // for i

		// ���
		for (int i = 0; i < cnt; i++) { // �ο��� ��ŭ �ݺ�
			// Ÿ��Ʋ
			System.out.print("�̸�\t");
			for (int j = 0; j < subject[i].length; j++) { //������� �� ������ �𸣴�
				System.out.print(subject[i][j] + "\t");
			}
			System.out.println("����\t���");

			// ������
			System.out.print(name[i] + "\t");
			for (int j = 0; j < jumsu[i].length; j++) { // �����, ����
				System.out.print(jumsu[i][j] + "\t");
			}
			System.out.println(String.format("%.2f", avg[i]));
			System.out.println();

		} // for i
	}

}