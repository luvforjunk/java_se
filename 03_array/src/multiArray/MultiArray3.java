/*
[실행결과]
 1   2   3   0
 4   5   6   0
 7   8   9   0
 0   0   0   0
 
 */
package multiArray;

public class MultiArray3 {

	public static void main(String[] args) {
		int[][] ar = { { 1, 2, 3, 0 }, { 4, 5, 6, 0 }, { 7, 8, 9, 0 }, { 0, 0, 0, 0 } };

		// 합
		for (int i = 0; i < ar.length - 1; i++) { // 반복을 돌림 매개값으로 받은 배열의 길이 -1만큼(인덱스가 0부터 시작하기 때문에 길이마큼 횟수를 가지려면 빼줘야함)
			for (int j = 0; j < ar[i].length - 1; j++) {
				ar[i][3] += ar[i][j];
				ar[3][i] += ar[j][i]; // ar[3][j] += ar[i][j];
				ar[3][3] += ar[i][j];
			} // for j
		} // for i

		// 출력
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print(String.format("%4d", ar[i][j]));
			} // for j
			System.out.println();
		} // for i

	}

}