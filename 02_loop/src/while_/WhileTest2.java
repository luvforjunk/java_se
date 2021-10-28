/*
숫자 맞추기 게임

1 ~ 100 사이의 숫자를 맞추면 종료 됩니다

[실행결과]
숫자를 발생했습니다...(75)
숫자 입력 : 50
50보다 큽니다

숫자 입력 : 80
80보다 작습니다.

...

숫자 입력 : 75
딩동뎅...xx번만에 맞추셨습니다.
 */

package while_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhileTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com, user, count;
		int yn;

		while (true) {
			com = (int) (Math.random() * 100) + 1; // 1~100

			System.out.println();
			System.out.println("숫자를 발생했습니다..." + com);
			count = 0; // 초기화
			while (true) {
				System.out.print("숫자 입력 : ");
				user = Integer.parseInt(br.readLine());
				count++; // count = count + 1

				if (com == user)
					break;

				if (com > user) {
					System.out.println(user + "보다 큽니다");
				} else {
					System.out.println(user + "보다 작습니다");
				}
			} // while

			System.out.println("딩동뎅..." + count + "번만에 맞추셨습니다");

			while (true) {
				System.out.print("1번 더 (Y/N) ? ");
				yn = br.read();
				br.read();
				br.read();

				if (yn == 'Y' || yn == 'y' || yn == 'N' || yn == 'n')
					break;
			} // while

			if (yn == 'N' || yn == 'n')
				break;
		} // while
		System.out.println("프로그램을 종료합니다");
	}
}
