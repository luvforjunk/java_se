/*
 이름과 답 5개를 입력하여 OX로 채점하시오
 - 점수는 1문제당 20점입니다
 
 [실행결과]
 이름 입력 : 홍길동
 답 입력 : 14123
 
 이름		1 2 3 4 5 	점수
 홍길동	O X O X X   40
 
 클래스 : Examination
 필드 : name. dap, ox[], score
 메소드 : 생성자 - Scanner
 		compare() - 비교, 점수 계산
 		getter
 		
[실행결과]
인원수 입력 : 3

이름 입력 : 홍길동
답 입력 : 13211

이름 입력 : 코난
답 입력 : 11111

이름 입력 : 또치
답 입력 : 13242

이름      1 2 3 4 5   점수
홍길동     O X X O O   60
코난      O O O O O   100
또치      O X X X X   20
 */

package inheritance;

import java.util.Scanner;

public class ExaminationMain {

	public static void main(String[] args) {
		Examination aa = new Examination(); // 메모리 생성 및 생성자 호출
		aa.compare(); // compare방 메꾸기
		System.out.print(aa.getName() + "\t");
		for (int i = 0; i < aa.getOx().length; i++)
			// aa.ox.length를 쓰면 되지만 private이니까 aa.getOx().length를 써준다
			System.out.print(aa.getOx()[i] + " ");
		System.out.println("\t" + aa.getScore());

		Scanner scan = new Scanner(System.in);

		System.out.print("인원수 입력 : ");
		int size = scan.nextInt();

		Examination[] ar = new Examination[size]; // 배열 생성

		for (int i = 0; i < size; i++) {
			ar[i] = new Examination(); // 클래스 생성
			ar[i].compare();
		} // for
		
		/*
		System.out.print(ar[0].getName() + "\t");
		for(int i = 0; i < ar[0].getOx().length; i++) 
			System.out.print(ar[0].getOx()[i] + " ");
		System.out.println("\t" + ar[0].getScore());
		
		System.out.print(ar[1].getName() + "\t");
		for(int i = 0; i < ar[1].getOx().length; i++) 
			System.out.print(ar[1].getOx()[i] + " ");
		System.out.println("\t" + ar[1].getScore());
		
		System.out.print(ar[2].getName() + "\t");
		for(int i = 0; i < ar[2].getOx().length; i++) 
			System.out.print(ar[2].getOx()[i] + " ");
		System.out.println("\t" + ar[2].getScore());
		*/

		// 출력
		for (int k = 0; k < size; k++) {
			System.out.print(ar[k].getName() + "\t");
			System.out.println();

			for (int i = 0; i < ar[k].getOx().length; i++)
				System.out.print(ar[k].getOx()[i] + " ");
			System.out.println();

			System.out.println("\t" + ar[k].getScore());
		} // for k
	}
}