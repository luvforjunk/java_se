/*
 65~90 ������ ������ 100�� �߻��Ͽ� ���ڷ� ����Ͻÿ�
 - 1�ٿ� 10���� ����Ͻÿ�
 - �� ���ڸ��� �� ���� ��µǾ����� ������ ����Ͻÿ�
 
 [���� ���]
 A S D R J I I O P W
 D W E R W Q S ...
 
 A�� ���� :
 B�� ���� :
 ...
 Y�� ���� :
 Z�� ���� :
 */
package array;

public class ArrayTest4 {

	public static void main(String[] args) {
		int[] ar = new int[100];
		int[] count = new int[26];

		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) (Math.random() * 26) + 65; // 65~90

			for (int j = 0; j < count.length; j++) {
				if (ar[i] == (j + 65))
					count[j]++;
			} // for j
		} // for i

		// ���
		for (int i = 0; i < ar.length; i++) {
			System.out.print((char) ar[i] + "  ");
			if ((i + 1) % 10 == 0)
				System.out.println();
		}

		for (int i = 0; i < count.length; i++) {
			System.out.print((char) (i + 65) + "�� ���� = " + count[i] + "\t");
			if ((i + 1) % 3 == 0)
				System.out.println();
		}

	}
}