package constructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputMain {
	private int x;
	private double y;

	public InputMain() throws FileNotFoundException { // �⺻������

		/*
		 Ű����κ��� �����͸� �ҷ��� �� Scanner scan = new Scanner(system.in);
		 System.out.println("���� �Է� :"); x = scan.nextInt();
		 System.out.println("�Ǽ� �Է� :"); y = scan.nextDouble();
		 */

		// ���Ϸκ��� �����͸� �ҷ��� ��
		Scanner scan = new Scanner(new File("data.txt"));
		x = scan.nextInt();
		y = scan.nextDouble();
	}

	public void output() {
		System.out.println("x =" + this.x + "\t y=" + this.y);

	}

	public static void main(String[] args) throws FileNotFoundException {
		InputMain aa = new InputMain();
		aa.output(); // ���

	}

}
