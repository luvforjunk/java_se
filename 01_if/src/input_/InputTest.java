package input_;

import java.io.IOException;

class InputTest {
	public static void main(String[] args) throws IOException{
		System.out.print("������ : ");
		int a = System.in.read(); //�� �Ѱ� �װ͵� ���ڷθ� ��������.
		System.in.read(); //flush

		System.out.print("������ : ");
		int b = System.in.read(); 

		System.out.println("��� = " + a + ", " +b);
	}
}
