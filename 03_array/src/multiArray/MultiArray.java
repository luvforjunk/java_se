package multiArray;

public class MultiArray {

	public static void main(String[] args) {
		int[][] ar = { { 10, 20 }, { 30, 40 }, { 50, 60 } };

		System.out.println("배열명 ar =" + ar);
		System.out.println();

		System.out.println("행 ar[0] = " + ar[0]);
		System.out.println("행 ar[1] = " + ar[1]);
		System.out.println("행 ar[2] = " + ar[2]);

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.println("ar[" + i + "][" + j + "] =" + ar[i][j]);
			}
			System.out.println();
		} // for i
	}

}
