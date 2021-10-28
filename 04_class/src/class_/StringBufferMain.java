/*
 ���ϴ� ���� �Է� : 7		������
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

	public StringBufferMain() { // ���� public�� ��������������, �Ⱦ��� �ܺ�Ŭ���������� ���� x
		System.out.print("���ϴ� ���� �Է� : ");
		dan = scan.nextInt(); // ���⼭�� ������ ��ü���� ���������� �������ϱ� this��� �ִ� ���� dan���̶� ����
		display();
	}

	public void display() {
		StringBuffer buffer = new StringBuffer(); 
		//StringBuffer buffer = "" �� ���� literal�� ���� ���� �ȵ�. 
		// ���ڿ� ó�� - String�� �޸� ��������
		for (int i = 1; i < 10; i++) {
			// System.out.println(dan+" * "+i+" = "+(dan*i));
			buffer.append(dan); //append�� ��Ʈ�Ӹ��� �߰��� �ȴ�.
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan * i);
			System.out.println(buffer);
			buffer.delete(0, buffer.length()); // buffer append�� delete����ؼ� ������ ���
		} //for
	}

	public static void main(String[] args) { 
		//���α׷��� �����ϸ� main���� ã�� �ٵ� ������ ����?
		//�ϸ� Ŭ������ ��� �ʵ带 ��ƺ��� �ǹ̰� ����. ���� �ҷ����� �Ѵ�.
		StringBufferMain aa = new StringBufferMain(); // static�� �����ϱ� new�� �������ֱ�
		// �����ڿ� display(); �ȳ־���� ���⼭ main.display();�� �ҷ��͵� ��
	} // main
}
