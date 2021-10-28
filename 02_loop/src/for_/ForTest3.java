/*
65~90사이의 난수(A ~ Z)를 100개 발생하여 출력하시오
단, 1줄에 10개씩 나오도록 하시오.

[결과]
H  D  D  R  A  Y  A  K  T  H
C  X  F  Z  B  S  L  Y  Q  D
H  K  O  H  O  B  Z  N  J  T
U  P  A  P  K  Q  G  W  F  A
S  U  D  Z  I  V  J  U  O  G
L  M  Z  L  H  U  Y  D  Q  R
F  T  I  Z  A  W  E  O  F  Z
A  Y  C  I  U  Z  O  B  C  G
H  G  Y  Z  V  P  I  R  L  G
Y  H  R  R  M  H  Y  S  B  P

총 A의 개수 = ??
 */

package for_;

public class ForTest3 {

	public static void main(String[] args) {
		int rand;
		int count = 0;

		for (int i = 1; i <= 100; i++) { // 100번 반복
			// (int)(Math.random()* b-a+1) + a; //a~b까지 난수
			rand = (int) (Math.random() * 26) + 65; // 65 ~ 90
			System.out.print((char) rand + " ");
			
			if(i%10==0) System.out.println();

			if (rand == 'A')
				count++; // 1 2 3 4 5
		} // for
		System.out.println();
		System.out.println("총 A의 개수 = " + count);
	}
}


