package for_;

public class ForTest {

	public static void main(String[] args) {
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println("안녕하세요" + i); // 10번 찍힘
		} // for

		System.out.println("탈출 i =" + i);
		System.out.println();

		// 10 9 8 7 6 5 4 3 2 1
		for (i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();

		// A B C D E F G... X Y Z
		// for(i= 65; i<=90; i++) {
		for (i = 'A'; i <= 'Z'; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();
	}

}

//자바의 변수가 살아있는 생존기간은 구역{} 안에서만 살다가 없어지면 소멸됨.