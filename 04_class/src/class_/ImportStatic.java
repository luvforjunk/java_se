package class_;

//import static java.lang.Math.random;
//import static java.lang.Math.pow;
import static java.lang.Math.*;
import static java.lang.System.out;

import java.util.Random;

public class ImportStatic {

	public static void main(String[] args) {
		out.println("���� =" + random()); // 0<= ���� <1
		// Math.random()���� Math�� ���ְ� ������ import static java.lang.Math.random; import������

		Random r = new Random();
		out.println("���� =" + r.nextDouble()); // 0<=����<1
		out.println("������ ���� =" + r.nextInt());
		out.println("������ ���� =" + r.nextInt(100)); // 0~99
		out.println("������ ���� =" + (r.nextInt(100) + 1)); // 1~100

		out.println("2�� 5�� = " + Math.pow(2, 5));

	}

}
