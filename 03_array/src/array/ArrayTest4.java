/*
 65~90 사이의 난수를 100개 발생하여 문자로 출력하시오
 - 1줄에 10개씩 출력하시오
 - 각 문자마다 몇 개씩 출력되었는지 개수를 출력하시오
 
 [실행 결과]
 A S D R J I I O P W
 D W E R W Q S ...
 
 A의 개수 :
 B의 개수 :
 ...
 Y의 개수 :
 Z의 개수 :
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

		// 출력
		for (int i = 0; i < ar.length; i++) {
			System.out.print((char) ar[i] + "  ");
			if ((i + 1) % 10 == 0)
				System.out.println();
		}

		for (int i = 0; i < count.length; i++) {
			System.out.print((char) (i + 65) + "의 개수 = " + count[i] + "\t");
			if ((i + 1) % 3 == 0)
				System.out.println();
		}

	}
}