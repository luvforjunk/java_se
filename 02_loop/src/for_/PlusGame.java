/*
[숙제]
덧셈문제 - PlusGame.java
- 2자리의 숫자로 제공한다 (10 ~ 99)
- 문제수는 총 5문제를 제공한다
- 1문제당 20점씩 누적된다

[실행결과]

[문제 1] 12 + 95 = 직접 입력
틀렸다...정답 : 113

[문제 2 ]


[문제 5] 10 + 90 = 직접 입력
딩동뎅...참 잘했어요

당신은 총 x문제를 맞추어서 xx점 입니다
 */

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		int rand1, rand2;
		rand1 = (int) (Math.random() * 90) + 10;
		rand2 = (int) (Math.random() * 90) + 10;
		int sum = rand1 + rand2;
		int q = 0;
		int num = q *= 20;
		int user = 0;

		for (i = 1; i <= 5; i++) {

			System.out.print("[" + "문제" + i + "]" + rand1 + "+" + rand2 + "=");
			i = Integer.parseInt(br.readLine());

			System.out.print(" = ");
			user = Integer.parseInt(br.readLine()); //String을 int로 바꾸는 것 = Integer.parseInt(
		}

		if (user == sum)
			System.out.println("잘했으");
		else
			System.out.print("틀렸어...정답 : " + sum);
		System.out.println();

		System.out.print("당신은 총" + q + "문제를 맞추어서" + num + "점 입니다");

	}
}
