package inheritance;

class AAA {
}

class BBB extends AAA {
} // AAAŬ������ �������� BBB
//----------------------

public class InstanceOf {

	public static void main(String[] args) {
		AAA aa = new AAA();
		BBB bb = new BBB();
		AAA aa2 = new BBB();

		AAA aa3 = aa;
		if (aa instanceof AAA)
			System.out.println("1. TRUE"); // aa�� AAA�� ���� �� �ִ���
		else
			System.out.println("1. FALSE");
		// aa�� �ּҰ��� aa3���� �Ѱ��ְڴ�. ���� Ŭ���� Ÿ���̴ϱ� aa3�� aa�� �ּҰ��� ���� ���� �� �ְ�, �ּҰ��� ���� aa3��
		// AAA�� ����Ű�� �ȴ�.
		// aa�� ������ AAA�� �ѱ� �� �ִ� = aa�� �������� ���󰬴��� �޸𸮿� AAAŬ������ �����ִ�

		AAA aa4 = bb;
		if (bb instanceof AAA)
			System.out.println("1. TRUE"); // aa�� AAA�� ���� �� �ִ���
		else
			System.out.println("1. FALSE");

		BBB bb2 = (BBB) aa2;
		// aa2�� AAA�� BBB�� ���� ������ �������� ĳ������ ������
		// DownCasting�����
		if (aa2 instanceof BBB)
			System.out.println("1. TRUE");
		else
			System.out.println("1. FALSE");

		// BBB bb3 = (BBB)aa; - error
		// aa�� AAA�ȿ� ȥ�� ��Ƽ� BBB�� ĳ������ �� ����
		if (aa instanceof BBB)
			System.out.println("1. TRUE");
		else
			System.out.println("1. FALSE");

		// *aa�� AAA�� ����Ű�� aa2�� AAA�� ����Ű�� �� ������
		// aa�� �޸� aa2�� AAA�� BBB ��� ���� �����ϴ�
	}

}
