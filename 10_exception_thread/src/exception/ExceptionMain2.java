package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain2 {
	private int dan;

	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ϴ� ���� �Է� : ");
		try {
			dan = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void output() {
		if (dan >= 2 && dan <= 9) {
			for (int i = 1; i < 10; i++) {
				System.out.println(dan + "*" + i + "=" + (dan * i));
			}
		} else {
			// System.out.println("2~9 ������ ���ڸ� �Է��ϼ���!!");

			try {
				// �����ڰ� ������ Exception �߻�
				// throw new Exception("2~9 ������ ���ڸ� �Է��ϼ���!!");

				throw new MakeException("2~9 ������ ���ڸ� �Է��ϼ���!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExceptionMain2 ex = new ExceptionMain2();
		ex.input();
		ex.output();
	}
}
