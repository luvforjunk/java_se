package multiArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJuk3 {

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		int menu [] = new int [6];
		
		System.out.println("**************");
		System.out.println("1. 입차 ");
		System.out.println("2. 출차 ");
		System.out.println("3. 리스트");
		System.out.println("4. 종료");
		System.out.println("**************");
		System.out.print("메뉴 : ");
		num = Integer.parseInt(br.readLine());
		if (num == 4) System.out.println("프로그램을 종료합니다");;
		
	}
}