package collection;

public class Boxing {

	public static void main(String[] args) {
		int a = 25;
		// double b = a; // Ÿ���� Ʋ������ ���� �⺻���̶� ���� �ƴ�
		double b = (double) a / 3; // ��������ȯ / �ڵ�����ȯ(3 ->3.0)

		String c = "25";
		// int d = c;
		// c�� String Ÿ������ ��ü���̴�
		// int������ ����ȯ�� ��ų �� ������? �ƴ�
		// int d = (int)c; - error
		// int������ �ٲٰ� ������ ?
		// c�� ��ü���̴ϱ� int�� ��üȭ��ų ����Ŭ������? Integer.
		int d = Integer.parseInt(c);

		int e = 5;
		Integer f = e; // AutoBoxing - ��üȭ�Ǵ� �Ŵϱ�
		// Integer f = new Integer(e); - JDK 5.0 ����

		Integer g = 5;
		int h = g; // UnAutoBoxing
		// int h = g.intValue(); - JDK 5.0�������� ���

	}

}
