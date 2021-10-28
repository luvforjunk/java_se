package for_;

import java.io.IOException;

public class ForTest9 {

	public static void main(String[] args) throws IOException {
		System.out.print("x값 입력 : ");
		int x = System.in.read() - '0';//항상 0 또는 한자리의 자연수를 입력할 것이라고 가정했을 때


		// 7! = 1*2*3*4*5*6*7 = 5040
		int mul = 1;
		System.out.print(x + "!=");
		for (int i = 1; i <= x; i++) {
			mul *= i;

			if (i < x)
				System.out.print(i + "*");
			else
				System.out.print(i + "=");
		} // for

		System.out.println(mul);
	}
}