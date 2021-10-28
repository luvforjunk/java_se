package class_;

//import static java.lang.Math.random;
//import static java.lang.Math.pow;
import static java.lang.Math.*;
import static java.lang.System.out;

import java.util.Random;

public class ImportStatic {

	public static void main(String[] args) {
		out.println("난수 =" + random()); // 0<= 난수 <1
		// Math.random()에서 Math를 없애고 싶으면 import static java.lang.Math.random; import시켜줌

		Random r = new Random();
		out.println("난수 =" + r.nextDouble()); // 0<=난수<1
		out.println("정수형 난수 =" + r.nextInt());
		out.println("정수형 난수 =" + r.nextInt(100)); // 0~99
		out.println("정수형 난수 =" + (r.nextInt(100) + 1)); // 1~100

		out.println("2의 5승 = " + Math.pow(2, 5));

	}

}
