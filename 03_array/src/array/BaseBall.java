/*
야구 게임 - 숫자 맞추기 게임
- 크기가 3개인 정수형 배열을 잡고 1~9사이의 난수를 발생한다
- 난수는 중복을 허용하지 않는다

[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : q
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다

숫자입력 : 123
1스트라이크 0볼

숫자입력 : 182
0스트라이크 2볼

...

숫자입력 : 428
3스트라이크 0볼

축하합니다...몇x번만에 맞추셨습니다.
 */

package array;

import java.io.IOException;

public class BaseBall {

	public static void main(String[] args) throws IOException {
		int[] com = new int[3];
		int[] user = new int[3];
		int yn;
		int strike, ball;
		int count = 0;
		//user는 데이터를 외부에서 받을거라 초기값을 안줘도 되지만
		//count는 아니다. 초기값 0을 반드시 줘야 한다.

		do {
			System.out.print("게임을 실행하시겠습니까(Y/N) : ");
			yn = System.in.read();
			System.in.read();
			System.in.read();
		} while (yn != 'Y' && yn != 'y' && yn != 'N' && yn != 'n');

		if (yn == 'Y' || yn == 'y') {
			System.out.println("게임을 시작합니다");

			// 난수 발생
			for (int i = 0; i < com.length; i++) {
				com[i] = (int) (Math.random() * 9) + 1;

				// 중복체크
				for (int j = 0; j < i; j++) {
					if (com[i] == com[j]) {
						i--;
						break;
					}
				} // for j
			} // for i
				// System.out.println(com[0]+","+com[1]+","+com[2]);

			// 숫자 맞추기
			while (true) { //한번에 맞출 수 없고, 맞출 때까지 돌려줘야하니 While문이 들어감.
				System.out.print("숫자입력 : ");

				count++; //count = count + 1 - count가 0이어야
				for (int i = 0; i < user.length; i++) {
					user[i] = System.in.read() - '0';
				} // for i
				System.in.read();
				System.in.read();
				// System.out.println(user[0]+","+user[1]+","+user[2]);

				// 비교
				strike = ball = 0;
				for (int i = 0; i < com.length; i++) {
					for (int j = 0; j < user.length; j++) {
						if (com[i] == user[j]) {// 데이터가 같으냐
							if (i == j) // 위치도 같으냐
								strike++;
							else
								ball++;
						}
					}
				} // for i

				System.out.println(strike + "스트라이크     " + ball + "볼");
				if (strike == 3) {
					System.out.println("\n 축하합니다..." + count + "번만에 맞추셨습니다.");
					break;
				}

			} // while

		} // if
		System.out.println("프로그램을 종료합니다");
	}

}