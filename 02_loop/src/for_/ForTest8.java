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

			System.out.print("x�� �Է� : ");
			x = Integer.parseInt(br.readLine());
			if (x == 0)
				break;

			System.out.print("y�� �Է� : ");
			y = Integer.parseInt(br.readLine());

			// x�� y��
			for (int i = 1; i <= y; i++) {
				mul *= x;
			}

			System.out.println(x + "�� " + y + "���� " + mul);
		} // for

		System.out.println("���α׷� �����մϴ�.");
	}

}