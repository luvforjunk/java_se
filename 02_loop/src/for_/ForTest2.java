/*
 [���]
 ���ϴ� ���� �Է� : 7(System.in.read())
 
 7*1=7
 7*2=14
 7*3=21
 7*4=28
 7*5=35
 7*6=42
 7*7=49
 7*8=56
 7*9=63
 */

package for_;

import java.io.IOException;

public class ForTest2 {

	public static void main(String[] args) throws IOException {
		int dan = 7, i;

		System.out.print("���ϴ� ���� �Է� : ");
		dan = System.in.read() - '0';
		for (i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + "=" + dan * i);
		}
	}

}
