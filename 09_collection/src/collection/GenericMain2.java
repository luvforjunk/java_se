package collection;

class GenericTest2<T> {
	private T a;

	public GenericTest2(T a) { // 생성자 - new할 때 한번 불림. 값을 수정할 때
		this.a = a;
	}

	public void setA(T a) { // setter - 맨 처음에 계속 둘 때
		this.a = a;

	}

	public T getA() {
		return a;
	}
}
//--------------------------------

public class GenericMain2 {

	public static void main(String[] args) {
		// GenericTest<?> aa = new GenericTest<String>();
		// Generic을 걸었지만 이 안에 들어가 있는 건 Object
		// aa.setA("홍길동"); - error : ?를 사용하면 반드시 생성자를 통해서만 전달된다
		GenericTest2<?> aa = new GenericTest2<String>("홍길동");
		String name = (String) aa.getA();
		System.out.println("이름 = " + name);

		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer) bb.getA(); // AutoUnBoxing - Casting
		System.out.println("나이 = " + age);
	}

}

// 기본형 -> 객체형 : AutoBoxing (객체화)
// 객체형 -> 기본형 : AutoUnBoxing