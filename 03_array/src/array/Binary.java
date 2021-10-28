/*
10진수를 입력하여 2진수로 변환하시오
- 0이 입력되면 프로그램을 종료하시오
- 음수가 입력되면 재입력하시오
- 4개씩 끊어서 보여주기
- Integer.toBinaryString() 사용 X

10진수 입력 : -5

10진수 입력 : 12
1100

10진수 입력 : 250
1111 1010

10진수 입력 : -8

10진수 입력 : 0
프로그램을 종료합니다
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dec; // 4byte - 32bit
		int[] binary = new int[32];

		while (true) {
			System.out.print("10진수 입력 : ");
			dec = Integer.parseInt(br.readLine());
			if (dec == 0)
				break;
			if (dec < 0)
				continue;

			// 만약에 5를 2진수로 변환
			int i;
			for (i = 0; dec != 0; i++) { //0이 아닐 때까지 
				// System.out.println("i=" + i);
				binary[i] = dec % 2;
				dec = dec / 2; // 몫
			} // for
				// System.out.println("탈출 i=" + i);

			// 거꾸로 출력
			for (int k = i - 1; k >= 0; k--) {
				System.out.print(binary[k]);
				if (k % 4 == 0)
					System.out.print(" ");
			}
			System.out.println("\n");
		} // while

		System.out.println("프로그램을 종료합니다.");
	}

}
