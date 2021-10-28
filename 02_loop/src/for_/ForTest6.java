/*
 [문제]
 약수 구하기.
 [결과]
 숫자 입력 : 12		숫자 입력 : 11
 1 2 3 4 6 12		1 11
12는 소수가 아니다		11은 소수이다.
 */

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num, count = 0;

		System.out.print("숫자 입력 : ");
		num = Integer.parseInt(br.readLine());

		for (int i = 1; i <= num; i++) {

			if (num % i == 0) {
				System.out.print(i + "  ");
				count++;
			}

		} // for
		System.out.println();

		if (count == 2)
			System.out.println(num + "은 소수이다");
		else
			System.out.println(num + "은 소수 아니다");

	}

}
