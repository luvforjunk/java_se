package inheritance2;

public class FinalMain {
	public final String FRUIT = "사과";
	public final String FRUIT2;

	public static final String ANIMAL = "코알라";
	public static final String ANIMAL2;

	// static이라고 선언된 것들은 생성자를 맨 앞에 쓰면 된다.
	static {
		ANIMAL2 = "쿼카";
	}

	public FinalMain() {
		FRUIT2 = "딸기"; // 초기화
	}

	public static void main(String[] args) {
		final int AGE = 25;
		// AGE = 30; - error : final이기 때문에 변경할 수 없다
		System.out.println("AGE = " + AGE);

		final int AGE2; // 초기값을 안주면 자바는 한번 더 기회를 준다. C언어는 안됨
		AGE2 = 30;
		System.out.println("AGE2 = " + AGE2);

		FinalMain aa = new FinalMain();
		System.out.println("FRUIT = " + aa.FRUIT);
		System.out.println("FRUIT = " + aa.FRUIT2);

		System.out.println("ANIMAL = " + FinalMain.ANIMAL);
		System.out.println("ANIMAL2 = " + FinalMain.ANIMAL2);
	}

}
