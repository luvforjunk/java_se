package inheritance;

public class SubTest extends SuperTest { // SuperTest에서 상속받기
	// 우선 순위권은 SubTest. SubTest에서 갖고 있지 않으면 SuperTest로.
	private String name;
	private int age;

	public SubTest(String name, int age, double w, double h) { //생성자
		System.out.println("SubTest 클래스 생성자");
		this.name = name; 
		this.age = age; //내것도 내거
		super.weight = w; // this.weight = w; 부모 것도 내거
		super.height = h; // this.height = h;
	}

	public void output() {
		System.out.println("SubTest 클래스의 output()");
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}

	public static void main(String[] args) {
		SubTest aa = new SubTest("홍길동", 25, 72.3, 185.3); //메모리 설정
		//부모거까지 같이 잡아버린다.
		aa.output(); //불러내기
		System.out.println("-----------------");
		aa.disp(); // 우선 SubTest 클래스에서 찾고 없으면 SuperTest에서 찾는다.
		System.out.println("-----------------");

		SuperTest bb = new SubTest("코난", 13, 25.6, 158.7);
		//부모는 자식 클래스를 참조할 수 있다.
		// bb라는 클래스는 참조값을 SuperTest만 잡겠대
		// bb.output(); - error 절대 못 부름
		
		bb.disp(); //부를 수 있는 건 얘뿐.
	}
}

/*
 -error 
 1. 부모 클래스의 기본 생성자를 내놔랏! 
 기본 생성자 자동 호출 - 클래스 안에 생성자가 1도 없을 때만
 
 자식 클래스를 만들면 자식 클래스 본인과 부모를 한꺼번에 메모리에 생성한다.
 new 자식 클래스 + 생성자(2번 호출, 부모는 기본 생성자를 호출한다)
 자식 클래스는 절대 본인 것만 메모리에 만들지 않는다 부모꺼도 같이 만들지.
 */