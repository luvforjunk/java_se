package if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 과목 점수 입력 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("두번째 과목 점수 입력 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("세번째 과목 점수 입력 : ");
		int c = Integer.parseInt(br.readLine());

		double avg = (double) (a + b + c) / 3;

		if (avg >= 60)
			if (a >= 40 && b >= 40 && c >= 40)
				System.out.println("합격");
			else
				System.out.println("과락으로 불합격");
		else
			System.out.println("불합격");
	}
}
