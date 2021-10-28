package array;

public class ArrayTest {

	public static void main(String[] args) {
		int[] ar;
		ar = new int[5]; // 배열은 한번 만들어지면 중간에 들어가지 못하고 없어지는 것도 안됨.
		System.out.println("배열명 ar = " + ar);
		ar[0] = 27;
		ar[1] = 36;
		ar[2] = 25;
		ar[3] = 78;
		ar[4] = 62;

		System.out.println("배열 크기 =" + ar.length);
		// for(int i=0; i<=4; i++)//i가 0부터 시작했기 때문에 4까지.
		for (int i = 0; i < ar.length; i++) {
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
		System.out.println();

		System.out.println("거꾸로 출력");
		for (int i = ar.length - 1; i >= 0; i--) {
			System.out.println("ar[" + i + "] =" + ar[i]);
		}
		System.out.println();

		System.out.println("짝수 데이터만 출력");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0)
				System.out.println("ar[" + i + "]" + ar[i]);
		}
		System.out.println();

		System.out.println("확장 for");
		for (int data : ar) {
			System.out.println(data);
		}
	}
}
