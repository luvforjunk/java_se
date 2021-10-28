package multiArray;

public class Test {

	public static void main(String[] args) {
		int rand;
		int count = 0;

		for (int i = 1; i <= 50; i++) {
			rand = (int) (Math.random() * 100) + 1;
			System.out.println(rand + "");

			if (rand % 2 == 0)
				count++;
		} // for
		System.out.println();
		System.out.println("난수 50개 중 짝수의 개수 :" + count);

	}

}
