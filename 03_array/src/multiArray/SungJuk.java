/*
3���� ����, ���, ������ ���Ͻÿ�
��, ����� �Ҽ����� 2°�ڸ����� ����Ͻÿ�

���� = ���� + ���� + ����
��� = ���� / 3
����� 90 �̻��̸� A
����� 80 �̻��̸� B
����� 70 �̻��̸� C
����� 60 �̻��̸� D
�׿ܴ� F

[������]
---------------------------------------------------------------------
�̸�	����	����	����	����	���	����
--------------------------------------------------------------------
ȫ�浿	90	96	100	286	95.33	A
���̾�	100	90	75	265	88.33	B
����ġ	75	80	48	203	67.67	D

 */

package multiArray;

public class SungJuk {

	public static void main(String[] args) {
		String[] name = { "ȫ�浿", "���̾�", "����ġ" };
		int[][] jumsu = { { 90, 96, 100, 0 }, { 100, 90, 75, 0 }, { 75, 80, 48, 0 } };
		double[] avg = new double[3];
		char[] grade = new char[3];

		// ó��
		for (int i = 0; i < jumsu.length; i++) {
			for (int j = 0; j < jumsu[i].length - 1; j++) {
				jumsu[i][3] += jumsu[i][j]; // ����
			} // for j

			// ���
			avg[i] = (double) jumsu[i][3] / 3.0;

			// ����
			if (avg[i] >= 90)
				grade[i] = 'A';
			else if (avg[i] >= 80)
				grade[i] = 'B';
			else if (avg[i] >= 70)
				grade[i] = 'C';
			else if (avg[i] >= 60)
				grade[i] = 'D';
			else
				grade[i] = 'F';
		} // for i

		// ���
		System.out.println("----------------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("----------------------------------------------------");
		for (int i = 0; i < jumsu.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < jumsu[i].length; j++) {
				System.out.print(jumsu[i][j] + "\t"); // ����, ����, ����, ����
			} // for j

			System.out.println(String.format("%.2f", avg[i]) + "\t" + grade[i]);
		} // for i
	}
}