/*
 �̸��� �� 5���� �Է��Ͽ� OX�� ä���Ͻÿ�
 - ������ 1������ 20���Դϴ�
 
 [������]
 �̸� �Է� : ȫ�浿
 �� �Է� : 14123
 
 �̸�		1 2 3 4 5 	����
 ȫ�浿	O X O X X   40
 
 Ŭ���� : Examination
 �ʵ� : name. dap, ox[], score
 �޼ҵ� : ������ - Scanner
 		compare() - ��, ���� ���
 		getter
 		
[������]
�ο��� �Է� : 3

�̸� �Է� : ȫ�浿
�� �Է� : 13211

�̸� �Է� : �ڳ�
�� �Է� : 11111

�̸� �Է� : ��ġ
�� �Է� : 13242

�̸�      1 2 3 4 5   ����
ȫ�浿     O X X O O   60
�ڳ�      O O O O O   100
��ġ      O X X X X   20
 */

package inheritance;

import java.util.Scanner;

public class ExaminationMain {

	public static void main(String[] args) {
		Examination aa = new Examination(); // �޸� ���� �� ������ ȣ��
		aa.compare(); // compare�� �޲ٱ�
		System.out.print(aa.getName() + "\t");
		for (int i = 0; i < aa.getOx().length; i++)
			// aa.ox.length�� ���� ������ private�̴ϱ� aa.getOx().length�� ���ش�
			System.out.print(aa.getOx()[i] + " ");
		System.out.println("\t" + aa.getScore());

		Scanner scan = new Scanner(System.in);

		System.out.print("�ο��� �Է� : ");
		int size = scan.nextInt();

		Examination[] ar = new Examination[size]; // �迭 ����

		for (int i = 0; i < size; i++) {
			ar[i] = new Examination(); // Ŭ���� ����
			ar[i].compare();
		} // for
		
		/*
		System.out.print(ar[0].getName() + "\t");
		for(int i = 0; i < ar[0].getOx().length; i++) 
			System.out.print(ar[0].getOx()[i] + " ");
		System.out.println("\t" + ar[0].getScore());
		
		System.out.print(ar[1].getName() + "\t");
		for(int i = 0; i < ar[1].getOx().length; i++) 
			System.out.print(ar[1].getOx()[i] + " ");
		System.out.println("\t" + ar[1].getScore());
		
		System.out.print(ar[2].getName() + "\t");
		for(int i = 0; i < ar[2].getOx().length; i++) 
			System.out.print(ar[2].getOx()[i] + " ");
		System.out.println("\t" + ar[2].getScore());
		*/

		// ���
		for (int k = 0; k < size; k++) {
			System.out.print(ar[k].getName() + "\t");
			System.out.println();

			for (int i = 0; i < ar[k].getOx().length; i++)
				System.out.print(ar[k].getOx()[i] + " ");
			System.out.println();

			System.out.println("\t" + ar[k].getScore());
		} // for k
	}
}