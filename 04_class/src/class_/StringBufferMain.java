/*
 원하는 단을 입력 : 7		생성자
 -------------------------------------
 7*1 = 7				display()
 7*2 = 14
 ...
 7*9 = 63
 */


package class_;

import java.util.Scanner;

public class StringBufferMain {
	Scanner scan = new Scanner(System.in);
	private int dan;

	public StringBufferMain() { // 앞의 public은 생략가능하지만, 안쓰면 외부클래스에서는 접근 x
		System.out.print("원하는 단을 입력 : ");
		dan = scan.nextInt(); // 여기서는 생성자 자체에서 변수생성을 안했으니까 this없어도 있는 변수 dan뿐이라 ㄱㅊ
		display();
	}

	public void display() {
		StringBuffer buffer = new StringBuffer(); 
		//StringBuffer buffer = "" 과 같이 literal은 절대 생성 안됨. 
		// 문자열 처리 - String과 달리 수정가능
		for (int i = 1; i < 10; i++) {
			// System.out.println(dan+" * "+i+" = "+(dan*i));
			buffer.append(dan); //append는 끄트머리에 추가가 된다.
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan * i);
			System.out.println(buffer);
			buffer.delete(0, buffer.length()); // buffer append와 delete사용해서 구구단 찍기
		} //for
	}

	public static void main(String[] args) { 
		//프로그램을 실행하면 main부터 찾음 근데 정보가 없다?
		//암만 클래스를 잡고 필드를 잡아봤자 의미가 없음. 따라서 불러내야 한다.
		StringBufferMain aa = new StringBufferMain(); // static이 없으니까 new로 생성해주기
		// 생성자에 display(); 안넣어놓고 여기서 main.display();로 불러와도 됨
	} // main
}
