package constructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputMain {
	private int x;
	private double y;

	public InputMain() throws FileNotFoundException { // 기본생성자

		/*
		 키보드로부터 데이터를 불러올 때 Scanner scan = new Scanner(system.in);
		 System.out.println("정수 입력 :"); x = scan.nextInt();
		 System.out.println("실수 입력 :"); y = scan.nextDouble();
		 */

		// 파일로부터 데이터를 불러올 때
		Scanner scan = new Scanner(new File("data.txt"));
		x = scan.nextInt();
		y = scan.nextDouble();
	}

	public void output() {
		System.out.println("x =" + this.x + "\t y=" + this.y);

	}

	public static void main(String[] args) throws FileNotFoundException {
		InputMain aa = new InputMain();
		aa.output(); // 출력

	}

}
