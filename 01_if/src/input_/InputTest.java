package input_;

import java.io.IOException;

class InputTest {
	public static void main(String[] args) throws IOException{
		System.out.print("데이터 : ");
		int a = System.in.read(); //딱 한개 그것도 문자로만 인정받음.
		System.in.read(); //flush

		System.out.print("데이터 : ");
		int b = System.in.read(); 

		System.out.println("결과 = " + a + ", " +b);
	}
}
