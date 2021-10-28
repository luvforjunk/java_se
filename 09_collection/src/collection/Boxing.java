package collection;

public class Boxing {

	public static void main(String[] args) {
		int a = 25;
		// double b = a; // 타입은 틀리지만 같은 기본형이라 에러 아님
		double b = (double) a / 3; // 강제형변환 / 자동형변환(3 ->3.0)

		String c = "25";
		// int d = c;
		// c는 String 타입으로 객체형이다
		// int형으로 형변환을 시킬 수 있을까? 아니
		// int d = (int)c; - error
		// int형으로 바꾸고 싶으면 ?
		// c가 객체형이니까 int를 객체화시킬 래퍼클래스는? Integer.
		int d = Integer.parseInt(c);

		int e = 5;
		Integer f = e; // AutoBoxing - 객체화되는 거니까
		// Integer f = new Integer(e); - JDK 5.0 이전

		Integer g = 5;
		int h = g; // UnAutoBoxing
		// int h = g.intValue(); - JDK 5.0이전에서 사용

	}

}
