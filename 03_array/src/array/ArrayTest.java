package array;

public class ArrayTest {

	public static void main(String[] args) {
		int[] ar;
		ar = new int[5]; // �迭�� �ѹ� ��������� �߰��� ���� ���ϰ� �������� �͵� �ȵ�.
		System.out.println("�迭�� ar = " + ar);
		ar[0] = 27;
		ar[1] = 36;
		ar[2] = 25;
		ar[3] = 78;
		ar[4] = 62;

		System.out.println("�迭 ũ�� =" + ar.length);
		// for(int i=0; i<=4; i++)//i�� 0���� �����߱� ������ 4����.
		for (int i = 0; i < ar.length; i++) {
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
		System.out.println();

		System.out.println("�Ųٷ� ���");
		for (int i = ar.length - 1; i >= 0; i--) {
			System.out.println("ar[" + i + "] =" + ar[i]);
		}
		System.out.println();

		System.out.println("¦�� �����͸� ���");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0)
				System.out.println("ar[" + i + "]" + ar[i]);
		}
		System.out.println();

		System.out.println("Ȯ�� for");
		for (int data : ar) {
			System.out.println(data);
		}
	}
}
