/*
로또 - 자동
1~45사이의 난수를 6개 발생하시오
- 중복된 숫자 없어야 한다.
- 오름차순
- 5줄씩 끊어서 출력

[실행결과]
 7 12 25 36 37 42

돈 입력 : 7000

 7 12 25 36 37 42
 7 12 25 36 37 42
 7 12 25 36 37 42
 7 12 25 36 37 42
 7 12 25 36 37 42
 
 7 12 25 36 37 42
 7 12 25 36 37 42 
 ...
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lotto = new int[6];
		int money;

		System.out.print("돈 입력 : ");
		money = Integer.parseInt(br.readLine());

		for (int k = 1; k <= money / 1000; k++) {
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1; // 난수 발생

				// 중복 비교
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;// 4
						break; // for j를 벗어나라
					}
				} // for j
			} // for i

			/*
			 * int temp; for (int i = 0; i < lotto.length - 1; i++) { for (int j = i + 1; j
			 * < lotto.length; j++) { if (lotto[i] > lotto[j]) { temp = lotto[i]; lotto[i] =
			 * lotto[j]; lotto[j] = temp; } } }
			 */ // 아래 Arrays.sort와 같은 개념. 오름차순만 된다.
			Arrays.sort(lotto);

			// 출력
			for (int data : lotto) {
				System.out.print(String.format("%5d", data));
			}
			System.out.println();

			if (k % 5 == 0)
				System.out.println();
		} // for k

	}

}
