package collection;

class GenericTest<T> {
	private T a;

	public void setA(T a) {
		this.a = a;

	}

	public T getA() {
		return a;
	}
}
//----------------

public class GenericMain {

	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>();
		// String이라는 글씨가 각 T에 매칭됨
		// 오로지 문자열만 집어넣을 수 있는 거
		aa.setA("홍길동");
		System.out.println("이름 = " + aa.getA());
		// aa.setA(250); -error : 문자열만 쓴다 했는데....

		GenericTest<Integer> bb = new GenericTest<Integer>();
		// 똑같은 커피인데 다른 타입으로
		// int처럼 기본형을 넣어줄 수 없다
		// Generic안에는 클래스만 들어갈 수 있다
		bb.setA(25);
		System.out.println("나이 = " + bb.getA());

	}

}
