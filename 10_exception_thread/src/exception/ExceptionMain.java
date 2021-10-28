package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

	// ArrayIndexOutOfBoundsException
	public static void main(String[] args) { // ������
		if (args.length >= 1)
			System.out.println("args[0] = " + args[0]);

		ExceptionMain em = new ExceptionMain();
		em.sub(); // sub()ȣ��

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b;

		try {
			System.out.print("���� �Է� : ");
			a = Integer.parseInt(br.readLine());
			System.out.print("���� �Է� : ");
			b = Integer.parseInt(br.readLine());

			System.out.println(a + "/" + b + "=" + a / b);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("���� ���¸� �Է��ϼ���");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("0���� ������ �ȵ˴ϴ�");
			e.printStackTrace();
		} finally { // �ݵ�� DB�� �� ����� �Ѵ�
			System.out.println("error�� �ְ� ���� ������ ����!!");
		}
	}

	public void sub() { // ����
		System.out.println("ȣȣȣ");
	}
}
//public static void main(String[] args) { 
//main()ȣ�� ���� - �����Ҷ�(JVM�� ���� �ҷ����� �� - �ݹ�޼ҵ�)
//Ŭ���� �޸� ���� X - static�̱� ������ �����ʿ� ����
//main�� ������ ������ ���� �ʴ´�

// System.in���� in�տ� Ŭ������ �ٷ� �����ִµ� �� ���� in�� static�̴�
// in�� �ڷ����� InputStream�̴�
