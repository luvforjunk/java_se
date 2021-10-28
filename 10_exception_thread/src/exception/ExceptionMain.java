package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

	// ArrayIndexOutOfBoundsException
	public static void main(String[] args) { // 구현부
		if (args.length >= 1)
			System.out.println("args[0] = " + args[0]);

		ExceptionMain em = new ExceptionMain();
		em.sub(); // sub()호출

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b;

		try {
			System.out.print("정수 입력 : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("정수 입력 : ");
			b = Integer.parseInt(br.readLine());

			System.out.println(a + "/" + b + "=" + a / b);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("숫자 형태만 입력하세요");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누면 안됩니다");
			e.printStackTrace();
		} finally { // 반드시 DB는 꼭 들어가줘야 한다
			System.out.println("error가 있건 없건 무조건 실행!!");
		}
	}

	public void sub() { // 구현
		System.out.println("호호호");
	}
}
//public static void main(String[] args) { 
//main()호출 시점 - 실행할때(JVM에 의해 불려지는 것 - 콜백메소드)
//클래스 메모리 생성 X - static이기 때문에 뉴할필요 없다
//main이 없으면 실행이 되지 않는다

// System.in에서 in앞에 클래스가 바로 잡혀있는데 이 때의 in은 static이다
// in의 자료형은 InputStream이다
