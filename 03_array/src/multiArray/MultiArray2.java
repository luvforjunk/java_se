package multiArray;

public class MultiArray2 {

	public static void main(String[] args) {
		int[][] ar = new int[10][10];
		int num = 0; // 1 2 ~~~21 22~~~100

		// �Է�
		/*
		 * for(int i=0; i<ar.length; i++) { for(int j=0; j<ar[i].length; j++) { num++;
		 * ar[i][j] = num; }//for j }//for i
		 */

		/*
		 * for(int i=0; i<ar.length; i++) { for(int j=0; j<ar[i].length; j++) { num++;
		 * ar[j][i] = num; }//for j }//for i
		 */

		for (int i = ar.length - 1; i >= 0; i--) {
			for (int j = ar[i].length - 1; j >= 0; j--) {
				num++;
				ar[i][j] = num; //�� ��ġ�� �ش��ϴ� ����
			} // for j
		} // for i

		// ���
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print(String.format("%4d", ar[i][j]));
			} // for j
			System.out.println();// 10�پ� �������ϱ� ���� �����ϰ� ���� �����ٷ� ������.
		} // for i

	}

}
