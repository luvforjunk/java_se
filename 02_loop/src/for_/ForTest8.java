package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x, y;
		int mul;

		for (;;) {
			mul = 1;

			System.out.print("x값 입력 : ");
			x = Integer.parseInt(br.readLine());
			if (x == 0)
				break;

			System.out.print("y값 입력 : ");
			y = Integer.parseInt(br.readLine());

			// x의 y승
			for (int i = 1; i <= y; i++) {
				mul *= x;
			}

			System.out.println(x + "의 " + y + "승은 " + mul);
		} // for

		System.out.println("프로그램 종료합니다.");
	}

}