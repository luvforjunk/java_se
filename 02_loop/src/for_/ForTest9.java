package for_;

import java.io.IOException;

public class ForTest9 {

	public static void main(String[] args) throws IOException {
		System.out.print("x�� �Է� : ");
		int x = System.in.read() - '0';//�׻� 0 �Ǵ� ���ڸ��� �ڿ����� �Է��� ���̶�� �������� ��


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