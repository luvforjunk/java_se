package inheritance;

public class ChildTest extends SuperTest {
	private String name;
	private int age;

	public ChildTest(String name, int age, double w, double h) {
		super(w, h); // 부모 생성자 호출

		System.out.println("ChildTest 클래스 생성자");
		this.name = name;
		this.age = age;
		super.weight = w; // this.weight = w;
		super.height = h; // this.height = h;
	}

	public void disp() {
		System.out.println("ChildTest 클래스의 disp()");
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}

	public static void main(String[] args) {
		ChildTest aa = new ChildTest("홍길동", 25, 72.3, 185.3);
		aa.disp();
		System.out.println("--------------------");

		SuperTest bb = new ChildTest("코난", 13, 25.6, 158.7);
		bb.disp(); //메소드가 Override가 되면 참조값이 부모이건 자식이건 무조건 자식이 호출된다

	}

}
